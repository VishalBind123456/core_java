package Generic_Tree;

import java.util.*;

import Generic_Tree.traversal_in_generic_tree;

public class find_an_element_in_tree extends traversal_in_generic_tree{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		buildTree(arr);

		levelOrderLinewise(root);

		StringBuilder path = findElement(root , 80 , new StringBuilder(""));
		System.out.println( "\npath to required element ---> " + path );		

		printLowestCommonAncistor(80 , 110);
		printDistanceBetweenNodes(20 , 80);

	}

	public static void printDistanceBetweenNodes(int element1 , int element2)
	{
		StringBuilder first = findElement(root , element1 , new StringBuilder(""));
		StringBuilder second = findElement(root , element2 , new StringBuilder(""));

		String[] arr1 = first.toString().split(" ");
		String[] arr2 = second.toString().split(" ");

		int i = 0;

		String prev = "";
		String curr = "";
		while(true)
		{
			prev = curr;
			if(i >= arr1.length || i >= arr2.length || !arr1[i].equals(arr2[i]))
			{	
				i--;
				break;
			}
			curr = arr1[i];
			i++;
		}

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		System.out.println((arr1.length - i - 1) + (arr2.length - i - 1));

	}

	public static void printLowestCommonAncistor(int element1 , int element2)
	{

		StringBuilder first = findElement(root , element1 , new StringBuilder(""));
		StringBuilder second = findElement(root , element2 , new StringBuilder(""));

		int i = 0;
		String[] arr1 = first.toString().split(" ");
		String[] arr2 = second.toString().split(" ");

		String curr = "";
		String prev = "";
		while(true)
		{
			prev = curr;
			if(i >= arr1.length || i >= arr2.length || !arr1[i].equals(arr2[i]))
			{
				break;
			}
			curr = arr1[i];
			i++;
		}

		System.out.println(prev);
	}
	
	public static StringBuilder findElement(Node parent , int element , StringBuilder path)
	{

		path.append(parent.data + " ");
		// path.insert(0 , parent.data + " ");		//-----> for reverse Path ----

		if(parent.data == element)
		{
			return path;
		}

		if(parent.children.size() == 0)
		{
			return null;
		}

		StringBuilder ans = null;
		for(Node n : parent.children)
		{
			ans = findElement(n , element , new StringBuilder(path));
			if(ans != null)
			{
				break; 
			}
		}

		return ans;

	}



}
