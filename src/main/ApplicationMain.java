package main;

import main.parser.ExpressionParser;
import main.solution.CoinChange;
import main.solution.SqrtX;

import javax.swing.text.html.Option;
import java.util.Optional;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        String exp = "(Q1A1 AND Q2A3) OR (Q3A3 OR Q4A1)";
        String ans = ExpressionParser.convertToNumericFormat(exp);
        System.out.println(ans);
    }
}


//        String startDate = TimeZoneHelperUtil.convertToSeoulTime(
//                "2022-11-15 00:00:00",
//                "Asia/Dhaka"
//
//        );
//
//        String endDate = TimeZoneHelperUtil.convertToSeoulTime(
//                "2022-11-15 23:59:59",
//                "Asia/Dhaka"
//
//        );
//
//        System.out.println(startDate + " - " + endDate);
//
//        String startDateOrig = TimeZoneHelperUtil.convertToZonedTime(
//                startDate,
//                "Asia/Dhaka"
//
//        );
//
//        String endDateOrig = TimeZoneHelperUtil.convertToZonedTime(
//                endDate,
//                "Asia/Dhaka"
//
//        );
//
//        System.out.println(startDateOrig + " - " + endDateOrig);
