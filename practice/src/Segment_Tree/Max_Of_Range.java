package Segment_Tree;

import java.util.*;

public class Max_Of_Range {

	public static SegmentNode root = null;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {8,7,4,2,5,3,1,10};
		int mask = 1;
		while(mask < arr.length)
		{
			mask = mask << 1;
		}
		int[] arr2 = new int[mask];
		Arrays.fill(arr2 , 0); 
		System.arraycopy(arr,0,arr2,0,arr.length);

		buildSegmentTree(arr2);
		// System.out.println(root.right.left.from + " " + root.right.left.to);

		long start2 =  System.nanoTime();
		System.out.println(getMaxInInterval_2(arr2 , 2 , 7));		//------------- normal method -----------
		long end2 =  System.nanoTime();
		System.out.println(end2 - start2 + " <---- duration in nanoseconds for Loop ");

		long start =  System.nanoTime();
		System.out.println(getMaxInInterval(root ,  arr2 , 2 , 7 ));
		long end =  System.nanoTime();
		System.out.println(end - start + " <---- duration in nanoseconds for SegmentTree ");

		update(4 , 9);
		System.out.println(getMaxInInterval(root ,  arr2 , 2 , 7 ));
		System.out.println(root.right.data);


	}

	public static void update(int idx , int val)
	{
		SegmentNode node = root;
		while(true)
		{
			if(node.from == node.to)
			{
				node.data = val;
				break;
			}
			node.data = (node.data < val) ? val : node.data ;
			if(idx >= node.left.from && idx <= node.left.to)
			{
				node = node.left;
			}
			else if(idx >= node.right.from && idx <= node.right.to)
			{
				node = node.right;
			}
		}

	}


	public static int getMaxInInterval_2(int[] arr , int l , int r)
	{
		int max = Integer.MIN_VALUE;
		for(int i = l ; i <= r ; i++ )
		{
			max = (arr[i] > max) ? arr[i] : max;
		}

		return max;
	}

	public static int getMaxInInterval(SegmentNode node ,  int[] arr , int l , int r)
	{
		if(node.to < l || node.from > r)
		{
			return Integer.MIN_VALUE;
		}

		if(node.from == node.to)
		{
			return node.data;
		}

		if((node.from == l && node.to <= r) || (l <= node.from && node.to == r))
		{
			return node.data;
		}
		else  
		{
			return Math.max(getMaxInInterval(node.left, arr, l, r) , getMaxInInterval(node.right, arr, l, r));
		}


	}

	public static void buildSegmentTree(int[] arr)
	{
		ArrayDeque<SegmentNode> arrdq = new ArrayDeque<>(); 
		ArrayDeque<SegmentNode> arrdq2 = new ArrayDeque<>(); 
		for(int i = 0 ; i < arr.length ; i++)
		{
			SegmentNode n = new SegmentNode();
			n.data = arr[i];
			n.nodeNo = i + arr.length - 1;
			n.from = i;
			n.to = i;
			arrdq.addLast(n);
		}

		for(int i = arr.length - 2 ; i >= 0 ; i--)
		{
			SegmentNode n = new SegmentNode();
			root = n;
			n.nodeNo = i;
			if(i*2 + 2  == arrdq.peekLast().nodeNo)
			{
				n.right = arrdq.pollLast();
				n.to = n.right.to;
				n.left = arrdq.pollLast();
				n.from = n.left.from;
				n.data = Math.max(n.left.data , n.right.data);
				arrdq2.addFirst(n);
			}
			if(arrdq.size() == 0)
			{
				arrdq = arrdq2;
				arrdq2 = new ArrayDeque<>();
			}

		}

	} 

	public static class SegmentNode{

		int nodeNo = -1;
		int data;

		int from  = -1;
		int to  = -1;

		SegmentNode left = null;
		SegmentNode right = null;
	}

}
