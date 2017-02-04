package com.hy.polymorphism;

/**
 * Created by Hy on 2017/1/31.
 */
class IdGeneral{
     static long counter = 0;
     public static long getID() {
         return counter++;
     }
}

class Father{
    private final static String NAME = "Father";
    private  final static long id = IdGeneral.getID();
    @Override
    public String toString() {
        return this.NAME+" id="+id;
    }

    Father(){
        System.out.println(this+" was Created");
    }

    public static void say(){
        System.out.println(Father.NAME+" id="+id+" say");
    }
    public void run(){
        System.out.println(this+" run");
    }
    public final  void died(){
        System.out.println(this+" died");
    }

    private void play(){
        System.out.println(this+" play");
    }

    public void getPlay(){
        play();
    }


}

class Child extends Father{
    private final static String NAME = "Child";
    private static Father father = new Father();
    private  final static long id = IdGeneral.getID();
    @Override
    public String toString() {
        return this.NAME+" id="+id;
    }

    Child(){
        System.out.println(this+" was Created");
    }

    /*    @Override 如果这里不添加覆盖的注解，该方法就不是覆盖父类的方法了，直接是一个子类的新的方法，跟父类没有半毛钱关系了。*/
    public static void say(){
        //super.say();//因为不添加 @Override，所以编译的时候因为他是一个新的方法，无法调用父类的方法。
        System.out.println(Child.class.toString()+" say");
    }

    @Override
    public void run(){
        System.out.println(this+" run");
    }

/*   这里如果注释去掉的话，是无法通过编译的，因为父类定义该方法为final,不允许覆盖该方法。无论是否添加@Override注解。
   public final void died(){
        System.out.println("Polymorphism died");
    }*/

/* 因为父类的方法是private,所以隐式就是final的方法不允许覆盖或者子类使用
    @Override
*/
    private void play(){
        father.getPlay();
    }
}

class Child2 extends Father{
    private final static String NAME = "Child2";
    private  final static long id = IdGeneral.getID();
    @Override
    public String toString() {
        return this.NAME+" id="+id;
    }

    Child2(){
        System.out.println(this+" was Created");
    }

    @Override
    public void run(){
        System.out.println(this+" run");
    }
}

public class Polymorphism  {
    public static void tune(Father father){
        try{
            father.say();
            father.run();
            father.getPlay();
        }finally {
            father.died();
        }
    }

    public static void tuneAll(Father[] fathers){
        for (Father child:fathers) {
            System.out.println("============START===========");
            tune(child);
            System.out.println("=============END============");
        }
    }

    public static void main(String[] args) {
            Polymorphism polymorphism = new Polymorphism();
            Father[] fathers = {
                    new Child(),
                    new Child2()
            };
            polymorphism.tuneAll(fathers);
    }

}
/*
Father id=0 was Created
Child id=1 was Created //这里为啥会显示两次？ 答案：子类会调用父类的构造器，构造器中有调用toString方法动态绑定(this)，因而父类调用时子类的方法而不是父类的。
Child id=1 was Created
Child2 id=2 was Created
Child2 id=2 was Created
============START===========
Father id=0 say// 为啥不会调用子类？动态绑定，是针对父类被子类覆盖的方法，Father fathers = new Child(); Child中的say的方式其实一个全新的方法。
Child id=1 run
Child id=1 play
Child id=1 died
=============END============
============START===========
Father id=0 say
Child2 id=2 run
Child2 id=2 play
Child2 id=2 died
=============END============
*/
