package Hashmap_And_Heap;

import java.util.*;

public class Merge_K_sorted_lists {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> list_of_list = new ArrayList<List<Integer>>(); 
		Integer[] list1 = {10,20,30,40,50};
		Integer[] list2 = {5,7,9,11,19,55,57};
		Integer[] list3 = {1,2,3};
		Integer[] list4 = {32,39};

		list_of_list.add(Arrays.asList(list1));
		list_of_list.add(Arrays.asList(list2));
		list_of_list.add(Arrays.asList(list3));
		list_of_list.add(Arrays.asList(list4));

		System.out.println(list_of_list);
		displaySortedList(list_of_list);

	}

	public static void displaySortedList(ArrayList<List<Integer>> list_of_list)
	{
		ArrayList<Integer> res_list = new ArrayList<Integer>(); 
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for(int i = 0 ; i < list_of_list.size() ; i++)
		{
			pq.add(new Pair(i , 0 , list_of_list.get(i).get(0)));
		}

		while(pq.size() > 0)
		{
			Pair p = pq.remove();
			res_list.add(p.data_val);
			p.data_idx++;

			if(p.data_idx < list_of_list.get(p.list_idx).size())
			{
				p.data_val = list_of_list.get(p.list_idx).get(p.data_idx);
				pq.add(p); 
			}
			System.out.println(p);	//------> for understanding purpose -----
		}

		System.out.println(res_list);


	} 

	protected static class Pair implements Comparable<Pair>
	{
		int list_idx;
		int data_idx;
		int data_val;

		Pair(int list_idx , int data_idx , int data_val)
		{
			this.list_idx = list_idx;
			this.data_idx = data_idx;
			this.data_val = data_val;
		}

		public int compareTo(Pair o)
		{
			return this.data_val - o.data_val;
		}

		public String toString()
		{
			return this.list_idx + " " + this.data_idx + " " + this.data_val;
		}
	} 



}
