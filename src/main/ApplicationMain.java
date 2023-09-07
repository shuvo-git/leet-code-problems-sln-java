package main;

import main.parser.ExpressionParser2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/********************************************************
 * Name: Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        String exp = "(Q1A1 AND Q2A3) OR (Q3A3 OR Q4A1) AND (Q10A2 AND Q11-1A2 AND Q12A3R1 AND NOT Q13-1) ";
        ExpressionParser2 expressionParser = new ExpressionParser2(exp);
        expressionParser.evaluate("Q1A1 Q4A1 Q10A2 Q11-1A2 Q12A3R1");
        expressionParser.evaluate("Q1A1 Q1 Q4A1 Q10A2 Q11-1A2 Q12A3R1");
    }
}
