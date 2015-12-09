package vandy.mooc.view;

/**
 * Created by Admin on 06/12/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import vandy.mooc.R;
import vandy.mooc.model.AnnouncementMessage;
import vandy.mooc.model.RequestMessage;
import vandy.mooc.model.RequestReplyMessageBase;

public class AnnouncementBroadcaster extends Activity {


    private AnnouncementTextListAdapter mCustomAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_broadcaster);
        mCustomAdapter = new AnnouncementTextListAdapter(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    // broadcast a custom intent.
    public void broadcastIntent(View view) {
        // RelativeLayout view1 = (RelativeLayout) findViewById(R.id.announcement_broadcaster);
        EditText message_title =
                (EditText) findViewById(R.id.title);
        EditText message_detail =
                (EditText) findViewById(R.id.detail);


        AnnouncementMessage holder = new AnnouncementMessage();
        final String timestamp =
                new SimpleDateFormat("yyyyMMdd'_'HHmmss").format(new Date());
        holder.setMessageTime(timestamp);
        holder.setMessageTitle(message_title.getText().toString());
        holder.setMessageDetail(message_detail.getText().toString());
        mCustomAdapter.add(holder);

        Intent intent = new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        //extras.putString(RequestReplyMessageBase.MESSAGE_ID, message_title.getText().toString());
        intent.putExtra(RequestReplyMessageBase.MESSAGE_TIME, timestamp.toString());
        intent.putExtra(RequestReplyMessageBase.MESSAGE_TITLE, message_title.getText().toString());
        intent.putExtra(RequestReplyMessageBase.MESSAGE_DETAIL, message_detail.getText().toString());
        Intent intentS = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentS);
        getApplicationContext().sendBroadcast(intent);
    }
}