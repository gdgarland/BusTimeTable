package com.example.BusTimeTable;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Maps extends ListActivity {
   
    private static final int ACTIVITY_EDIT=1;
    DbAdapter dbAdapter;
    ImageView phoneIcon;
    ImageView emailIcon;
    private DatabaseHellp mDbHelper;
    private Cursor mNotesCursor;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_list);
      
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        fillData();
        registerForContextMenu(getListView());
    }

    private void fillData() {
        
        mNotesCursor = dbAdapter.fetchAllNotes();
        startManagingCursor(mNotesCursor);

        String[] from = new String[]{DbAdapter.KEY_TITLE};

        int[] to = new int[]{R.id.title};

        SimpleCursorAdapter notes =
                new SimpleCursorAdapter(this, R.layout.maps_row, mNotesCursor, from, to);
        setListAdapter(notes);
    }





    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor c = mNotesCursor;
        c.moveToPosition(position);
        Intent i = new Intent(this, ShowMap.class);
        i.putExtra(DbAdapter.BUS_ROWID, id);
        i.putExtra(DbAdapter.KEY_TITLE, c.getString(
                c.getColumnIndexOrThrow(DbAdapter.KEY_TITLE)));
        i.putExtra(DbAdapter.KEY_LONGITUDE, c.getString(
                c.getColumnIndexOrThrow(DbAdapter.KEY_LONGITUDE)));
        i.putExtra(DbAdapter.KEY_LATITUDE, c.getString(
                c.getColumnIndexOrThrow(DbAdapter.KEY_LATITUDE)));
        startActivityForResult(i, ACTIVITY_EDIT);
    }


}

