package Generic_Tree;

import java.util.*;
import Generic_Tree.traversal_in_generic_tree;

public class linearize_generic_tree extends traversal_in_generic_tree {

	// public static Node root = null;  //----------> this variable is already present in parent class ------

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		buildTree(arr);

		linearize_efficient(root);

		levelOrderLinewise(root);
	}

	public static Node linearize_efficient(Node node)
	{
		if(node.children.size() == 0)
		{
			return node;
		}

		Node lkt = linearize_efficient(node.children.get(node.children.size() - 1)); 
		while(node.children.size() > 1)
		{
			Node last = node.children.remove(node.children.size() - 1);
			Node slkt = linearize_efficient(node.children.get(node.children.size() - 1));

			slkt.children.add(last);
		}
		return lkt;

	}

	/*public static void buildTree(int[] arr)
	{
		Stack<Node> stk = new Stack<Node>();
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
	}

	public static void levelOrderLinewise(Node root)
	{
		ArrayDeque<Node> dq1 = new ArrayDeque<Node>(); 
		ArrayDeque<Node> dq2 = new ArrayDeque<Node>();
		dq1.addFirst(root);
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
	}*/

	/*public static class Node
	{
		int data ;
		ArrayList<Node> children = new ArrayList<Node>();
		Node(int data)
		{
			this.data = data;
		} 
	}*/


}
