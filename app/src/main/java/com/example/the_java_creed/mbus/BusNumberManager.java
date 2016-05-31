package com.example.the_java_creed.mbus;

/**
 * Created by karan on 5/7/16.
 */
public class BusNumberManager {
    private static BusNumberManager bnm= new BusNumberManager();
    private int busNumber,seats;

    private BusNumberManager(){
        busNumber = 0;
        seats = 0;
    }

    public static BusNumberManager sharedInstance(){
        return bnm;
    }

    public int getBusNumber() {
        return this.busNumber;
    }

    public void setBusNumber(int busNumber){
        this.busNumber = busNumber;
    }

    public int getSeats(){
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
