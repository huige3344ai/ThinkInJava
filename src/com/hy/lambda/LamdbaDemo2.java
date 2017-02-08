package com.hy.lambda;

/**
 * Created by Hy on 2017/2/8.
 */
public class LamdbaDemo2 {
    static int num = 1;

    //Annotation is dispensable.
    @FunctionalInterface
    interface Context<F,T>{
        T getContext(F f);
    }

    interface Context2{
        String getContext2(String str);
        default String  getContext(Integer i,String s){
            System.out.println(i+" "+s);
            return s;
        }
        default void getContext2(Integer i,String s){
            System.out.println(i+" "+s);
        }
    }



    public static void main(String[] args) {
        // :: 传递方法或者构造函数引用
        Context<String,Integer> con = Integer::valueOf;//传递方法
        System.out.println("con="+con.getContext("001"));
        Context<Person,String> con2 = Person::getName;//传递方法
        System.out.println("con2="+con.getContext("002"));
        //jdk 1.8 before
/*        PersonFactory<Person> personPersonFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String name) {
                return  new Person(name);
            }
        };*/
        PersonFactory<Person> personPersonFactory = Person::new;//构造函数引用,接口必须为函数式接口。
        personPersonFactory.create("JJ");
        personPersonFactory.create("JJ2");
        personPersonFactory.create("JJ3");


        Context<String,Integer> context = f->Integer.valueOf(f).intValue();
        System.out.println("context="+context.getContext("45"));

        Context2 context2 = (str) -> {//函数式接口，只能有一个抽象方法，可以有多个default方法
            //getContext(1,str);//lamdba 无法访问函数式接口的default方法，但是下面的是可以访问，所以先lamdba是有一定的局限性。
            return str;
        };
        Context2 context02 = new Context2() {
            @Override
            public String getContext2(String str) {
                return getContext(1,str);
            }
        };


        System.out.println("context2="+context2.getContext2("6666"));

        //Access to a local variable and global variable.
        Context<String,Integer> context3 = f->{
            num=num+Integer.valueOf(f).intValue();
            return num;//outside static constant
        };
        System.out.println("context3="+context3.getContext("10"));

        int num2=66;// final inside constant
        Context<String,Integer> context4 = f-> Integer.valueOf(f).intValue()+num2;
        System.out.println("context4="+context4.getContext("12"));

        Lamdba lamdba = new Lamdba();
        lamdba.getContext();
    }

}
