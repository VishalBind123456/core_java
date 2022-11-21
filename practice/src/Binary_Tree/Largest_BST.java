package Binary_Tree;
import java.util.*;
public class Largest_BST 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Node rootNode;
		Integer[] arr = new Integer[]{50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,77,null,null,87,null,null};
		// System.out.println(Arrays.toString(arr));
		rootNode = construct(arr);
		// BSTPair mp =  findLargestBST(rootNode);		System.out.println(mp);
		/*int[] post = {7,8,3,9,10,4,1,11,5,6,2,0};
		int[] in = {7,3,8,1,9,4,10,0,11,5,2,6};
		Node root = BTFromPostAndIn(in ,post, 0, in.length-1, 0, post.length-1); 	System.out.println(root);
		*/
		int[] pre = {30,20,10,15,25,23,39,35,42};
		// Integer idx = 0;
		Node root = BSTFromPreOrder(pre , idx , Integer.MIN_VALUE , Integer.MAX_VALUE); 	System.out.println(root);
	}

	public static Integer idx = 0;
	public static Node BSTFromPreOrder(int[] pre , int i , int min , int max)	//-----> i is useless
	{
		if(idx >= pre.length){
			return null;
		}
		int data = pre[idx];
		if(min < data && data < max){
			Node left = BSTFromPreOrder(pre , ++idx , min , data);
			Node right = BSTFromPreOrder(pre , ++idx , data , max);
			Node root = new Node(data , left , right);
			return root;
		}
		idx--;
		return null;
	}

	public static Node BTFromPostAndIn(int[] in , int[] post , int i , int j , int m , int n)
	{
		if(j < i){
			return null;
		}
		if(i == j){
			Node root = new Node(post[n] , null , null);
			return root;
		}
		int rootData = post[n];
		int rootIdx = -1;
		for(int x = i ; x <= j ; x++){
			if(in[x] == rootData){
				rootIdx = x;
			}
		}
		System.out.println(rootData + " " + rootIdx);	//-------------------------
		Node left = BTFromPostAndIn(in , post ,  i ,  rootIdx-1 ,  m , m+(rootIdx-1-i));
		Node right = BTFromPostAndIn(in , post ,  rootIdx+1 ,  j , m+(rootIdx-1-i)+1  ,  n-1);
		Node root = new Node(rootData , left , right);
		return root;
	}

	public static BSTPair findLargestBST(Node root)
	{
		BSTPair mp = new BSTPair();
		if(root == null){
			mp.isBST = true;
			mp.min = Integer.MAX_VALUE;
			mp.max = Integer.MIN_VALUE;
			mp.node = null;
			mp.size = 0;
			return mp;
		}
		BSTPair lp = findLargestBST(root.left);
		BSTPair rp = findLargestBST(root.right);
		mp.isBST = (root.data > lp.max && root.data < rp.min && rp.isBST && lp.isBST) ? true : false;
		mp.min = Math.min(root.data , Math.min(lp.min , rp.min));
		mp.max = Math.max(root.data , Math.max(lp.max , rp.max));
		if(mp.isBST){
			mp.node = root;
			mp.size = lp.size + rp.size + 1;
		}
		else{
			if(lp.size > rp.size){
				mp.node = lp.node;
				mp.size = lp.size;
			}
			else{
				mp.node = rp.node;
				mp.size = rp.size;
			}
		} 
		return mp; 
	}

	public static class BSTPair
	{
		boolean isBST;
		int min;
		int max;
		Node node;
		int size;
		public String toString(){
			return this.isBST + " " + this.min + " " + this.max + " tree--->[" + this.node + "] " + this.size; 
		}
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
