package main;

import main.solution.*;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) {
        DuplicateNumber d = new DuplicateNumber();
        d.searchRange(new int[]{5,7,7,8,8,10},7);
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
