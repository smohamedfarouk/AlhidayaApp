package vandy.mooc.view;

/**
 * Created by Admin on 12/11/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vandy.mooc.R;
import vandy.mooc.model.PictureInfo;

public class ImageTextListAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private List<PictureInfo> mItems = new ArrayList<PictureInfo>();
    private final Context mContext;
    PictureDatabaseHelper database;
    private static final String TAG = "Lab-UserInterface";


    public ImageTextListAdapter(Context context) {
        mContext = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        database = new PictureDatabaseHelper(mContext);


        mItems = database.getImagesHolders();



    }

    // Add a ToDoItem to the adapter
    // Notify observers that the data set has changed

    public void add(PictureInfo item) {
        mItems.add(item);
        database.addEntry(item);
        notifyDataSetChanged();
    }

    // Clears the list adapter of all items.

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    // Returns the number of ToDoItems

    @Override
    public int getCount() {
        return mItems.size();
    }

    // Retrieve the number of ToDoItems

    @Override
    public Object getItem(int pos) {
        return mItems.get(pos);
    }

    // Get the ID for the ToDoItem
    // In this case it's just the position

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    // Create a View for the ToDoItem at specified position
    // Remember to check whether convertView holds an already allocated View
    // before created a new View.
    // Consider using the ViewHolder pattern to make scrolling more efficient
    // See: http://developer.android.com/training/improving-layouts/smooth-scrolling.html

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = inflater.inflate(R.layout.image_list, null);
        final PictureInfo holder = mItems.get(position);
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        TextView textView = (TextView) rowView.findViewById(R.id.textView1);
        final ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
        textView.setText(holder.getPictureName());
        //final Bitmap picBitmap = BitmapFactory.decodeFile(holder.getImage().getPath());
        final Bitmap picBitmap = holder.getBitmap();
        imageView.setImageBitmap(picBitmap);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enlargeImageIntent = new Intent(mContext, DisplayImageActivity.class);
                enlargeImageIntent.putExtra("BitmapImage", picBitmap);
                mContext.startActivity(enlargeImageIntent);
            }
        });
        return rowView;
    }


}
