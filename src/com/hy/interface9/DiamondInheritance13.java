package com.hy.interface9;
// interfaces/DiamondInheritance13.java
// TIJ4 Chapter Interfaces, Exercise 13, page 328
/* Create an interface, and inherit two new interfaces from that
* interface. Multiply inherit a third interface from the second
* two. 
*/

interface CanDo {
	void doIt();
	void doIt2();
}

interface CanDoMore {
	void doMore();
	void doMore2();
}

interface CanDoFaster {
	void doFaster();
	void doFaster2();
}

interface CanDoMost extends CanDo, CanDoMore, CanDoFaster {
	void doMost();
}

abstract class Doctor {
	private int i = 0;
	abstract public void doc();
}


class Doer extends Doctor implements CanDoMost {
	public void doIt() {
		System.out.println("doIt");
	}

	@Override
	public void doIt2() {
		System.out.println("doIt2");

	}

	public void doMore() {
		System.out.println("doMore");

	}

	@Override
	public void doMore2() {
		System.out.println("doMore2");

	}

	public void doFaster() {
		System.out.println("doFaster");

	}

	@Override
	public void doFaster2() {
		System.out.println("doFaster2");

	}

	public void doMost() {
		System.out.println("doMost");

	}

	@Override
	public void doc() {
		System.out.println("Doc");
	}
}


public class DiamondInheritance13 extends  Doer{
	public static void canDo(CanDo canDo){
		canDo.doIt();
		canDo.doIt2();
	}
	public static void canDoFaster(CanDoFaster canDoFaster){
		canDoFaster.doFaster();
		canDoFaster.doFaster2();
	}
	public static void canDoMore(CanDoMore canDoMore){
		canDoMore.doMore();
		canDoMore.doMore2();
	}
	public static void doFaster(CanDoFaster canDoFaster){
		canDoFaster.doFaster();
		canDoFaster.doFaster2();
	}
	public static void main(String[] args) {
		DiamondInheritance13.canDo(new Doer());
		DiamondInheritance13.canDoFaster(new Doer());
		DiamondInheritance13.canDoMore(new Doer());
		DiamondInheritance13.doFaster(new Doer());
	}
}