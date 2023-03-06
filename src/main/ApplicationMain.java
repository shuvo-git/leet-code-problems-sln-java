package main;

import main.solution.*;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) {
//        BinarySearch s = new BinarySearch();
//        s.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);

//        StringProcessing sp = new StringProcessing();
//        int k = sp.compress(new char[]{'a','b','c'});

        Numbers numbers = new Numbers();
        int f = numbers.findKthPositive2(new int[]{2,3,4,7,11,20,25},3);
        System.out.println(f);
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
