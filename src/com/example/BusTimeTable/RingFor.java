package com.example.BusTimeTable;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class RingFor extends Activity {
   
    private TextView mTitleText;
    private TextView mLot;
    
    private Long mRowId;
    private DatabaseHellp mDbHelper;
    private Cursor mNotesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
       


        mLot = (TextView) findViewById(R.id.lot);


        mRowId = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String longitude = extras.getString(DbAdapter.KEY_PHONE);

            mRowId = extras.getLong(DbAdapter.KEY_ROWID);

            System.out.println(longitude);
            if (longitude != null)
            {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ longitude));
                startActivity(intent);
            }
        }

    }
}

