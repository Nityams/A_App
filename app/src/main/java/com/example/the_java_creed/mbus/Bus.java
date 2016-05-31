package com.example.the_java_creed.mbus;

/**
 * Created by nityam on 5/2/2016.
 */
public class Bus{
    public String number ;// bus id
    public String from;
    public String to;
    public int price;
    public String deptTime;
    public String ariveTime;
    public int seats;

//    public Bus() {
//
//    }

    public Bus(String number, String from, String to, String dept, String arrive, int seats, int price){
        this.number = number;
        this.from = from;
        this.to = to;
        deptTime = dept;
        ariveTime = arrive;
        this.seats = seats;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "\n Bus Number: \t "+number +"\n Depart:\t "+deptTime+"\t \t Arrive:\t "+ariveTime+"\n Price:\t $"+price+"\n From:  "+ from+ "\t \t To:  "+ to;
    }


}
