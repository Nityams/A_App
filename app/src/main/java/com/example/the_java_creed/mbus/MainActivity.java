package com.example.the_java_creed.mbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.firebase.client.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinMe = (Spinner) findViewById(R.id.spinner1);
        String[] categories = new String[]{"San Jose"};
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories);
        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMe.setAdapter(myAdapt);

        Spinner spinMe2 = (Spinner) findViewById(R.id.spinner2);
        String[] destCategories = new String[]{"Los Angeles", "Pleasanton"};
        ArrayAdapter<String> myAdapt2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,destCategories);
        myAdapt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMe2.setAdapter(myAdapt2);

        Firebase.setAndroidContext(this);
    }

    public void makeReservation(View view)
    {
        Intent intent = new Intent (this, BusList.class);

        Bundle bundle = new Bundle();
        ArrayList<String> information = new ArrayList<String>();

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1); //Start point (San Jose)
        information.add(0, spinner1.getSelectedItem().toString());

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2); //End point (Pleasanton, Los Angeles)
        information.add(1, spinner2.getSelectedItem().toString());

        EditText editText6 = (EditText) findViewById(R.id.editText6); //totalPeople
        information.add(2, editText6.getText().toString());

        EditText editText7 = (EditText) findViewById(R.id.editText7); //date
        information.add(3, editText7.getText().toString());

        bundle.putStringArrayList("info", information);
        intent.putExtras(bundle);

        //Toast.makeText(this, from, Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}


