package main.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 7/28/2023
 * @time: 4:20 PM
 */


public class ExpressionParser2 {

    private final String PATTERN = "Q(\\d+)A(\\d+)(R\\d)?|Q(\\d+)-(\\d+)(A(\\d+))?";
    private final String PATTERN2 = "AND|OR|NOT|"+PATTERN;

    private final String expCondition;
    Set<String> variablesAll = new HashSet<>();
    Set<String> variablesVote = new HashSet<>();
    private String expConditionModified;

    public ExpressionParser2(String expCondition) {
        this.expCondition = expCondition;
        this.expConditionModified = this.expCondition;
    }

    public void evaluate(String voteStr) {
        extractVariablesFromCondition();
        extractVariablesFromVote(voteStr);
        convertToMathematicalFormat();
        convertToPostfix();
        evaluatePostfix();
    }

    public void extractVariablesFromCondition() {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(this.expCondition);

        while (matcher.find()) {
            System.out.println(matcher.group());
            this.variablesAll.add(matcher.group());
        }

        System.out.println("variablesAll: " + variablesAll);
    }

    public void extractVariablesFromVote(String vote) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(vote);

        while (matcher.find()) {
            System.out.println(matcher.group());
            this.variablesVote.add(matcher.group());
        }

        System.out.println("variablesVote: " + variablesVote);
    }

    public void convertToMathematicalFormat() {

        System.out.println(this.expConditionModified);


        Pattern pattern = Pattern.compile(PATTERN2);
        Matcher matcher = pattern.matcher(this.expConditionModified);
        StringBuffer outputExpression = new StringBuffer();

        while (matcher.find()) {
            if (matcher.group().equals("NOT")) {
                matcher.appendReplacement(outputExpression, "!");
            } else if (matcher.group().equals("AND")) {
                matcher.appendReplacement(outputExpression, "&");
            } else if (matcher.group().equals("OR")) {
                matcher.appendReplacement(outputExpression, "|");
            } else {
                String matched = matcher.group();
                String trueOrFalse = variablesVote.contains(matched) ? "1" : (variablesAll.contains(matched) ? "0" : matched);
                matcher.appendReplacement(outputExpression, trueOrFalse);
//                String numFormat = "(" + matcher.group(1) + "-" + matcher.group(2) + ")";
//                matcher.appendReplacement(outputExpression, numFormat);

            }
        }

        this.expConditionModified = matcher.appendTail(outputExpression).toString();

        System.out.println(this.expConditionModified);
    }


    private boolean isOperator(char ch) {
        return ch == '&' || ch == '|' || ch == '!';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '&':
                return 2;
            case '|':
                return 1;
            case '!':
                return 3;
            default:
                return -1;
        }
    }

    public void convertToPostfix() {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char ch : expConditionModified.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop '(' from the stack
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        System.out.println(postfix.toString());
        this.expConditionModified = postfix.toString();
    }

    private void evaluatePostfix() {
        Stack<Boolean> operandStack = new Stack<>();

        for (char ch : expConditionModified.toCharArray()) {
            if (Character.isDigit(ch)) {
                operandStack.push(ch == '0' ? false : true); // Convert char digit to integer
            }
            if (ch == '!') {
                Boolean operand = operandStack.pop();
                operandStack.push(!operand);
            } else if (ch == '|') {
                Boolean operand2 = operandStack.pop();
                Boolean operand1 = operandStack.pop();
                operandStack.push(operand1 || operand2);
            } else if (ch == '&') {
                Boolean operand2 = operandStack.pop();
                Boolean operand1 = operandStack.pop();
                operandStack.push(operand1 && operand2);
            }
        }

        System.out.println(operandStack.pop());
    }

}
