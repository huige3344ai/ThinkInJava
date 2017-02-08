package com.hy.innerclass;

import com.hy.innerclass.one.One;

/**
 * Created by Hy on 2017/2/6.
 */
public class Ex9AndEx10AndEx13 {
    public One returnOne(){
        class Ex9Inner implements One{
            Ex9Inner(){}
            @Override
            public void say() {
                System.out.println("Ex9Inner");
            }
        }
        return new Ex9Inner();
    }

    public One returnOne2(boolean b){
        if(b){
            class Ex9Inner implements One{
                Ex9Inner(){}
                @Override
                public void say() {
                    System.out.println("Ex9Inner true ");
                }
            }
            return new Ex9Inner();
        }else {
            class Ex9Inner implements One{
                Ex9Inner(){}
                @Override
                public void say() {
                    System.out.println("Ex9Inner false ");
                }
            }
            return new Ex9Inner();
        }
        //return new Ex9Inner();//can't find the inner class.
    }

    public One returnOne3(){
        return new One() {
            @Override
            public void say() {
                System.out.println("anonymous innerclass");
            }
        };
    }


    public static void main(String[] args) {
        Ex9AndEx10AndEx13 ex9 = new Ex9AndEx10AndEx13();
        ex9.returnOne().say();
        ex9.returnOne2(true).say();
        ex9.returnOne2(false).say();
        ex9.returnOne3().say();
    }
}
