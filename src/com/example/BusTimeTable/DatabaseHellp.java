package com.example.BusTimeTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHellp extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "data";
        DatabaseHellp mDbHelper;
        private SQLiteDatabase mDb;

        /*----------------------------Map Db -----------------------------*/
        private static final String DATABASE_CREATE =
                "CREATE TABLE notes (_id integer primary key autoincrement, "
                        + "title text not null, latitude real, longitude real);";

        /*-------------------------------Call Db -----------------------*/
        private static final String CALL_CREATE =
                "CREATE TABLE call (_id integer primary key autoincrement, "
                        + "title text not null, phone real);";

        /*----------------------Bus Details--------------------------*/
        private static final String BUS_CREATE = "CREATE TABLE bustime (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "city TEXT, " +
                "bus_stop TEXT, " +
                "day TEXT, " +
                " time TEXT )";



        private static final String CALL_TABLE = "call";
        private static final int DATABASE_VERSION = 2;
        private static final String BUS_TABLE = "bustime";
        private final Context mCtx = null;



        public DatabaseHellp(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
            db.execSQL(CALL_CREATE);
            db.execSQL(BUS_CREATE);
           /*-----------------------------------notes-------------------------------------*/

            db.execSQL("insert into notes (title, latitude,longitude) values('Ruse', 43.835051,25.958113);");
            db.execSQL("insert into notes (title, latitude,longitude) values('Silistra', 44.114111,27.250450);");
            db.execSQL("insert into notes (title, latitude,longitude) values('Varna', 43.216013,27.897133););");
            /*-----------------------------------call-------------------------------------*/

            db.execSQL("insert into call (title, phone) values('Varna', 084343434);");
            db.execSQL("insert into call (title, phone) values('Ruse', 082234567);");
            db.execSQL("insert into call (title, phone) values('Silistra', 086564623););");
            /*-----------------------------------bustime-------------------------------------*/

            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Ruse','week','0.00h,0.30h,6.00h,6.40h,8.00h,9.30h,11.30h,12.00h,12.30h,14.00h,15.30h,17.00h,17.45h ');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Sofia','week','0.00h,0.30h,5.00h,6.19h 6.40h, 12.00h,14.00h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Varna','week','6.00h,6.30h,6.30h,8.30h,12.30h,13.00h,14.00h,16.30h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Razgrad','week','10h,12h,15.30h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Dobrich','week','10h,12h,15.30h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Silistra','Burgas','week','10h,12h,15.30h');");

            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Silistra','week','2.45h,7.30h, 8.30h, 9.30h,10.00h,  10.30h,11.30h,  12.30h, 13.30h, 13.45h,14.30h, 16.15h, 18.00h, 20.00h, 21.45h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Sofia','week','1.00h,2.00h,2.30h,4.00h,7.00h,8.30h, 10.00h, 12.00h, 14.00h,14.30h,16.00h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Varna','week','6.00h,7.15h,16.00h,18.00h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Razgrad','week','6.00h,7.00h,7.45h,8.30h,10.00h,11.00h,12.00h,13.00h,14.00h,15.00h,15.30h,15.30h,16.00h,17.00h,18.00h,19.00h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Dobrich','week','6.20h,13.30h');");
            db.execSQL("insert into bustime (city, bus_stop,day,time) values('Ruse','Svishov','week','10.00h,11.00h,12.00h,14.00h,15.00h,16.00h,17.00h,17.30h');");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS notes");
            onCreate(db);
        }
  }






