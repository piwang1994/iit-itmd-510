package maps_demo;// Java program to illustrate
// Java.util.HashMap 

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        print(map);
        map.put("zapple", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        System.out.println("Size of map is:  "  + map.size());

        print(map);
        if (map.containsKey("vishal")) {
            int a = map.get("vishal");
            System.out.println("value for key vishal is:"+ a);
        }
        map.clear();
        print(map);
    }

    public static void print(Map<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("map is empty");
        } else {
            System.out.println(map);
        }
    }
} 
