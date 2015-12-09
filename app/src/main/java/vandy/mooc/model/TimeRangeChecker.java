package vandy.mooc.model;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 06/12/2015.
 */

public class TimeRangeChecker {
    public static int getHour(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    public static int getMinute(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }

    public static boolean isBetween(DateTime now, DateTime prayerStart, DateTime prayerEnd) {
        return (now.isAfter(prayerStart) && now.isBefore(prayerEnd));
    }

}