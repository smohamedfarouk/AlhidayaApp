package vandy.mooc.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vandy.mooc.model.AnnouncementMessage;
import vandy.mooc.model.PictureInfo;

public class AnnouncementDatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "database_name_annoucement_new";

    // Table Names
    private static final String DB_TABLE = "announcement_message";

    // column names
    private static final String MESSAGE_ID = "message_id";
    private static final String MESSAGE_TIME = "message_time";
    private static final String MESSAGE_TITLE = "message_title";
    private static final String MESSAGE_DETAIL = "message_detail";


    // Table create statement
    private static final String CREATE_TABLE_ANNOUNCEMENT = "CREATE TABLE " + DB_TABLE + "(" +
            MESSAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MESSAGE_TIME + " TEXT," +
            MESSAGE_TITLE + " TEXT," +
            MESSAGE_DETAIL + "  TEXT) ";

    public AnnouncementDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating table
        db.execSQL(CREATE_TABLE_ANNOUNCEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        // create new table
        onCreate(db);
    }

    public void addEntry(AnnouncementMessage holder) throws SQLiteException {
        ContentValues cv = new ContentValues();
        cv.put(MESSAGE_TIME, holder.getMessageTime());
        cv.put(MESSAGE_TITLE, holder.getMessageTitle());
        cv.put(MESSAGE_DETAIL, holder.getMessageDetail());
        getWritableDatabase().insert(DB_TABLE, null, cv);
    }

    public void deleteRowCounter(AnnouncementMessage holder) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DB_TABLE, MESSAGE_ID + "=?",
                new String[]{String.valueOf(holder.getMessageId())});
    }

    public List<AnnouncementMessage> getAnnouncementHolders() {
        ArrayList<AnnouncementMessage> holders = new ArrayList<AnnouncementMessage>();
        // Gets the database in the current database helper in read-only mode
        SQLiteDatabase db = getReadableDatabase();

        // After the query, the cursor points to the first database row
        // returned by the request.
        Cursor holderCursor = db.query(DB_TABLE, null, null,
                null, null, null, null);
        while (holderCursor.moveToNext()) {
            // Get the value for each column for the database row pointed by
            // the cursor using the getColumnIndex method of the cursor and
            // use it to initialize a Project object by database row
            AnnouncementMessage holder = new AnnouncementMessage();

            int idColIndex = holderCursor.getColumnIndex(MESSAGE_ID);
            holder.setMessageId(holderCursor.getInt(idColIndex));
            int idColIndex2 = holderCursor.getColumnIndex(MESSAGE_TIME);
            holder.setMessageTime(holderCursor.getString(idColIndex2));
            int idColIndex3 = holderCursor.getColumnIndex(MESSAGE_TITLE);
            holder.setMessageTitle(holderCursor.getString(idColIndex3));
            int idColIndex4 = holderCursor.getColumnIndex(MESSAGE_DETAIL);
            holder.setMessageDetail(holderCursor.getString(idColIndex4));
            holders.add(holder);
        }
        holderCursor.close();
        return holders;
    }
}