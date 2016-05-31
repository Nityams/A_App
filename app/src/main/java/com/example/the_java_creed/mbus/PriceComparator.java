package com.example.the_java_creed.mbus;
import java.util.Comparator;

/**
 * Created by faith_chau on 5/5/16.
 */
public class PriceComparator implements Comparator<Bus> {
    public int compare(Bus o1, Bus o2) {

        if (o1.price>o2.price)
            return 1;
        else if (o1.price<o2.price)
            return -1;
        else
            return 0;
    }
}
