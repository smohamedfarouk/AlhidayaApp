package vandy.mooc.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import vandy.mooc.R;


/**
 * An Activity that displays all the images that have been downloaded
 * and processed.
 */

public class DisplayImageActivity extends Activity {
    ImageView image;
    Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_image_activity);
        Intent intent = getIntent();
        bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
        image = (ImageView) findViewById(R.id.imageEnlarged);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setImageBitmap(bitmap);
    }


}

