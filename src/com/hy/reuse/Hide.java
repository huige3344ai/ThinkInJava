package com.hy.reuse;

/**
 * Created by Hy on 2017/1/26.
 */
class Homer {
     char doh(char h){
        System.out.println("Homer doh:"+h);
        return 'h';
    }
}

class MilHouse extends Homer{
    @Override
    char doh(char h){
        System.out.println("MilHouse doh:"+h);
        return 'b';
    }
}

class Club extends Homer{
    @Override
    char doh(char h){
        System.out.println("Club doh:"+h);
        return 'b';
    }
}

class  Bart extends Homer{
    @Override
    char doh(char h){
        System.out.println("Bart doh:"+h);
        return 'b';
    }
}
public class Hide extends Bart{
    @Override
    char doh(char h){
        System.out.println("Hide doh:"+h);
        return 'b';
    }
    public static void main(String[] args) {
        Hide hide = new Hide();
        hide .doh('A');
        Bart bart = new Bart();
        bart.doh('B');
        Club club = new Club();
        club.doh('C');
        MilHouse milHouse = new MilHouse();
        milHouse.doh('D');
    }
}
