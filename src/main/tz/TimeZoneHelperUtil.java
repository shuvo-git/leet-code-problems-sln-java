package main.tz;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneHelperUtil {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String convertToSeoulTime(String timeGiven, String timeZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(timeGiven,dtf);
        System.out.println(localDateTime);

        ZoneId givenTz = ZoneId.of(timeZone);
        ZonedDateTime zonedDateTime = localDateTime.atZone( givenTz) ;

        ZoneId seol = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdtSeoul = zonedDateTime.withZoneSameInstant(seol);

        LocalDateTime seoulLocalDT = zdtSeoul.toLocalDateTime();
        return dtf.format(seoulLocalDT);
    }

    public static String convertToZonedTime(String timeGiven, String timeZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(timeGiven,dtf);
        System.out.println(localDateTime);


        ZoneId seol = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdtSeoul = localDateTime.atZone(seol);

        ZoneId givenTz = ZoneId.of(timeZone);
        ZonedDateTime zonedDateTime = zdtSeoul.withZoneSameInstant( givenTz) ;


        LocalDateTime zonedLocalDT = zonedDateTime.toLocalDateTime();
        return dtf.format(zonedLocalDT);
    }
}
