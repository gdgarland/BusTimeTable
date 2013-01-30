package com.example.BusTimeTable;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class busstationinfo extends TabActivity
{

    private TabHost tabHost ;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busstationinfo);

        tabHost = getTabHost();


        TabHost.TabSpec spec1=tabHost.newTabSpec("Tab 1");
        spec1.setIndicator("Call",getResources().getDrawable(R.drawable.call_icon));
        Intent in1=new Intent(this, Call.class);
        spec1.setContent(in1);

        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator("Map",getResources().getDrawable(R.drawable.maps));
        Intent in2=new Intent(this,Maps.class);
        spec2.setContent(in2);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
    }
}

