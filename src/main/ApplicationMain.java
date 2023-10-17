package main;

import main.parser.ExpressionParser2;
import main.solution.CoinChange;

/********************************************************
 * Name: Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {

        CoinChange cc = new CoinChange();

        int coins[] = {1,2,5};
        int size = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is "
                + cc.coinChange(coins, V));

//        String exp = "(Q1A1 AND Q2A3) OR (Q3A3 OR Q4A1) AND (Q10A2 AND Q11-1A2 AND Q12A3R1 AND NOT Q13-1) ";
//        ExpressionParser2 expressionParser = new ExpressionParser2(exp);
//        expressionParser.evaluate("Q1A1 Q4A1 Q10A2 Q11-1A2 Q12A3R1");
//        expressionParser.evaluate("Q1A1 Q1 Q4A1 Q10A2 Q11-1A2 Q12A3R1");
    }
}
