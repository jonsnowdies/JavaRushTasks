package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    State state, newState = null;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run(){
        state = thread.getState();
        System.out.println(state);
        while (!state.equals(State.TERMINATED)){
            newState=thread.getState();
            if(!state.equals(newState)){
                state = newState;
                System.out.println(state);
            }
        }
        interrupt();
    }
}
