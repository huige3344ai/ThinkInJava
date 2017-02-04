package com.hy.reuse;

/**
 * Created by Hy on 2017/1/26.
 */
class Component1 {
    Component1() { System.out.println("Component1()"); }
    void dispose() { System.out.println("Component1.dispose()"); }
}

class Component2 {
    Component2() { System.out.println("Component2()"); }
    void dispose() { System.out.println("Component2.dispose()"); }
}

class Component3 {
    Component3() { System.out.println("Component3()"); }
    void dispose() { System.out.println("Component3.dispose()"); }
}

class Root2 {
    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Root2() {
        System.out.println("Root()");
        c1root = new Component1();
        c2root = new Component2();
        c3root = new Component3();
    }
    void dispose() {
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        System.out.println("Root2.dispose()");
    }
}

class Stem2 extends Root2 {
    Component1 c1stem;
    Component2 c2stem;
    Component3 c3stem;
    Stem2(int num) {
        super();
        System.out.println("Stem2()"+num);
        //c1stem = new Component1();
        c2stem = new Component2();
        c3stem = new Component3();
    }
    void dispose() {
        c3stem.dispose();
        c2stem.dispose();
        //c1stem.dispose();
        super.dispose();
        System.out.println("Stem2.dispose()");
    }
    public static void main(String[] args) {
        Stem2 s = new Stem2(1);
        Stem2 s2 = new Stem2(2);
        try {
            // Code and exception handling...
        } finally {
            s.dispose();
        }
    }
}
