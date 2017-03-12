package com.hy.hodling;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Hy on 2017/3/12.
 */
public class Ex12 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = new ArrayList<>();

        ListIterator<Integer> listIterator = list1.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next().intValue());
        }
        while (listIterator.hasPrevious()){
//            System.out.println(listIterator.previous());  run list2.add: Exception in thread "main" java.util.NoSuchElementException
            list2.add(listIterator.previous());
        }
        System.out.println(list2);


    }
}
