// polymorphism/rodent/Rodent12.java
// TIJ4 Chapter Polymorphism, Exercise 12, page 298
/* Modify exercise 9 so that it demonstrates the order of initialization of the
* base classes and derived classes. Now add member objects to both the base and
* derived classes, and show the order in which their initialization occurs during
* construction.
*/
/* Solution includes, in same package:
* import java.util.*;
* public class RandomRodentGenerator {
*	private Random rand = new Random();
*	public Rodent next() {
*		switch(rand.nextInt(3)) {
*			default:
*			case 0: return new Mouse();
*			case 1: return new Rat();
*			case 2: return new Squirrel();
*		}
*	}
* }
*/

package com.hy.polymorphism;

import java.util.Random;

  class RandomRodentGenerator {
	private Random rand = new Random();
	Rodent rodent = new Rodent();
	public Rodent next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Mouse(rodent);
			case 1: return new Rat(rodent);
			//case 2: return new Squirrel(rodent);
		}
	}
 }

class Characteristic {
	private String s;
	Characteristic(String s) {
		this.s = s;
		System.out.println("Creating Characteristic " + s);
	}
}

class Description {
	private String s;
	Description(String s) {
		this.s = s;
		System.out.println("Creating Description " + s);
	}
}

class Rodent {
  	private int refcount = 0;
  	private static long count = 0;
  	private static final long id = count++;
	private static String name = "Rodent";
	//private Characteristic c = new Characteristic("has tail");
	//private Description d = new Description("small mammal");
	Rodent() { System.out.println("Creating :"+this); }
	protected void eat() { System.out.println("Rodent.eat()"); }
	protected void run() { System.out.println("Rodent.run()"); }
	protected void sleep() { System.out.println("Rodent.sleep()"); }
	public String toString() { return name; }
	protected  void addRef(){
		refcount++;
		System.out.println(this+" : Have "+refcount+" objects ref Rodent");
	}
	protected void finalize() {
		if(refcount>0)
			System.out.println("Error: " + refcount + " Rodent " + id + " objects in use");
	}
	protected void dispose(){
		if(--refcount==0){
			System.out.println("dispose:"+this);
		}
	}
	}

class Mouse extends Rodent {
  	private Rodent rodent;
	private String name = "Mouse";
	private Characteristic c = new Characteristic("likes cheese");
	private Description d = new Description("nocturnal");
	Mouse(Rodent rodent) {
        System.out.println("Creating : "+this);
		this.rodent = rodent;
		this.rodent.addRef();
	}
	@Override
	protected void dispose() {
		System.out.println("dispose:"+this);
		super.dispose();
	}


	protected void eat() { System.out.println("Mouse.eat()"); }
	protected void run() { System.out.println("Mouse.run()"); }
	protected void sleep() { System.out.println("Mouse.sleep()"); }
	public String toString() { return name; }
}

class Rat extends Rodent {
	private Rodent rodent;
	private String name = "Rat";
	private Characteristic c = new Characteristic("larger");
	private Description d = new Description("black");
	Rat(Rodent rodent) {
        System.out.println("Creating : "+this);
		this.rodent = rodent;
		this.rodent.addRef();
	}
	@Override
	protected void dispose() {
		System.out.println("dispose: "+this);
		super.dispose();
	}
	protected void eat() { System.out.println("Rat.eat()"); }
	protected void run() { System.out.println("Rat.run()"); }
	protected void sleep() { System.out.println("Rat.sleep()"); }
	public String toString() { return name; }
}

class Squirrel extends Rodent{
	private Rodent rodent1;
	private static long counter = 0;
    private final long id = counter++;
	private String name = "Squirrel";
	//private Characteristic c = new Characteristic("climbs trees");
	//private Description d = new Description("likes nuts");
	Squirrel(Rodent rodent2) {
		System.out.println("Creating : "+this);
		rodent1 = rodent2;
		rodent1.addRef();
	}

	protected void dispose() {
		System.out.println("dispose:"+this);
		rodent1.dispose();
	}
	protected void eat() { System.out.println("Squirrel.eat()"); }
	protected void run() { System.out.println("Squirrel.run()"); }
	protected void sleep() { System.out.println("Squirrel.sleep()"); }
	public String toString() { return name+" "+this.id; }
}

public class Rodent9 {
	//private static RandomRodentGenerator gen = new RandomRodentGenerator();
	public static void main(String[] args) {
		Rodent rodent = new Rodent();
/*		Squirrel[] squirrels = {
				new Squirrel(rodent),
				new Squirrel(rodent)
		};
		for (Squirrel s:squirrels) {
			s.dispose();
		}*/
        Squirrel rat = new Squirrel(rodent);
		rodent.finalize();
    }
}