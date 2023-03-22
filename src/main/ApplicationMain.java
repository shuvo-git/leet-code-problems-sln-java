package main;

import main.solution.CoinChange;

import javax.swing.text.html.Option;
import java.util.Optional;

/********************************************************
 * {@link Name: } Jobayed Ullah
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        TestForOptional t = new TestForOptional();
        Abcd x = Optional.ofNullable(t.getAbcd()).orElseThrow(Exception::new);
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
