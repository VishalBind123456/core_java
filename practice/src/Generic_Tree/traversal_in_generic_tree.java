package Generic_Tree;

import java.util.*;

public class traversal_in_generic_tree {

	public static Node root = null;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		buildTree(arr);

		traverse(root);

		levelOrderTraversal(root);
		levelOrderLinewise(root);
		levelOrderLinewiseZigZag(root);


	}

	public static class Node{
		
		int data ;
		ArrayList<Node> children = new ArrayList<Node>();

		Node(int data)
		{
			this.data = data;
		} 
	}

	public static void levelOrderLinewiseZigZag(Node root)
	{
		ArrayDeque<Node> dq1 = new ArrayDeque<Node>(); 
		ArrayDeque<Node> dq2 = new ArrayDeque<Node>();
		System.out.println(); // just for new line 

		dq1.addFirst(root);
		boolean flag = true;

		while(dq1.size() != 0 || dq2.size() != 0)
		{

			if(dq1.size() == 0)
			{
				ArrayDeque<Node> temp = dq1;
				dq1 = dq2;
				dq2 = temp;
				System.out.println();
				flag = (flag) ? false : true;

			}

			if(flag)
			{
				Node current = dq1.peekFirst();
				System.out.print(current.data + " ");
				dq1.pollFirst();
				for(Node n : current.children)
				{
					dq2.addLast(n);
				}

			}
			else  
			{
				Node current = dq1.peekLast();
				System.out.print(current.data + " ");
				dq1.pollLast();
				for(int i = current.children.size() - 1 ; i >= 0  ; i--)
				{
					dq2.addFirst(current.children.get(i));
				}				

			}

		} 
	}


	public static void levelOrderLinewise(Node node)
	{
		ArrayDeque<Node> dq1 = new ArrayDeque<Node>(); 
		ArrayDeque<Node> dq2 = new ArrayDeque<Node>();

		dq1.addFirst(node);

		while(dq1.size() != 0 || dq2.size() != 0)
		{
			if(dq1.size() == 0)
			{
				ArrayDeque<Node> temp = dq1;
				dq1 = dq2;
				dq2 = temp;
				System.out.println();

			}

			Node current = dq1.peekFirst();
			System.out.print(current.data + " ");
			dq1.pollFirst();
			for(Node n : current.children)
			{
				dq2.addLast(n);
			}

		} 
	}

	public static void levelOrderTraversal(Node root)
	{
		ArrayDeque<Node> arr_dq = new ArrayDeque<Node>();
		if(arr_dq.size() == 0)
		{
			arr_dq.addFirst(root);
		}

		while(arr_dq.size() > 0)
		{
			Node current = arr_dq.peekFirst();
			System.out.println(current.data + " ");
			arr_dq.pollFirst();

			for(Node n : current.children)
			{
				arr_dq.addLast(n);
			}

		}
	}

	public static void traverse(Node root)
	{
		System.out.println(" Node pre " + root.data);
		for(Node n : root.children)
		{

			System.out.println(" Edge pre " + root.data + " - " + n.data);
			traverse(n);
			System.out.println(" Edge post " + root.data + " - " + n.data);
		}
		System.out.println(" Node post " + root.data);
	}

	public static void buildTree(int[] arr)
	{
		Stack<Node> stk = new Stack<Node>();
		//Node root_temp;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] == -1){ stk.pop(); }
			else{
				Node n = new Node(arr[i]);
				if(stk.size() > 0){ stk.peek().children.add(n); }
				else{ root = n; }
				stk.push(n);
			}
		}
		//return root_temp;
	}

}
