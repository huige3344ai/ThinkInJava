package com.hy.innerclass;

/**
 * Created by Hy on 2017/2/6.
 */
class Ex015{
    private String name;
    Ex015(){
        System.out.println("Ex015() initialize.");
    }
    Ex015(String name){
        this.name=name;
        System.out.println("Ex015:"+this.name);
    }
    protected void say(){
        System.out.println("say:"+this.name);
    }
}

public class Ex15 {
    private Ex015 returnEx015(String name){
        return new Ex015(name){
            private String name2 = name;
            {
                System.out.println(name2+" Anonymous inner class code.");
            }

        };
    }
    String insideName = "insideName";
    public Ex015 returnEx0152(String name){
        return new Ex015(){
            private String name2 = insideName;
            String insideName2 = new String("test");
//            insideName = new String("test");//unknown class insideName  JDK 1.8 default is final.
            {
                System.out.println(insideName+" Anonymous inner class code.");
            }
            @Override
            protected void say(){
                System.out.println("say:"+returnName());
            }
            public String returnName(){
                return "returnName: "+name2;
            }
        };
    }

    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        ex15.returnEx015("Innerclass").say();
        Ex015 ex015 = ex15.returnEx0152("final");
        ex015.say();
        ex015.say();
    }
}
