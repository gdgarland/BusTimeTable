package com.example.BusTimeTable;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class bussearch extends Activity implements OnClickListener {
    Button mybutton;
    protected EditText searchText;
   // protected SQLiteDatabase db;
   private DatabaseHellp mDbHelper;
    private SQLiteDatabase mDb ;
    protected Cursor cursor;
    protected ListAdapter adapter;
    protected ListView List;
    String searchbus;
    String [] towns={"vidin","montana",
            "vratsa","pleven","veliko tarnovo","dobrich","shimen","varna","lovech",
            "pernik","sofia","gabrovo","sliven","burgas","yambol","stara zogora","plovdiv","pazardzik"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        mDb = (new DatabaseHellp(this)).getWritableDatabase();
      


        searchText = (EditText) findViewById (R.id.searchText);
        List = (ListView) findViewById (R.id.list);
        mybutton = (Button) findViewById(R.id.searchButton);
        View okButton = findViewById(R.id.okbutton);
        okButton.setOnClickListener(this);

        mybutton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v) {

                searchbus = searchText.getText().toString();

                if(searchbus.equals("") || searchbus == null)
                {
                    Toast.makeText(getApplicationContext(), "���� �������� ���� ....", Toast.LENGTH_SHORT).show();
                }
                else {
                    search(List ) ;
                }
                for(String town:towns){
                    if(searchbus.equals(town))
                    {
                        Toast.makeText(getApplicationContext(), "���� �������� �����....", Toast.LENGTH_SHORT).show();
                    }}

            }




        } );

    }
    private void search(View view) {
        // TODO Auto-generated method stub
        cursor = mDb.rawQuery("SELECT _id, city, bus_stop, day ,time FROM bustime WHERE city  LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item,
                cursor,
                new String[] {"city", "bus_stop", "day","time"},
                new int[] {R.id.city, R.id.bus_stop, R.id.day,R.id.time});
        List.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okbutton:
                Intent h = new Intent(this, HomeActivity.class);
                startActivity(h);
        }

    }
}

