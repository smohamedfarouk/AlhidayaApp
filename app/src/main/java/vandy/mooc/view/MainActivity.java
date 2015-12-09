package vandy.mooc.view;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import vandy.mooc.R;
import vandy.mooc.model.PictureInfo;

public class MainActivity extends Activity {
   // private static final int REQUEST_IMAGE_CAPTURE = 1;


    //private ListView lv;

  //  private ImageTextListAdapter mCustomAdapter;


  private ListView lv;
  private AnnouncementTextListAdapter mCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   LinearLayout rl = (LinearLayout)findViewById(R.id.activity_main);
        rl.setBackgroundColor(getResources().getColor(android.R.color.white));
*/
      //  ListView view = ()findViewById(R.id.activity_main);

        // Find the root view
         //    View root = someView.getRootView();
      //  view.setBackgroundColor(Color.parseColor("#fffff"));
        // Set the color
       // view.setBackgroundColor(getResources().getColor(android.R.color.white));
        // RequestWindowFeature (Window.FEATURE_ACTION_BAR);
        getActionBar().setIcon(R.drawable.namaz);


        mCustomAdapter = new AnnouncementTextListAdapter(getApplicationContext());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            PictureInfo holder = new PictureInfo();
            final String timestamp =
                    new SimpleDateFormat("yyyyMMdd'_'HHmmss").format(new Date());
            holder.setPictureName(timestamp);
            holder.setBitmap(imageBitmap);
            mCustomAdapter.add(holder);
        }

    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.action_camera:
                //Open a camera
                dispatchTakePictureIntent();
                return true;*/
            case R.id.prayer_times:
                //Show Prayer Timings
                dispatchShowPrayerTimingsIntent();
                return true;
            case R.id.qibla_direction:
                //Show Prayer Timings
                dispatchShowQiblaDirectionIntent();
                return true;
            case R.id.announcement_broadcaster:
                //Show Prayer Timings
                dispatchShowBroadcastIntent();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void dispatchShowBroadcastIntent() {
        Intent intent = new Intent(this, AnnouncementBroadcaster.class);
        startActivity(intent);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      //      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void dispatchShowQiblaDirectionIntent() {
        Intent intent = new Intent(this, QiblaDirectionActivity.class);
        startActivity(intent);
    }

    private void dispatchShowPrayerTimingsIntent() {
        Intent intent = new Intent(this, PrayerTimesActivity.class);
        startActivity(intent);

    }

    @Override
    public void onResume() {
        super.onResume();
        lv = (ListView) findViewById(R.id.listView);
        mCustomAdapter = new AnnouncementTextListAdapter(this);
        lv.setAdapter(mCustomAdapter);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

}