// polymorphism/music6/Music6.java
// TIJ4 Chapter Polymorphism, Exercise 6, page 289
/* Change Music3.java so that what() beccomes the root Object method toString().
* Try printing the Instrument objects using System.out.println() without any 
* casting.
*/
package com.hy.polymorphism;

import java.util.Random;

class Instrument {
	void play(Note n) { System.out.println("Instrument.play() " + n); }
	public String toString() { return "Instrument"; }
	void adjust() { System.out.println("Adjusting Instrument"); }
}

class Wind extends Instrument {
	void play(Note n) { System.out.println("Wind.play() " + n); }
	public String toString() { return "Wind"; }
	void adjust() { System.out.println("Adjusting Wind"); }
}

class Percussion extends Instrument {
	void play(Note n) { System.out.println("Percussion.play() " + n); }
	public String toString() { return "Percussion"; }
	void adjust() { System.out.println("Adjusting Percussion"); } 
}

class Stringed extends Instrument {
	void play(Note n) { System.out.println("Stringed.play() " + n); }
	public String toString() { return "Stringed"; }
	void adjust() { System.out.println("Adjusting Stringed"); } 
}

class Brass extends Wind {
	void play(Note n) { System.out.println("Brass.play() " + n); }
	public String toString() { return "Brass"; }
	void adjust() { System.out.println("Adjusting Brass"); }
}

class Woodwind extends Wind {
	void play(Note n) { System.out.println("Woodwind.play() " + n); }
	public String toString() { return "Woodwind"; }
}

class Piano extends Wind {
	void play(Note n) { System.out.println("Piano.play() " + n); }
	public String toString() { return "Piano"; }
}

class RandomInstrumentGenerator{
	Random random = new Random(47);
	public Instrument next(){
		switch (random.nextInt(6)){
			default:
			case 0: return new Wind();
			case 1: return new Percussion();
			case 2: return new Stringed();
			case 3: return new Brass();
			case 4: return new Woodwind();
			case 5: return new Piano();
		}
	}
}

public class Music6 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument i) {
		//...
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] e) {
		for(Instrument i : e)
			tune(i);
	}

	public static void main(String[] args) {
		// Upcasting during addition to the array:
/*		Instrument[] orchestra = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new Woodwind(),
			new Piano()

		};
		tuneAll(orchestra);
		for(Instrument i : orchestra)
			System.out.println(i);*/
		RandomInstrumentGenerator instrumentGenerator = new RandomInstrumentGenerator();
		Instrument[] instruments = new Instrument[10];
		for (int i = 0; i < instruments.length ; i++) {
			instruments[i] = instrumentGenerator.next();
		}
		for(Instrument i : instruments)
			System.out.println(i);
	}
}