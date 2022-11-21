package Bit_Manipulation;

public class josephus_problem {		//----> if alternet soilders are killed then who will remain in last ------

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int n = 999999999;
		long start = System.nanoTime();
		getLastSoilder(n);
		long end = System.nanoTime();
		System.out.println(end - start);

		long start2 = System.nanoTime();
		getLastSoilder_2(n);
		long end2 = System.nanoTime();
		System.out.println(end2 - start2);



	}

	public static void getLastSoilder(int n)
	{
		int current = 1;
		int prev = 1;
		while(current <= n )
		{
			prev = current;
			current = current << 1;
		}

		int l = n - prev;	//----------> brilliant concept , you need to mugup this formula of getting last soilder

		int lastSoilder = 2*l + 1;

		System.out.println(lastSoilder); 

	}

	public static void getLastSoilder_2(int n)
	{
		String ans = "1";
		int mask = 1;
			
		while(n > 1)
		{
			if((n & mask) == 0 )
			{
				ans = "0" + ans;
			}
			else 
			{
				ans = "1" + ans;
			}
			n = n >>> mask;
		}

		//System.out.println(ans); 

		int num = 0;
		int two = 1;
		for(int i = 0 ; i < ans.length() ; i++)
		{
			num = num + (ans.charAt(ans.length() - i - 1) - '0') * (two << i)   ;
		}

		System.out.println(num); 


	}


}
