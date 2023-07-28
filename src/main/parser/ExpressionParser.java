package main.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 7/28/2023
 * @time: 4:20 PM
 */


public class ExpressionParser {
    Map<String, Boolean> variables = new HashMap<>();


    public static String convertToNumericFormat(String inputExpression) {
        Pattern pattern = Pattern.compile("AND|OR|Q(\\d+)A(\\d+)");
        Matcher matcher = pattern.matcher(inputExpression);
        StringBuffer outputExpression = new StringBuffer();

        while (matcher.find()) {
            if (matcher.group().equals("AND")) {
                matcher.appendReplacement(outputExpression, "*");
            } else if (matcher.group().equals("OR")) {
                matcher.appendReplacement(outputExpression, "+");
            } else {
                String numFormat = "(" + matcher.group(1) + "-" + matcher.group(2) + ")";
                matcher.appendReplacement(outputExpression, numFormat);
            }
        }

        matcher.appendTail(outputExpression);
        return outputExpression.toString();
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

    // Actual parsing logic
    private boolean parseExpression(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Boolean> operands = new Stack<>();
        StringBuilder variableName = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                variableName.append(ch);
            } else {
                if (variableName.length() > 0) {
                    String var = variableName.toString();
                    boolean value = variables.getOrDefault(var, false);
                    operands.push(value);
                    variableName.setLength(0);
                }

                if (isOperator(ch)) {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                        evaluate(operators, operands);
                    }
                    operators.push(ch);
                } else if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        evaluate(operators, operands);
                    }
                    operators.pop(); // Pop '('
                }
            }
        }

        if (variableName.length() > 0) {
            String var = variableName.toString();
            boolean value = variables.getOrDefault(var, false);
            operands.push(value);
        }

        while (!operators.isEmpty()) {
            evaluate(operators, operands);
        }

        return operands.pop();
    }

    private void evaluate(Stack<Character> operators, Stack<Boolean> operands) {
        char operator = operators.pop();
        if (operator == '!') {
            boolean operand = operands.pop();
            operands.push(!operand);
        } else {
            boolean operand2 = operands.pop();
            boolean operand1 = operands.pop();
            if (operator == '&') {
                operands.push(operand1 && operand2);
            } else if (operator == '|') {
                operands.push(operand1 || operand2);
            }
        }
    }
}
