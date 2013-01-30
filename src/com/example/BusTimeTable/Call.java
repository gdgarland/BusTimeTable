package com.example.BusTimeTable;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Call extends ListActivity {
 
    private static final int ACTIVITY_EDIT=1;
    private SQLiteDatabase mDb;
    ImageView phoneIcon;
    ImageView emailIcon;
    private DatabaseHellp mDbHelper;
    private Cursor mNotesCursor;
    DbAdapter dbAdapter;

    



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_list);
       
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();

        fillPhone();
        registerForContextMenu(getListView());
    }

    private void fillPhone() {
      
        mNotesCursor = dbAdapter.fetchAllPhone();
        startManagingCursor(mNotesCursor);

       
        String[] from = new String[]{DbAdapter.KEY_CITY};
        int[] to = new int[]{R.id.title};

      
        SimpleCursorAdapter notes =
                new SimpleCursorAdapter(this, R.layout.call_row, mNotesCursor, from, to);
        setListAdapter(notes);
    }





    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor c = mNotesCursor;
        c.moveToPosition(position);
        Intent i = new Intent(this, RingFor.class);
        i.putExtra(DbAdapter.CALL_ROWID, id);
        i.putExtra(DbAdapter.KEY_CITY, c.getString(
                c.getColumnIndexOrThrow(DbAdapter.KEY_CITY)));
        i.putExtra(DbAdapter.KEY_PHONE, c.getString(
                c.getColumnIndexOrThrow(DbAdapter.KEY_PHONE)));
        startActivityForResult(i, ACTIVITY_EDIT);
    }


}

