package Queue;

import java.util.*;

public class Priority_Queue {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
		PriorityQueue<Integer> pQueue  = new PriorityQueue<Integer>(Collections.reverseOrder());  //by default priority is to smaller element

		for(int val : arr)
		{
			pQueue.add(val);
		}

		while(pQueue.size() > 0)
		{
			System.out.println(pQueue.peek());
			pQueue.remove();
		}

		K_largest_Elements(arr , 3).stream().forEach(element -> { System.out.print(element + " "); });

	}

	public static PriorityQueue<Integer> K_largest_Elements(int[] arr , int k)
	{
		PriorityQueue<Integer> pQueue  = new PriorityQueue<Integer>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i < k)
			{
				pQueue.add(arr[i]);
			}
			else  
			{
				if(arr[i] > pQueue.peek())
				{
					pQueue.remove();
					pQueue.add(arr[i]);
				}
			}
		}

		return pQueue;
	}


}
