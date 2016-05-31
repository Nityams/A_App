package com.example.the_java_creed.mbus;
import java.util.Comparator;

/**
 * Created by faith_chau on 5/5/16.
 */
public class TimeComparator implements Comparator<Bus> {

    public int compare(Bus o1, Bus o2) {
        int time1 = Integer.parseInt(o1.deptTime);
        int time2 = Integer.parseInt(o2.deptTime);

        if (time1>time2)
            return 1;
        else if (time1<time2)
            return -1;
        else
            return 0;
    }
}
