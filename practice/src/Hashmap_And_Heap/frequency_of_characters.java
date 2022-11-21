package Hashmap_And_Heap;

import java.util.*;

public class frequency_of_characters {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "abracadabra";
		printAllFrequency(str);

	}

	public static void printAllFrequency(String str)
	{
		HashMap<Character , Integer> hmap = new HashMap<Character , Integer>();
		int max = Integer.MIN_VALUE;
		Character ch = null;  // char ch = null;  dont work here.....!!!

		for(int i = 0 ; i < str.length() ; i++)
		{
			if(hmap.containsKey(str.charAt(i)))
			{
				int count = hmap.get(str.charAt(i)) + 1;
				hmap.put(str.charAt(i) , count );
				if( count > max )
				{
					max = count;
					ch = str.charAt(i);
				}
			}
			else  
			{
				hmap.put(str.charAt(i) ,  1 );
			}

		}



		System.out.println(hmap);
		System.out.println(ch + " --> " + max);


	}


}
