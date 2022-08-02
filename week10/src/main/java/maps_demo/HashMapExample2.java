package maps_demo;

import java.util.HashMap;

public class HashMapExample2 {

    public static void main(String[] args) {

        /* This is how to declare HashMap */
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        /*Adding elements to HashMap*/
        hm.put(12, "soda");
        hm.put(2, "TP");
        hm.put(7, "food");

        System.out.println("\nHashMap object output :\n\n" + hm);

        // store data with duplicate key
        hm.put(12, "ice cream");

        System.out.println("\nAfter inserting duplicate key :\n\n" + hm);
    }
} 
