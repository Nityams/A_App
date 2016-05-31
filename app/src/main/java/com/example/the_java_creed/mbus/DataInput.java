package com.example.the_java_creed.mbus;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//might not be necessary; use database

/**
 * Created by nityam on 5/2/2016.
 */
public class DataInput          // might need to extend activity
{
    private Context mContext;
    ArrayList<Bus> busses = new ArrayList<>();
    int num;
    String From = "";
    String To = "";
    int Depart;
    int Arrive;
    int Seat;
    InputStream dataIn;
    AssetManager assetManager;
    BufferedReader reader;
    String line;
    String sNum = "";
    String sDepart = "";
    String sDarrive = "";
    String sDseat = "";


    //    String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/busData";
//    File dir = new File(path);
//
    public DataInput(Context mContext) throws IOException {
        this.mContext = mContext;
        assetManager = mContext.getAssets();

        dataIn = assetManager.open("busData.txt");
        reader = new BufferedReader(new InputStreamReader(dataIn));
        //line = reader.readLine();

        while ((line=reader.readLine())!= null)                               //end of file
        {
            int i = 0;
            int j = 0;
            // may need eof tag line
            while (line.charAt(i) != '|') {
                sNum = line.substring(0, i + 1);
                i++;
            }
            ++i;
            j = i;
            while (line.charAt(i) != '|') {
                From = line.substring(j, i + 1);
                i++;
            }
            ++i;
            j = i;
            while (line.charAt(i) != '|') {
                To = line.substring(j, i + 1);
                i++;
            }
            ++i;
            j = i;
            while (line.charAt(i) != '|') {
                sDepart = line.substring(j, i + 1);
                i++;

            }
            ++i;
            j = i;
            while (line.charAt(i) != '|') {
                sDarrive = line.substring(j, i + 1);
                i++;

            }
            ++i;
            j = i;
            for (; i < line.length(); i++)
                sDseat = sDseat + line.charAt(i);

            System.out.println(sNum + "," + From + "," + To + "," + sDarrive + "," + sDepart + "," + sDseat);

            num = Integer.parseInt(sNum);
            Depart = Integer.parseInt(sDepart);
            Arrive = Integer.parseInt(sDarrive);
            Seat = Integer.parseInt(sDseat);
            //busses.add(new Bus(num, From, To, Depart, Arrive, Seat));
            sDseat = "";

            // need to close input stream
        }
//Printing the arraylist
        for (Bus bus : busses) {
            System.out.println(bus.number + "Arrive " + bus.ariveTime + "Dept " + bus.deptTime + "Seats: " + bus.seats + "From: " + bus.from + "TO: " + bus.to);
        }

    }
}