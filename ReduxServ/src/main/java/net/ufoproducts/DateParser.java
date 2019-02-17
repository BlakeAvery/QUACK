package net.ufoproducts;

import java.text.DateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseDate(String str) {
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(5, 7));
        int day = Integer.parseInt(str.substring(8, 10));
        int hour = Integer.parseInt(str.substring(11, 13));
        int minute = Integer.parseInt(str.substring(14, 16));
        int second = Integer.parseInt(str.substring(17, 19));
        return new Date(year - 1900, month - 1, day, hour, minute, second);// Fuck off "Deprecation"
    }
}
