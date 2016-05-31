package com.example.the_java_creed.mbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import org.w3c.dom.Text;


import com.firebase.client.*;

public class Prompt extends AppCompatActivity {
    private Firebase myFirebaseRef;
    private BusNumberManager bmn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
        Firebase.setAndroidContext(this);
        bmn = BusNumberManager.sharedInstance();
        myFirebaseRef = new Firebase("https://amber-inferno-1833.firebaseio.com/buses/" + bmn.getBusNumber());


        String selected = getIntent().getExtras().getString("Bus");

        TextView txt = (TextView) findViewById(R.id.prompt_msg);
        txt.append(selected);
    }

    public void buttonOnClickOK(View w)
    {
        Button btn = (Button) w;
        Toast.makeText(this, "Trip selected", Toast.LENGTH_SHORT).show();


        Intent intentMw = new Intent(this,EndActivity.class);
        startActivity(intentMw);
        int seats = bmn.getSeats()-1;
        myFirebaseRef.child("seats").setValue(seats);
    }

    public void buttonOnClickCANCEL(View view) {
        // Button btn = (Button) w;
        Toast.makeText(this, "TRIP IS CANCELED", Toast.LENGTH_SHORT).show();

        Intent intentMw = new Intent(this,MainActivity.class);
        startActivity(intentMw);

    }
}
