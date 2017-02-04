package com.hy.interface9;

/**
 * Created by Hy on 2017/1/31.
 */
abstract class AbstractClass{
    private static String NAME = "AbstractClass";

    public String toString() {
        return this.NAME;
    }
    AbstractClass(){
        print();
    }

    abstract void print();
}

class AbstractClassChild extends AbstractClass{
    private  String NAME = "AbstractClassChild";

    public String toString() {
        return this.NAME;
    }

    @Override
    void print() {
        System.out.println("NAME is "+this.NAME);
    }
}

public class Ex3 {
    public static void main(String[] args) {
        AbstractClassChild child = new AbstractClassChild();
        child.print();
        /* Process of initialization:
		* 1. Storage for Son s allocated and initialized to binary zero
		* 2. Dad() called
		* 3. Son.print() called in Dad() (s.i = 0)
		* 4. Member initializers called in order (s.i = 1)
		* 5. Body of Son() called
		*/


    }
}
