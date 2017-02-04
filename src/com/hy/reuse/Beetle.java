//: reusing/Beetle.java
// The full process of initialization.
package com.hy.reuse;


class Insect {
  private int i = 9;
  protected int j;
  Insect() {
    System.out.println("i = " + i + ", j = " + j);
    j = 39;
  }
  private static int x1 =
    printInit("static Insect.x1 initialized");
  static int printInit(String s) {
    System.out.println("Insect:"+s);
    return 47;
  }
}

public class Beetle extends Insect {
  private int k = printInit("Beetle.k initialized");
  public Beetle() {
    System.out.println("k = " + k);
    System.out.println("j = " + j);
  }

/*  static int printInit(String s) {
    System.out.println("Beetle:"+s);
    return 47;
  }*/
  protected static int x2 =
    printInit("static Beetle.x2 initialized");
  public static void main(String[] args) {
    System.out.println("Beetle constructor");
/*    Beetle b = new Beetle();
    Beetle b2 = new Beetle();*/
    Insect b2 = new Beetle();
    int i = Beetle.x2;
    System.out.println(i);
  }
}
/* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
