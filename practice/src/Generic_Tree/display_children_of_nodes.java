package Generic_Tree;

import java.util.*;

public class display_children_of_nodes {

	public static Node root = null;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		buildTree(arr);

		displayTree(root);
		
		System.out.println("\n node count = " + displaySize(root));
		System.out.println("\n Max node = " + displayMax(root));
		System.out.println("\n Depth = " + displayDepth(root));

	}

	public static class Node{
		
		int data ;
		ArrayList<Node> children = new ArrayList<Node>();

		Node(int data)
		{
			this.data = data;
		} 
	}

	public static int displayDepth(Node root)
	{
		int depth = -1;
		if(root == null)
		{
			return depth;
		}
		for(Node n : root.children)
		{
			depth = Math.max(depth , displayDepth(n));
		}		
		depth++;
		return depth;

	}

	public static int displayMax(Node root)
	{
		int max = Integer.MIN_VALUE;
		for(Node n : root.children)
		{
			max = Math.max(max , displayMax(n));
		}
		return Math.max(root.data , max);
	}

	public static int displaySize(Node root)
	{
		int count = 0;
		if(root == null)
		{
			return count;
		}

		count++;
		for(Node n : root.children)
		{
			count = count + displaySize(n);
		}
		return count;

	}	


	public static void displayTree(Node root)
	{

		if(root.children.size() == 0)
		{
			System.out.println(root.data + " --> " + ".");
			return ;
		}

		String str = root.data + " --> " ;
		for(Node n : root.children)
		{
			str = str + n.data + " ";
		}
		System.out.println(str);

		for(Node n : root.children)
		{
			displayTree(n);			
		}

	}
	
	public static void buildTree(int[] arr)
	{
		Stack<Node> stk = new Stack<Node>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] == -1)
			{
				stk.pop();
			}
			else
			{
				Node n = new Node(arr[i]);
				if(stk.size() > 0)
				{
					stk.peek().children.add(n);
				}
				else  
				{
					root = n;
				}
				stk.push(n);
			}
		}


	}





}
