package vandy.mooc.view;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.joda.time.DateTime;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vandy.mooc.R;
import vandy.mooc.model.TimeRangeChecker;

/**
 * Created by Admin on 14/11/2015.
 */
public class PrayerTimesActivity extends Activity {
    private AlarmManager mAlarmManager;
    private Intent mNotificationReceiverIntent, mLoggerReceiverIntent;
    private PendingIntent mNotificationReceiverPendingIntent,
            mLoggerReceiverPendingIntent;
    private static final long INITIAL_ALARM_DELAY = 0;
    private static final long ALARM_DELAY = 1 * 60 * 1000L;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Get the AlarmManager Service
        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Create an Intent to broadcast to the AlarmNotificationReceiver
        mNotificationReceiverIntent = new Intent(PrayerTimesActivity.this,
                AlarmNotificationReceiver.class);

        // Create an PendingIntent that holds the NotificationReceiverIntent
        mNotificationReceiverPendingIntent = PendingIntent.getBroadcast(
                PrayerTimesActivity.this, 0, mNotificationReceiverIntent, 0);

        // mAlarmManager.cancel(mNotificationReceiverPendingIntent); // cancel any existing alarms

        // Set single alarm
        //   mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), mNotificationReceiverPendingIntent);

        //is toCheck between the two?

/*

        DateTime dtNow = new DateTime();
        DateTime prayerStart = new DateTime(dtNow.getYear(), dtNow.getMonthOfYear(), dtNow.getDayOfYear(),
                TimeRangeChecker.getHour(getResources().getString(R.string.fajr_start)), TimeRangeChecker.getMinute(getResources().getString(R.string.fajr_start)), 0, 0);
        DateTime prayerEnd = new DateTime(dtNow.getYear(), dtNow.getMonthOfYear(), dtNow.getDayOfYear(),
                TimeRangeChecker.getHour(getResources().getString(R.string.fajr_end)), TimeRangeChecker.getMinute(getResources().getString(R.string.fajr_end)), 0, 0);
*/

       // if (TimeRangeChecker.isBetween(dtNow, prayerStart, prayerEnd)) {

            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + INITIAL_ALARM_DELAY,ALARM_DELAY,
                    mNotificationReceiverPendingIntent);
      //  }


        setContentView(R.layout.prayer_times);
        LinearLayout layout = (LinearLayout) findViewById(R.id.prayer_times);

        TextView fajr_start = (TextView) findViewById(R.id.fajr_start);
        fajr_start.setText(getResources().getString(R.string.fajr_start));

        TextView fajr_end = (TextView) findViewById(R.id.fajr_end);
        fajr_end.setText(getResources().getString(R.string.fajr_end));

        TextView dohr_start = (TextView) findViewById(R.id.dohr_start);
        dohr_start.setText(getResources().getString(R.string.dohr_start));
        TextView dohr_end = (TextView) findViewById(R.id.dohr_end);
        dohr_end.setText(getResources().getString(R.string.dohr_end));

        TextView asr_start = (TextView) findViewById(R.id.asr_start);
        asr_start.setText(getResources().getString(R.string.asr_start));
        TextView asr_end = (TextView) findViewById(R.id.asr_end);
        asr_end.setText(getResources().getString(R.string.asr_end));

        TextView magrib_start = (TextView) findViewById(R.id.magrib_start);
        magrib_start.setText(getResources().getString(R.string.magrib_start));
        TextView magrib_end = (TextView) findViewById(R.id.magrib_end);
        magrib_end.setText(getResources().getString(R.string.magrib_end));

        TextView isha_start = (TextView) findViewById(R.id.isha_start);
        isha_start.setText(getResources().getString(R.string.isha_start));
        TextView isha_end = (TextView) findViewById(R.id.isha_end);
        isha_end.setText(getResources().getString(R.string.isha_end));


        TextView dua_id = (TextView) findViewById(R.id.dua_id);




/*
        String s = "";

        for (int x = 0; x <= 100; x++) {
            s += "Line: " + String.valueOf(x) + "\n";
        }*/

        dua_id.setMovementMethod(new ScrollingMovementMethod());

        dua_id.setText(R.string.dua);


    }


}
