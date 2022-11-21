package Hashmap_And_Heap;

import java.util.*;

public class longest_consecutive_sequence {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
		
		StringBuilder sequence = getLongestSequence(arr);
		System.out.println(sequence);


	}

	public static StringBuilder getLongestSequence(int[] arr)
	{
		HashMap<Integer , Boolean> hmap = new HashMap<Integer , Boolean>();

		for(int val : arr)
		{
			hmap.put(val , true);
		}

		for(int val : arr)
		{
			if(hmap.containsKey(val-1))
			{
				hmap.put(val , false);
			}
		}

		StringBuilder sequence = new StringBuilder(""); 
		int max = Integer.MIN_VALUE;

		for(int val : arr)
		{
			if(hmap.get(val))
			{
				int length = 0;
				StringBuilder stbr = new StringBuilder(""); 
				while(hmap.containsKey(val))
				{
					stbr.append(val + " ");
					length++;
					val++;
				}
				if(stbr.length() > max)
				{
					max = stbr.length();
					sequence = stbr;
				}
			}
		}

		return sequence;

	} 

}
