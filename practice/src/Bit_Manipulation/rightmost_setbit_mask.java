package Bit_Manipulation;

import java.util.*;

public class rightmost_setbit_mask {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int x = 27;
		System.out.println(Integer.toBinaryString(x));
		x = x & -x; 
		System.out.println(Integer.toBinaryString(x) + " <---- actually the answer should be (00100) ");

		countSetBits(-11);
		countSetBits_2(-11);

	}

	public static void countSetBits(int x) //-----> NO smart method because we are checking every bits------------
	{

		System.out.println(Integer.toBinaryString(x));

		int count = 0;
		int mask = 1;
		while(x != 0)
		{
			if((x & mask) != 0)
			{
				count++;
			}
			x = x >>> 1;
		}

		System.out.println(count + " <---- no of set bits using Loop ");

	} 

	public static void countSetBits_2(int x) //-----> smart method based on bit manipulation------------
	{
		System.out.println(Integer.toBinaryString(x));
		
		int count = 0;
		while(x != 0)
		{
			int temp = 0;
			temp = x & -x;

			x = x - temp;
			// x = x ^ temp; //-----> also works ------
			count++;
		}

		System.out.println(count + " <---- no of set bits using bit manipulation ");
	
	}



}
