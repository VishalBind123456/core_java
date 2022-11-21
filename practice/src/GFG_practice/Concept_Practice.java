package GFG_practice;

public class Concept_Practice implements Runnable
{
		
	public static void foo(Object o) {
		System.out.println("Object");
	}
	
	public static void foo(String s) {
		System.out.println("Literal");
	}
	
	
	
	
	
	
	public final int i;

	{
		// System.out.println("instance block");
		// this.i = 24;
		// System.out.println(this.i);
	}

	static {
		// System.out.println("static block");
		// i = 28;
		// System.out.println(i);
	}
	
	Concept_Practice()
	{
		// System.out.println("Constructor block");
		this.i = 23;
		// System.out.println(this.i);
	} 
	
	public void run() {
		System.out.println("hello");
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(j);
		// int j;
		Concept_Practice cp = new Concept_Practice();
		Thread t1 = new Thread(cp);
//		t1.start();
		t1.start();
		
		foo(null);
		
		System.out.println(t1.getState());
		
//		console.log(1 < 2 < 3);

		// Concept_Practice.Test2 t2 = cp.new Test2();
		// t2.show();
		// System.out.println(t2.idx);

//		Test2 t2 = new Test2();
//		System.out.println(t2.idx);


	}

}

//public class Test1
//{
//	protected int idx = 11;
//	public void show()
//	{
//		System.out.println(this.idx);
//	}
//}
//
//public class Test2 extends Test1
//{
//	public int idx = 22;
//	public void show()
//	{
//		System.out.println(this.idx);
//	}
//}
