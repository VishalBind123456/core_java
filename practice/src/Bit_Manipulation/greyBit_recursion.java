package Bit_Manipulation;

import java.util.*;

public class greyBit_recursion {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 20;

		long start2 =  System.nanoTime();
		System.out.println( getGreyBits(n) );
		long end2 =  System.nanoTime();

		long start =  System.nanoTime();
		System.out.println( getGreyBitsDP(n) );
		long end =  System.nanoTime();
		System.out.println(end2 - start2 + " <---- duration in nanoseconds for recursion ");
		System.out.println(end - start + " <---- duration in nanoseconds for DP ");


	}

	public static ArrayList<String> getGreyBitsDP(int n)
	{
		ArrayList<String>[] arr_al = new ArrayList[n+1];

		for(int i = 0 ; i < arr_al.length ; i++)
		{
			arr_al[i] = new ArrayList<>();
		}

		arr_al[0].add("");

		for(int i = 1 ; i < arr_al.length ; i++)
		{
			
			for(String s : arr_al[i-1])
			{
				arr_al[i].add( "0" + s );
			}

			for( int j = arr_al[i-1].size() - 1 ; j >= 0 ; j-- )
			{
				arr_al[i].add( "1" + arr_al[i-1].get(j) );
			}

		}

		return arr_al[n];

	} 

























	public static ArrayDeque<String> getGreyBits(int n)
	{
		ArrayDeque<String> res = new ArrayDeque<String>();

		if(n == 0)
		{
			res.addLast("");
			return res;
		}


		ArrayDeque<String> res1 = getGreyBits(n-1);
		ArrayDeque<String> res2 = res1.clone();

		while(res1.size() != 0)
		{
			res.addLast("0" + res1.pollFirst());
		}

		while(res2.size() != 0)
		{
			res.addLast("1" + res2.pollLast());
		}

		return res;


	} 


}
