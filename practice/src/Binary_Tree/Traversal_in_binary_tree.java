package Binary_Tree;
import java.util.*;
public class Traversal_in_binary_tree 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Node rootNode;
		Integer[] arr = new Integer[]{50,25,12,null,null,37,30,null,null,null,75,62,null,70,72,null,null,null,87,null,null};
		// System.out.println(Arrays.toString(arr));
		rootNode = construct(arr);
		// System.out.println(rootNode);
		// traversal(rootNode);	System.out.println();
		// traversalIterative(rootNode);	System.out.println();
		// levelOrderTraversal(rootNode);	System.out.println();
		// findPath(rootNode , 87);	System.out.println(path);
		// print_elements_of_Kth_level(rootNode , 2);	System.out.println();
		print_nodes_K_level_far(rootNode , 75 , 3);	System.out.println();
	}

	public static void print_nodes_K_level_far(Node root , int data , int k)
	{
		findPath(root , data);
		// System.out.println(path);
		HashSet<Integer> exclusion_set = new HashSet<>();
		for(Integer i : path){
			if(k >= 0){
				Node node = getElement(root , i);
				print_elements_of_Kth_level_2(node , k  , exclusion_set);
				exclusion_set.add(i);
				k--;
			}
		}
	}

	public static void print_elements_of_Kth_level_2(Node root , int k , HashSet<Integer> exclusion_set)
	{
		if(exclusion_set.contains(root.data)){
			return;
		}
		if(k == 0){
			System.out.print(root.data + " ");
			return;
		}
		if(root.left != null){
			print_elements_of_Kth_level_2(root.left , k-1 , exclusion_set);
		}
		if(root.right != null){
			print_elements_of_Kth_level_2(root.right , k-1 , exclusion_set);
		}
	}

	public static Node getElement(Node root , int data)
	{
		if(root == null){
			return null;
		}
		if(root.data == data){
			return root;
		}
		Node left = getElement(root.left , data);
		if(left != null)
			return left;
		Node right = getElement(root.right , data);
		if(right != null)
			return right;
		return null;
	}

	public static void print_elements_of_Kth_level(Node root , int k)
	{
	
		if(k == 0){
			System.out.print(root.data + " ");
			return;
		}
		if(root.left != null){
			print_elements_of_Kth_level(root.left , k-1);
		}
		if(root.right != null){
			print_elements_of_Kth_level(root.right , k-1);
		}
	}

	public static ArrayList<Integer> path = new ArrayList<>();
	public static boolean findPath(Node root , int data)
	{
		if(root == null){
			return false;
		}
		if(root.data == data){
			path.add(root.data);
			return true;
		}
		boolean findRight = findPath(root.left , data);
		if(findRight){
			path.add(root.data);
			return true;
		}
		boolean findLeft = findPath(root.right , data);
		if(findLeft){
			path.add(root.data);
			return true;
		}
		return false;
	}

	public static void levelOrderTraversal(Node root)
	{
		ArrayDeque<Node> dq = new ArrayDeque<>();
		ArrayDeque<Node> dq2 = new ArrayDeque<>();
		dq.addLast(root);
		while(dq.size() > 0){
			while(dq.size() > 0){
				Node node = dq.removeFirst();
				if(node.left != null){
					dq2.addLast(node.left);
				}
				if(node.right != null){
					dq2.addLast(node.right);
				}
				System.out.print(node.data + " ");
			}
			dq = dq2;
			dq2 = new ArrayDeque<>();
			System.out.println();
		}
	}

	public static void traversalIterative(Node root)
	{
		StringBuilder pre = new StringBuilder("");
		StringBuilder in = new StringBuilder("");
		StringBuilder post = new StringBuilder("");
		Stack<Pair> stk = new Stack<>();
		stk.push(new Pair(root , 0));
		while(stk.size() > 0){
			Pair pair = stk.peek();
			if(pair.state == 0){
				pre.append(pair.node.data + " ");
				pair.state++;
				if(pair.node.left != null){
					stk.push(new Pair(pair.node.left , 0));
				}
			}
			else if(pair.state == 1){
				in.append(pair.node.data + " ");
				pair.state++;
				if(pair.node.right != null){
					stk.push(new Pair(pair.node.right , 0));
				}
			}
			else if(pair.state == 2){
				post.append(pair.node.data + " ");
				stk.pop();
			}
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

	public static void traversal(Node root)
	{
		if(root == null){
			System.out.print("null ");
			return;
		}
		System.out.print(root.data + " "); //---> you can change its position for preOrder , inOrder , postOrder ...
		traversal(root.left);	
		traversal(root.right);
	}

	public static Node construct(Integer[] arr)
	{
		Stack<Pair> stk = new Stack<>();
		Node root = new Node(arr[0] , null , null);
		stk.push(new Pair(root , 0));
		// System.out.println(root);
		int idx = 1;	
		while(stk.size() > 0){
			Pair pair = stk.peek();
			if(pair.node == null){
				// idx++;
				stk.pop();
				continue;
			}
			if(pair.state == 0){
				Node ln = (arr[idx] != null) ? new Node(arr[idx] , null , null) : null;
				pair.node.left = ln;
				pair.state++;
				stk.push(new Pair(ln , 0));
			}
			else if(pair.state == 1){
				Node rn = (arr[idx] != null) ? new Node(arr[idx] , null , null) : null;
				pair.node.right = rn;
				pair.state++;
				stk.push(new Pair(rn , 0));
			}
			else if(pair.state == 2){
				stk.pop();
				continue;
			}
			idx++;
		}
		return root;	
	} 

	public static class Node
	{
		Integer data;
		Node left;
		Node right;
		Node(Integer data,Node left,Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public String toString(){
			return this.data + " " + this.left + " " + this.right;
		}
	}

	public static class Pair
	{
		Node node;
		int state;
		Pair(Node node , int state){
			this.node = node;
			this.state = state;
		}
	}

}
