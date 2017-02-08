package com.hy.lambda;

/**
 * Created by Hy on 2017/2/8.
 */
public class Lamdba {
    static int outsideStatic = 10;
    int outsideInt = 66;
    void getContext(){
        LamdbaDemo2.Context<String,Integer> context = f -> {
            String str = String.valueOf(outsideInt);
            outsideStatic++;
            String str2 = String.valueOf(outsideStatic);
            System.out.println("str"+str);
            System.out.println("str2"+str2);
            return null;
        };
        LamdbaDemo2.Context<String,Person> context2 = name->{
            return new Person(name);
        };
        Person person = context2.getContext("Sam");
        System.out.println("person:"+person.name);
    }
}
