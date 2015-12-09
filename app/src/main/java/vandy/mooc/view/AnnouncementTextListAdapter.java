package vandy.mooc.view;

/**
 * Created by Admin on 12/11/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vandy.mooc.R;
import vandy.mooc.model.AnnouncementMessage;

public class AnnouncementTextListAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private List<AnnouncementMessage> mItems = new ArrayList<AnnouncementMessage>();
    private final Context mContext;
    AnnouncementDatabaseHelper database;
    private static final String TAG = "Lab-UserInterface";


    public AnnouncementTextListAdapter(Context context) {
        mContext = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        database = new AnnouncementDatabaseHelper(mContext);


        mItems = database.getAnnouncementHolders();


    }

    // Add a ToDoItem to the adapter
    // Notify observers that the data set has changed

    public void add(AnnouncementMessage item) {
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
        View rowView = inflater.inflate(R.layout.announcement_list, null);
        final AnnouncementMessage holder = mItems.get(position);
        final TextView messagetitle = (TextView) rowView.findViewById(R.id.messagetitlelist);
        final TextView messageId = (TextView) rowView.findViewById(R.id.messageidlist);
        final TextView messageTime = (TextView) rowView.findViewById(R.id.messagetimelist);

        messageId.setText(String.valueOf(holder.getMessageId()));
        messageTime.setText(holder.getMessageTime());
        messagetitle.setText(holder.getMessageTitle());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DisplayAnnouncementActivity.class);
                intent.putExtra("Detail", holder.getMessageDetail());
                mContext.startActivity(intent);
            }
        });
        return rowView;
    }


}
