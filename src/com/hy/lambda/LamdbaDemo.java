package com.hy.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Hy on 2017/2/8.
 */
public class LamdbaDemo {
    public static void main(String[] args) {
        //before jdk 1.8
        List<String> names =  Arrays.asList("tony","sam","jim");
/*        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
*/
    // lamdba after jdk 1.8
        //1. String can remove,because jdk will match your parameters, and get only your method.
        Collections.sort(names,(String o1,String o2)->{
            return o1.compareTo(o2);
        });
        //2.
        Collections.sort(names,(o1,o2)->o1.compareTo(o2));
        for (String name:
                names) {
            System.out.println(name);
        }

    }

}
