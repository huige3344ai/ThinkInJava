package com.hy.reuse;// reusing/Ex5/C.java
// TIJ4 Chapter Reusing, Exercise 5, page 245
/* Create two classes, A and B, with default constructors (empty argument
* lists) that announce themselves. Inherit a new class called C from A, and
* create a member of class B inside C. Do not create a constructor for C. Create
* an object of class C and observe the resluts. 
*/
 

class A {
	A(String str){
		System.out.println("A()"+str);
	}
}

class B extends A {
	B(String str){
		super("B");
		System.out.println("B()"+str);
	}
}

public class C extends A {
	C(){
		super("C");
	}
	B b = new B("B"); // will then construct another A and then a B
	public static void main(String[] args) {
		C c = new C(); // will construct an A first
	}
}
