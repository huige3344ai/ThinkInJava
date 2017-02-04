
package com.hy.polymorphism;

class Glyph {
	private static String name ="Glyph";
	Glyph() {
		System.out.println("Glyph:Creating "+this);
	}
	public String toString() { return name; }

}

class RoundGlyph extends Glyph {
	private Glyph glyph;
	private static long count = 0;
	private static final long id = count++;
	//private final String name ="RoundGlyph";
	//private static String name ="RoundGlyph";
	//private static final String name ="RoundGlyph";
	private String name ="RoundGlyph";
	private int radius = 1;
	RoundGlyph(Glyph glyph) {
		System.out.println("RoundGlyph:Creating "+this);
		this.glyph = glyph;
	}
	public String toString(){return name+" id="+id;}
}

public class PolyConstructors15 {
	public static void main(String[] args) {
		new RoundGlyph(new Glyph());
/*		Glyph:Creating Glyph
		Glyph:Creating null id=0
		RoundGlyph:Creating RoundGlyph id=0*/
	}
}