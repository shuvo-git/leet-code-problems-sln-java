package main;

import main.solution.PrimeNumber;
import main.solution.Sort;
import main.solution.SqrtX;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) {
        Sort s = new Sort();
        s.findMedianSortedArrays(new int[]{1,4,7,8,10},new int[]{-1,6,9,13});
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
