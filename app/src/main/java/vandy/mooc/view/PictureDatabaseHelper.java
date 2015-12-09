package vandy.mooc.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vandy.mooc.model.PictureInfo;

public class PictureDatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "database_name";

    // Table Names
    private static final String DB_TABLE = "table_image";

    // column names
    private static final String KEY_NAME = "image_name";
    private static final String KEY_IMAGE = "image_data";

    // Table create statement
    private static final String CREATE_TABLE_IMAGE = "CREATE TABLE " + DB_TABLE + "(" +
            KEY_NAME + " TEXT," +
            KEY_IMAGE + " BLOB);";

    public PictureDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating table
        db.execSQL(CREATE_TABLE_IMAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        // create new table
        onCreate(db);
    }

    public void addEntry(PictureInfo holder) throws SQLiteException {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, holder.getPictureName());
        cv.put(KEY_IMAGE, DbBitmapUtility.getBytes(holder.getBitmap()));
        getWritableDatabase().insert(DB_TABLE, null, cv);
    }

    public void deleteRowCounter(PictureInfo holder) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DB_TABLE, KEY_NAME + "=?",
                new String[]{holder.getPictureName()});
    }

    public List<PictureInfo> getImagesHolders() {
        ArrayList<PictureInfo> holders = new ArrayList<PictureInfo>();
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
            PictureInfo holder = new PictureInfo();

            int idColIndex = holderCursor.getColumnIndex(KEY_NAME);
            holder.setPictureName(holderCursor.getString(idColIndex));
            int idColIndex2 = holderCursor.getColumnIndex(KEY_IMAGE);
            holder.setBitmap(DbBitmapUtility.getImage(holderCursor.getBlob(idColIndex2)));
            holders.add(holder);
        }
        holderCursor.close();
        return holders;
    }
}