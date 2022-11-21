package Hashmap_And_Heap;

import java.util.*;

public class Sort_K_sorted_Array {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,4,6,7,5,8,9};

		int k = 2;

		k_Sort_Array(arr , k);

	}

	public static void k_Sort_Array(int[] arr , int k)
	{
		int[] ans = new int[arr.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < arr.length ;i++)
		{
			if(pq.size() <= k)
			{
				pq.add(arr[i]);
			}
			else   
			{
				ans[i-k] = pq.peek();
				pq.remove();
				pq.add(arr[i]);
			}

		}
		while(pq.size() != 0)
		{
			ans[arr.length - pq.size()] = pq.peek();
			pq.remove();
		}

		System.out.println(Arrays.toString(ans));

	} 

}
