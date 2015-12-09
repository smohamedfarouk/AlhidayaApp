package vandy.mooc.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Admin on 12/11/2015.
 */
public class PictureInfo {
    private String pictureName;

    private Bitmap bitmap;

    public PictureInfo() {

    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

}