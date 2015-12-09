package vandy.mooc.view;

/**
 * Created by Admin on 06/12/2015.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import vandy.mooc.model.RequestReplyMessageBase;

public class AnnouncementReceiver extends BroadcastReceiver {

    // Notification ID to allow for future updates
    private static final int MY_NOTIFICATION_ID = 2;
    private static final String TAG = "AnnouncementReceiver";


    // Notification Action Elements
    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        /*extras.getInt(RequestReplyMessageBase.MESSAGE_ID);
        String messageTime = extras.getString(RequestReplyMessageBase.MESSAGE_TIME);
       */
        String messageTitle = extras.getString(RequestReplyMessageBase.MESSAGE_TITLE);
        String messageDetail = extras.getString(RequestReplyMessageBase.MESSAGE_DETAIL);

       // Notification Text Elements
        final CharSequence tickerText = "Alhidaya Annoucement!";
       /*  final CharSequence contentTitle = "Check the App Now!";
        final CharSequence contentText = "Annoucement for you!!";
*/

        // The Intent to be used when the user clicks on the Notification View
        mNotificationIntent = new Intent(context, DisplayAnnouncementActivity.class);
        mNotificationIntent.putExtra("Detail","sasas");
        // The PendingIntent that wraps the underlying Intent
        mContentIntent = PendingIntent.getActivity(context, 0,
                mNotificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Build the Notification
        Notification.Builder notificationBuilder = new Notification.Builder(
                context).setTicker(tickerText)
                .setSmallIcon(context.getResources().getIdentifier("namaz", "drawable", context.getPackageName()))
                .setAutoCancel(true).setContentTitle(messageTitle)
                .setContentText(messageTitle).setContentIntent(mContentIntent);
        // .setSound(soundURI).setVibrate(mVibratePattern);

        // Get the NotificationManager
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // Pass the Notification to the NotificationManager:
        mNotificationManager.notify(MY_NOTIFICATION_ID,
                notificationBuilder.build());

        // Log occurence of notify() call
        System.out.println(TAG + "Sending notification at:"
                + DateFormat.getDateTimeInstance().format(new Date()));

        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
    }
}