package com.hy.innerclass;

import com.hy.innerclass.one.One;

/**
 * Created by Hy on 2017/2/6.
 */
public class Ex7AndEx8AndEx12 {
    private String Ex07 = "007";

    private String say(String thing){
//        Ex007Inner = "Ex007Inner -> Ex07"; //can't find the constant.
//        System.out.println("Ex7AndEx8AndEx12:"+Ex007Inner);
        return thing;
    }

    public One returnOne(){
        return new One(){//Anonymous innerclass
            @Override
            public void say() {
                Ex07 = "innerclass";
                System.out.println("Anonymous: "+Ex07);
            }
        };//Semicolon required in this case.
    }


    class Ex7Inner{
        private String Ex007Inner = "Ex007Inner";
        protected void changeEx07(){
            Ex07 = "07 inner";
            System.out.println("Ex7Inner: "+Ex07);
        }
    }

    public static void main(String[] args) {
        Ex7AndEx8AndEx12 ex7 = new Ex7AndEx8AndEx12();
        Ex7AndEx8AndEx12.Ex7Inner ex7Inner = ex7.new Ex7Inner();
        ex7Inner.changeEx07();
        ex7.returnOne().say();
    }

}
