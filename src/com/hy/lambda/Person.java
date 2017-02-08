package com.hy.lambda;

/**
 * Created by Hy on 2017/2/8.
 */
public class Person {
    String name;
    Person() {}
    public Person(String name) {
        this.name=name;
        System.out.println("Created a name is "+this.name);
    }

    public String getName() {
        return name;
    }
}
