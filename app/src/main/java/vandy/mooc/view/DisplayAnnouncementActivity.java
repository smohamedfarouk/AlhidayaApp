package vandy.mooc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import vandy.mooc.R;


/**
 * An Activity that displays all the images that have been downloaded
 * and processed.
 */

public class DisplayAnnouncementActivity extends Activity {
    TextView messageDetail;
    String detail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_detail_activity);
        Intent intent = getIntent();
        detail = intent.getExtras().getString("Detail");
        messageDetail = (TextView) findViewById(R.id.messagedetail_detail);
        messageDetail.setText(detail);

    }


}

