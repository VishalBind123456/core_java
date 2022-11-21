package GFG_practice;

class B {
	public static int num = 0;
    B() 
    {
    	System.out.println("B-Constructor Called"); 
    }
 
    {
		this.num = 100;    	
        System.out.println("B-IIB block");
        System.out.println(this.num);
    }
    static 
    {
    	num = 50;
        System.out.println("static  block");
        System.out.println(num);
    }
}
 
// Child class
class A extends B {
    A()
    {
        super();
        System.out.println("A-Constructor Called");
    }
    {
		this.num = 200;    	
        System.out.println("A-IIB block");
        System.out.println(this.num);
    }

 
    // main function
    public static void main(String[] args)
    {
        A a = new A();
    }
}
