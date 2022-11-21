package Hashmap_And_Heap;

import java.util.*;

public class get_common_element {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr1 = {1,1,2,2,2,3,5};
		int[] arr2 = {1,1,1,2,2,4,5};

		printCommon(arr1 , arr2);
		printCommon2(arr1 , arr2);

	}

	public static void printCommon2(int[] arr1 , int[] arr2)
	{
		HashMap<Integer , Integer> hmap = new HashMap<Integer , Integer>();
		for(int i = 0 ; i < arr1.length ; i++)
		{
			if(hmap.containsKey(arr1[i]))
			{
				int count = hmap.get(arr1[i]);
				hmap.put(arr1[i] , count + 1);
			}
			else  
			{
				hmap.put(arr1[i] , 1);
			}
		}

		for(int val : arr2)
		{
			if(hmap.containsKey(val) && hmap.get(val) > 0)
			{
				int count = hmap.get(val);
				System.out.print(val + " ");
				hmap.put(val , count - 1);
			}
		}
		System.out.println();
	}

	public static void printCommon(int[] arr1 , int[] arr2)
	{
		HashMap<Integer , Integer> hmap = new HashMap<Integer , Integer>();

		for(int i = 0 ; i < arr1.length ; i++)
		{
			if(hmap.containsKey(arr1[i]))
			{
				int count = hmap.get(arr1[i]);
				hmap.put(arr1[i] , count + 1 );
			}
			else  
			{
				hmap.put(arr1[i] , 1 );
			}
		}


		//hmap.keySet();  //------returns (Set) of keys
		System.out.println(hmap.keySet().contains(1));

		for(int val : arr2)
		{
			if(hmap.containsKey(val))
			{
				System.out.println(val);
				hmap.remove(val);
			}
		}
		

	} 

}
