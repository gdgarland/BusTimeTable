package com.example.BusTimeTable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import com.example.BusTimeTable.R;


public class HomeActivity extends Activity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Set up click listeners for all the buttons
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        
        View busButton = findViewById(R.id.bus_button);
        busButton.setOnClickListener(this);
        
       // View newButton = findViewById(R.id.new_button);
       // newButton.setOnClickListener(this);
       
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
       
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }



 
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_button:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
         
            case R.id.continue_button:
                Intent z = new Intent(this, bussearch.class);
                startActivity(z);
                break;
            case R.id.bus_button:
                Intent oneIntent = new Intent(this, busstationinfo.class);
                startActivity(oneIntent);
                break;
         
            case R.id.exit_button:
                Intent ntent = new Intent(Intent.ACTION_MAIN);
                ntent.addCategory(Intent.CATEGORY_HOME);
                ntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ntent);
                finish();
                break;
        }

    }

}


