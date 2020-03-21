package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        if (countOperation == 0) {
            Pattern p = Pattern.compile("[\\\\*\\\\/+^cit-]");
            Matcher m = p.matcher(expression);
            while (m.find()) {
                countOperation++;
            }
        }
        String newRecursiveExpression = getExpressionWithoutWhspaceAndOddBracer(expression);
        try {
            double zaebaloUzhe = Math.round(Double.parseDouble(newRecursiveExpression) * 100) / 100.0;
            NumberFormat nf = new DecimalFormat("#.######");
            System.out.println(nf.format(zaebaloUzhe) + " " + countOperation);

            return;
        } catch (Exception e) {
        }


        String partOfExpression = getPartOfExpressionWithoutBracer(newRecursiveExpression);


        Pattern p = Pattern.compile("cos-?[0-9.]+|sin-?[0-9.]+|tan-?[0-9.]+");
        Matcher m = p.matcher(partOfExpression);
        while (m.find()) {
            String resultOfOperation = null;
            Double number = Double.parseDouble(partOfExpression.substring(m.start() + 3, m.end()));
            String mathOperation = partOfExpression.substring(m.start(), m.start() + 3);

            switch (mathOperation) {
                case "cos":
                    resultOfOperation = String.valueOf(Math.cos((Math.PI * number) / 180));
                    break;
                case "sin":
                    resultOfOperation = String.valueOf(Math.sin((Math.PI * number) / 180));
                    break;
                case "tan":
                    resultOfOperation = String.valueOf(Math.tan((Math.PI * number) / 180));
                    break;
            }
            newRecursiveExpression = newRecursiveExpression.replaceFirst(m.group(), resultOfOperation);
            recurse(newRecursiveExpression, countOperation);
            return;
        }

        p = Pattern.compile("(([+-\\\\*\\\\/]-)?|^-]?)[0-9.]+\\^-?[0-9.]+");
        m = p.matcher(partOfExpression);
        while (m.find()) {
            String resultOfOperation = null;
            int startIndex = m.start();
            int endIndex = m.end();
            int indexOfOperation = m.group().indexOf("^") + startIndex;

            if (m.group().substring(1, 2).equals("-")) {
                startIndex++;
            }
            Double numberLeft = Double.parseDouble(partOfExpression.substring(startIndex, indexOfOperation));
            Double numberRight = Double.parseDouble(partOfExpression.substring(indexOfOperation + 1, endIndex));

            resultOfOperation = String.valueOf(Math.pow(numberLeft, numberRight));
            newRecursiveExpression = newRecursiveExpression.replace(partOfExpression.substring(startIndex, endIndex), resultOfOperation);
            recurse(newRecursiveExpression, countOperation);
            return;
        }

        p = Pattern.compile("(([+-\\\\*\\\\/]-)?|^-]?)[0-9.]+[\\\\*\\\\/]-?[0-9.]+");
        m = p.matcher(partOfExpression);

        while (m.find()) {
            String resultOfOperation = null;
            int indexOfOperation;
            int startIndex = m.start();
            int endIndex = m.end();


            Matcher matcherForFindChar = Pattern.compile("[0-9.]+.").matcher(m.group());
            matcherForFindChar.find();

            indexOfOperation = matcherForFindChar.end() - 1 + startIndex;

            if (m.group().substring(1, 2).equals("-")) {
                startIndex++;
            }
            Double numberLeft = Double.parseDouble(partOfExpression.substring(startIndex, indexOfOperation));
            Double numberRight = Double.parseDouble(partOfExpression.substring(indexOfOperation + 1, endIndex));

            if (partOfExpression.charAt(indexOfOperation) == '*') {
                resultOfOperation = String.valueOf(numberLeft * numberRight);
            } else resultOfOperation = String.valueOf(numberLeft / numberRight);

            newRecursiveExpression = newRecursiveExpression.replace(partOfExpression.substring(startIndex, endIndex), resultOfOperation);
            recurse(newRecursiveExpression, countOperation);
            return;
        }


        p = Pattern.compile("(([+-\\\\*\\\\/]-)?|^-]?)[0-9.]+[+-]-?[0-9.]+");
        m = p.matcher(partOfExpression);

        while (m.find()) {
            String resultOfOperation = null;
            int indexOfOperation;
            int startIndex = m.start();
            int endIndex = m.end();


            Matcher matcherForFindChar = Pattern.compile("[0-9.]+.").matcher(m.group());
            matcherForFindChar.find();

            indexOfOperation = matcherForFindChar.end() - 1 + startIndex;

            if (m.group().substring(1, 2).equals("-")) {
                startIndex++;
            }
            Double numberLeft = Double.parseDouble(partOfExpression.substring(startIndex, indexOfOperation));
            Double numberRight = Double.parseDouble(partOfExpression.substring(indexOfOperation + 1, endIndex));

            if (partOfExpression.charAt(indexOfOperation) == '+') {
                resultOfOperation = String.valueOf(numberLeft + numberRight);
            } else resultOfOperation = String.valueOf(numberLeft - numberRight);

            newRecursiveExpression = newRecursiveExpression.replace(partOfExpression.substring(startIndex, endIndex), resultOfOperation);
            recurse(newRecursiveExpression, countOperation);
            return;
        }

        //implement
    }


    public String getPartOfExpressionWithoutBracer(String expression) {
        String expressionWithoutBracer = expression;
        LinkedList<Integer> openBracer = new LinkedList<>();
        LinkedList<Integer> closeBracer = new LinkedList<>();

        Pattern p = Pattern.compile("\\(|\\)");
        Matcher m = p.matcher(expression);
        while (m.find()) {
            if (m.group().matches("\\(")) {
                openBracer.add(m.start());
            }
            if (m.group().matches("\\)")) {
                closeBracer.add(m.start());
            }

            if (openBracer.size() == closeBracer.size()) {
                if (openBracer.getLast() > closeBracer.getFirst()) {
                    openBracer.pollLast();
                    openBracer.pollLast();
                    closeBracer.pollFirst();
                    closeBracer.pollFirst();
                }
                expressionWithoutBracer = expression.substring(openBracer.getLast() + 1, closeBracer.getFirst());
                break;
            }

        }
        return expressionWithoutBracer;
    }

    public String getExpressionWithoutWhspaceAndOddBracer(String expression) {
        String changedExpression = expression.replaceAll(" ", "");
        Pattern p = Pattern.compile("\\(-?[0-9.]+\\)");
        Matcher m = p.matcher(changedExpression);
        while (m.find()) {

            String expressionWithoutBracers = m.group().replace("(", "").replace(")", "");
            changedExpression = changedExpression.replace(m.group(), expressionWithoutBracers);

        }
        return changedExpression;
    }

    public Solution() {
        //don't delete

    }
}
