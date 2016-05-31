package com.example.the_java_creed.mbus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import com.firebase.client.*;
import java.util.*;


public class BusList extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;

    ArrayList<Bus> pleasantonBuses;
    ArrayList<Bus> laBuses;
    String from;
    String destination;
    String totalPeople;
    String date;
    private Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        //Create Spinner
        Spinner spinMe = (Spinner) findViewById( R.id.spinner1);
        final ListView list = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems);

        list.destroyDrawingCache();
        list.setVisibility(ListView.INVISIBLE);
        list.setVisibility(ListView.VISIBLE);

        final Intent intMe = new Intent(this,Prompt.class);



        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) (list.getItemAtPosition(position));
                intMe.putExtra("Bus", selected);
                startActivity(intMe);

            }
        });
        spinMe.setOnItemSelectedListener(this);
        String[] categories = new String[]{"Price", "Time"};

        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        myFirebaseRef = new Firebase("https://amber-inferno-1833.firebaseio.com");
        Firebase busesRef = myFirebaseRef.child("buses");



        for (int i = 1; i <= 6; i++) {
            Firebase ref1 = busesRef.child(i+"");
            ref1.child("fireListener").setValue("1");
        }

        Firebase bus1Ref = busesRef.child("1");
        bus1Ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map myMap = dataSnapshot.getValue(HashMap.class);
                String busID = myMap.get("busID") + "";
                Object startLocation = myMap.get("location");
                Object leavingTime = myMap.get("leavingTime");
                Object reachingTime = myMap.get("reachingTime");
                Object price = myMap.get("price");
                Object numberOfSeats = myMap.get("seats");


                String timeToLeave = leavingTime.toString();
                timeToLeave = timeToLeave.substring(0,2) + timeToLeave.substring(3,5);

                String timeToReach = reachingTime.toString();
                timeToReach = timeToReach.substring(0,2) + timeToReach.substring(3,5);

                Bus pleasanton1 = new Bus (busID, "San Jose" , startLocation.toString(), timeToLeave, timeToReach, 
                                                  (Integer) numberOfSeats, (Integer) price);
                pleasantonBuses.add(pleasanton1);
                BusNumberManager bnm = BusNumberManager.sharedInstance();
                busID = busID.substring(1);
                bnm.setBusNumber(Integer.parseInt(busID));
                bnm.setSeats(Integer.parseInt(numberOfSeats.toString()));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase bus2Ref = busesRef.child("2");
        bus2Ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map myMap = dataSnapshot.getValue(HashMap.class);
                String busID = myMap.get("busID") + "";
                Object startLocation = myMap.get("location");
                Object leavingTime = myMap.get("leavingTime");
                Object reachingTime = myMap.get("reachingTime");
                Object price = myMap.get("price");
                Object numberOfSeats = myMap.get("seats");


                String timeToLeave = leavingTime.toString();
                timeToLeave = timeToLeave.substring(0,2) + timeToLeave.substring(3,5);

                String timeToReach = reachingTime.toString();
                timeToReach = timeToReach.substring(0,2) + timeToReach.substring(3,5);

                Bus LA1 = new Bus (busID, "San Jose" , startLocation.toString(), timeToLeave, timeToReach, 
                                            (Integer) numberOfSeats, (Integer) price);
                laBuses.add(LA1);
                BusNumberManager bnm = BusNumberManager.sharedInstance();
                busID = busID.substring(1);
                bnm.setBusNumber(Integer.parseInt(busID));
                bnm.setSeats(Integer.parseInt(numberOfSeats.toString()));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        /**
         *Create Bus objects and Arraylist
         *3 buses for each destination but differnt times and price.
         *can sort by time and price. default is set to sort by time.
         */
        // populate: Dummy fields
        pleasantonBuses = new ArrayList<Bus>();
        pleasantonBuses.add(new Bus ("005", "San Jose", "Pleasanton","1700","1844",5, 87));
        pleasantonBuses.add(new Bus ("003","San Jose", "Pleasanton","1200", "1317", 5, 54));

        laBuses = new ArrayList<Bus>();
        laBuses.add(new Bus("004", "San Jose","Los Angeles", "0700","1525",5,47));
        laBuses.add(new Bus ("006", "San Jose", "Los Angels","1000","1738",5, 79));
        laBuses.add(new Bus("007","San Jose", "Los Angeles", "0530", "1200", 8, 50));

        /**
         * Extract data entered from last activity from bundles
         */

        Bundle extras = this.getIntent().getExtras();
        ArrayList<String> information = extras.getStringArrayList("info");
        from = information.get(0);
        destination = information.get(1);
        totalPeople = information.get(2);
        date = information.get(3);

        //Toast.makeText(this, destination, Toast.LENGTH_SHORT).show();
        spinMe.setAdapter(myAdapt);
        //spinMe.setOnItemClickListener(new YourItemSelectedListner());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getSelectedItem().toString();
        switch (item) {
            case "Price": // sort by price
                if (destination.equals("Los Angeles")) {
                    adapter.clear();
                    Collections.sort(laBuses, new PriceComparator());
                    displayLaBusList();

                    //Toast.makeText(BusList.this, position + "  Price Clicked, LA bus sorted", Toast.LENGTH_SHORT).show();
                }else{
                    adapter.clear();
                    Collections.sort(pleasantonBuses, new PriceComparator());
                    displayPleasantonBusList();

                    //Toast.makeText(BusList.this, pleasantonBuses.get(0).number, Toast.LENGTH_SHORT).show();
                }
                break;

            case "Time": //sort by time
                if (destination.equals("Los Angeles")) {
                    adapter.clear();
                    Collections.sort(laBuses, new TimeComparator());
                    displayLaBusList();

                }else{
                    adapter.clear();
                    Collections.sort(pleasantonBuses, new TimeComparator());
                    displayPleasantonBusList();

                }
                break;
        }
    }

    public void displayLaBusList()
    {
        int i =laBuses.size();
        for(int j=0; j<i; j++)
        {
            Bus a = laBuses.get(j);
            listItems.add(a.toString());
        }
        adapter.notifyDataSetChanged();
    }

    public void displayPleasantonBusList() {
        int i = pleasantonBuses.size();
        for(int j=0; j< i; j++)
        {
            Bus a = pleasantonBuses.get(j);
            listItems.add(a.toString());
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

