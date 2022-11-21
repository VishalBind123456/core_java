package Generic_Tree;

import java.util.*;

public class mirror_of_genericTree {

	public static Node root = null;
	public static Stack<Node> node_stack = new Stack<Node>();

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		buildTree(arr);

		printTree(root);

		// printMirrorOfGenericTree(root);

		/*removeLeaves(root);		
		System.out.println();
		printTree(root);*/

		linearizeTree(root);
		System.out.println();
		printTree(root);

	}

	public static void linearizeTree(Node node)
	{
		for(Node n : node.children)
		{
			linearizeTree(n);
		}

		while(node.children.size() > 1)
		{
			Node last_node = node.children.remove(node.children.size() - 1);
			Node second_last_node = node.children.get(node.children.size() - 1);

			getTail(second_last_node).children.add(last_node);
		}

	}

	public static Node getTail(Node node)
	{
		if(node.children.size() == 0)
		{
			return node;
		}
		return getTail(node.children.get(0));
	
	}


	public static int removeLeaves(Node node)
	{
		if( node.children.size() == 0 )
		{
			//node_stack.pop();
			return 0;
		}
		else  
		{
			for(int i = 0 ; i < node.children.size() ; i++)
			{
				int x = removeLeaves(node.children.get(i));
				if(x == 0)
				{
					node.children.remove(i);
					i--;
				}
			}
		}
		return 1;
	}


	public static void printMirrorOfGenericTree(Node root)
	{

		Stack<Node> stk2 = new  Stack<Node>();
		ArrayDeque<Node> dq3 = new ArrayDeque<Node>();
		dq3.addLast(root);
		while(dq3.size() != 0)
		{
			Node current = dq3.pollFirst();
			for(Node n : current.children )
			{
				stk2.push(n);
				dq3.addLast(n);
			}
			current.children = new ArrayList<>();
			while(stk2.size() != 0)
			{
				current.children.add(stk2.peek());
				stk2.pop();
			}

		}

		printTree(root);




		/*ArrayDeque<Node> dq1 = new ArrayDeque<Node>();
		ArrayDeque<Node> dq2 = new ArrayDeque<Node>();
		Stack<Node> stk = new  Stack<Node>();

		dq1.addLast(root);

		while(dq1.size() != 0 || dq2.size() != 0)
		{

			if(dq1.size() == 0)
			{
				ArrayDeque<Node> temp = dq1;
				dq1 = dq2;
				dq2 = temp;
			}

			Node current = dq1.pollFirst();
			for(Node n : current.children)
			{	
				stk.push(n);
				dq2.addLast(n);
			}
			current.children = new ArrayList<>();
			while(stk.size() != 0)
			{
				current.children.add(stk.peek());
				stk.pop();
			}

		}

		System.out.println();
		printTree(root);*/


	}

	public static class Node{
		
		int data ;
		ArrayList<Node> children = new ArrayList<>();

		Node(int data)
		{
			this.data = data;
		} 
	}

	public static void printTree(Node rootNode)
	{
		ArrayDeque<Node> dq1 = new ArrayDeque<Node>();
		ArrayDeque<Node> dq2 = new ArrayDeque<Node>();

		dq1.addLast(rootNode);

		while(dq1.size() != 0 || dq2.size() != 0)
		{
			if(dq1.size() == 0)
			{
				ArrayDeque<Node> temp = dq1;
				dq1 = dq2;
				dq2 = temp;
				System.out.println();
			}

			Node current = dq1.pollFirst();
			System.out.print(current.data + " ");
			for(Node n : current.children)
			{
				dq2.addLast(n);
			}


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
