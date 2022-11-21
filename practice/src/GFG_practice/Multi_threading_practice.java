package GFG_practice;

public class Multi_threading_practice 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Runnable r1 = new Runnable(){
			public void run(){
				try{
					while(true){
						System.out.println("thread 1");
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e){
					e.printStackTrace();				
				}
			}

		};
		Runnable r2 = new Runnable(){
			public void run(){
				try{
					while(true){
						System.out.println("thread 2");
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e){
					e.printStackTrace();				
				}
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
