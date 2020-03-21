package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
                pair.getValue().send(message);
        } catch (IOException e) {
            System.out.println("The Message was not sent");
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
        } catch (IOException e) {
            ConsoleHelper.writeMessage("The Error has Occurred");
        }
        ConsoleHelper.writeMessage("The Server is Running");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Error!");
                serverSocket.close();
                break;
            }
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message m;
            String name;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                m = connection.receive();
                name = m.getData();
                if (m.getType() == MessageType.USER_NAME && !name.isEmpty() && !connectionMap.containsKey(name)) break;
            }
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (pair.getKey() == userName) continue;
                connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message m = connection.receive();
                if (m.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + m.getData()));
                else ConsoleHelper.writeMessage("Error!");
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("Connected with" + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error!");
            }
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            if (userName != null)
                connectionMap.remove(userName);
            ConsoleHelper.writeMessage("Connection with " + socket.getRemoteSocketAddress() + " closed");
        }
    }
}
