package com.example.BusTimeTable;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DbAdapter {
    /*----------------------Bus Details--------------------------*/
    public static final String KEY_TIME = "time";
    public static final String KEY_DAY = "day";
    public static final String BUS_STOP_ = "bus_stop";
    public static final String BUS_TAWN = "city";
    public static final String BUS_ROWID = "_id";


    /*---------------------Map Details ---------------------------*/

    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_TITLE = "title";
    public static final String KEY_ROWID = "_id";

    private static final String TAG = "NotesDbAdapter";

    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE = "notes";
    /*--------------Call Details ----------------------------------*/
    public static final String KEY_PHONE ="phone";
    public static final String KEY_CITY = "title";
    public static final String CALL_ROWID = "_id";


    DatabaseHellp mDbHelper;
    SQLiteDatabase mDb;
    Cursor cursor;




    private static final String CALL_TABLE = "call";
    private static final int DATABASE_VERSION = 2;
    private static final String BUS_TABLE = "bustime";
    private final Context mCtx;

    public DbAdapter(Context context)
    {
        this.mCtx = context;
    }

    public DbAdapter open() throws SQLException
    {
        mDbHelper = new DatabaseHellp(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public Cursor fetchAllNotes() {

        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE,
                KEY_LONGITUDE,KEY_LATITUDE  }, null, null, null, null, null);
    }
    public Cursor fetchAllPhone() {

        return mDb.query(CALL_TABLE, new String[] {CALL_ROWID, KEY_CITY,
                KEY_PHONE  }, null, null, null, null, null);
    }


}
