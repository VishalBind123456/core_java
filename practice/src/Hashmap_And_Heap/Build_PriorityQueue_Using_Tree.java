package Hashmap_And_Heap;

import java.util.ArrayList;

public class Build_PriorityQueue_Using_Tree {

	public static void main(String[] args) 		//-------------------> remove ------ remaining ------ !!!
	{
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue();
						// System.out.println(Math.ceil((double)3/2));
		pq.add(30);
		pq.add(40);
		pq.add(50);
		pq.add(10);

		pq.remove();
		
		pq.print();

	}

	public static class PriorityQueue
	{
		protected static ArrayList<Integer> al = new ArrayList<Integer>();

		public void add(int a)
		{
			al.add(a);
			if(al.size() >= 2)
			{
				upHeapify();
			}
		}

		public void remove()
		{
			int last_idx = al.size() - 1;
			swap(0 , last_idx);
			al.remove(last_idx);

			if(al.size() >= 2)
			{
				downHeapify();
			}

		} 

		protected static void downHeapify()
		{
			int parent_idx = 0;
			int left = 2*parent_idx + 1;
			int right = 2*parent_idx + 2;

			while(left < al.size() && al.get(parent_idx) > al.get(left))
			{
				if(right < al.size() && al.get(left) > al.get(right))
				{
					swap(right , parent_idx);
					parent_idx = right;
					right = 2*parent_idx + 2;
				}
				else if(left < al.size()) 
				{
					swap(left , parent_idx);
					parent_idx = left;
					left = 2*parent_idx + 1;
				}

			}

		}

		protected static void upHeapify()
		{
			int child_idx = al.size() - 1;
			int parent_idx = (int)Math.ceil((double)child_idx/2) - 1;

			// System.out.println(child_idx + " " + parent_idx);

			while(al.get(child_idx) < al.get(parent_idx))
			{

				swap(child_idx , parent_idx);
				child_idx = parent_idx;
				parent_idx = (int)Math.ceil((double)child_idx/2) - 1;

				if(parent_idx < 0)
					break;

			}
		}

		protected static void swap(int i , int j)
		{
			int temp = al.get(i);
			al.set(i , al.get(j));
			al.set(j , temp);
		}

		public static void print()
		{
			System.out.println(al);
		}

		public static int size()
		{
			return al.size();
		}

	}


}
