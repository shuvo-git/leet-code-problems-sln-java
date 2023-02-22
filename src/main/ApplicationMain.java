package main;

import main.solution.PrimeNumber;
import main.solution.Sort;
import main.solution.SqrtX;
import main.solution.StringProcessing;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) {
        StringProcessing s = new StringProcessing();
        int a = s.myAtoi(".1");
        System.out.println(a);
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
