package Dynamic_programming;
import java.util.*;
public class Ugly_numbers {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k = 15;
		// printUglyNumber(k);

		// int[] primes = {3,5,7,11};
		int[] primes = {2,3,5};
		superUglyNumber(k , primes);
	}

	public static void superUglyNumber(int k , int[] primes)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		
		int[] pointers = new int[primes.length];
		Arrays.fill(pointers , 0);	//-----> not necessary because by default int[]  is filled with zeros only -----

		boolean flag = true;
		while(flag)
		{
			int min = Integer.MAX_VALUE;
			for(int i = 0 ; i < primes.length ; i++)
				if(primes[i]*al.get(pointers[i]) < min)
					min = primes[i]*al.get(pointers[i]);

			al.add(min);
			if(min >= k)
				flag = false;

			for(int i = 0 ; i < primes.length ; i++)
				if(primes[i]*al.get(pointers[i]) == min)
					pointers[i]++;
				
		System.out.println(Arrays.toString(pointers));
		System.out.println(al);
		}

	}

	public static void printUglyNumber(int k)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);

		int p2 = 0, p3 = 0, p5 = 0;
		int min = 0;
		boolean flag = true; 
		while(flag)
		{
			int val2 = al.get(p2) * 2;
			int val3 = al.get(p3) * 3;
			int val5 = al.get(p5) * 5;

			if(val2 <= val3 && val2 <= val5)
			{
				min = val2;
				p2++;
			}
			if(val3 <= val2 && val3 <= val5)
			{
				min = val3;
				p3++;
			}
			if(val5 <= val2 && val5 <= val3)
			{
				min = val5;
				p5++;
			}
			al.add(min);

			if(min >= k)
				flag = false;

		}

		System.out.println(al);

	} 

}
