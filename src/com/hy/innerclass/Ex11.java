package com.hy.innerclass;

import com.hy.innerclass.one.One;

/**
 * Created by Hy on 2017/2/6.
 */
public class Ex11 {
    private class Ex11Inner implements One{
        @Override
        public void say() {
            System.out.println("Ex11Inner");
        }

    }
    public One returnOne(){
        One one = new Ex11Inner();
        return one;
    }

    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        ex11.returnOne().say();
       // ((Ex11Inner)ex11).say();//can't cast
    }
}
