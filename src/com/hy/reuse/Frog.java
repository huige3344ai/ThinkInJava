package com.hy.reuse;

import java.util.Random;

/**
 * Created by Hy on 2017/1/27.
 */
class Amphibian{
    Amphibian(){
        System.out.println("Amphibian");
    }
    public static void tune(Amphibian amphibian){
        amphibian.say();
        amphibian.scramble();
    }
    final protected void scramble(){
        System.out.println("scramble");
    }
    protected void say(){
        System.out.println("say");
    }
}
public class Frog extends Amphibian  {
    static Random rand = new Random(20);
    final static int i_4 =  rand.nextInt();
    final static int INT_5 = rand.nextInt();
    final  Amphibian amphibian;
    public String toString(){
       return "i_4="+i_4+" INT_5="+INT_5;
    }

    Frog(){
        amphibian = new Amphibian();
        System.out.println("Frog");
    }
/*    protected void scramble(){
        System.out.println("Frog：scramble");
    }*/
    protected void say(){
        System.out.println("Frog：say");
    }
    public static void main(String[] args) {

        Frog frog = new Frog();
        Amphibian.tune(frog);
        //frog.amphibian = new Amphibian();
//        System.out.println((new Frog().toString()));
//        System.out.println((new Frog().toString()));
//        System.out.println((new Frog().toString()));
    }
}
