package Generic_Tree;
import java.util.*;
public class diameter_of_generic_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root;
		int[] arr = {10,20,-50,-1,60,-1,-1,30,70,-1,-80,110,-1,-120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
		root = constructTree(arr);
		getMaxSumTree(root);
		getDiameter(root);
		
		// System.out.println(maxSum);
		// System.out.println(diameter);
		// printIterativePreAndPost(root);

		GenericTree gt = new GenericTree(root);
		/*Iterator gti = gt.iterator();
		while(gti.hasNext())
		{
			Node node = (Node)gti.next();
			System.out.println(node.data);
		}*/

		for(Node node : gt)
			System.out.println(node.data);	


	}

	protected static class GenericTree implements Iterable<Node>
	{
		public static Node root;
		GenericTree(Node node)	//----> constructor ----
		{
			this.root = node;
		}
		public Iterator<Node> iterator()
		{
			Iterator<Node> gti = new GenericTreeIterator(root);  
			return gti;
		}

	}

	protected static class GenericTreeIterator implements Iterator<Node>
	{
		protected Node next = null;
		protected Stack<Pair> stk = new Stack<Pair>();
		GenericTreeIterator(Node node)
		{
			this.stk.push(new Pair(node , -1));
			this.next();
			this.returnSelf();
		}	

		public GenericTreeIterator returnSelf()
		{
			return this;
		}

		public boolean hasNext()
		{
			if(this.next == null)
				return false;
			return true;
		}

		public Node next()
		{
			// this.stk.push(new Pair(root , -1));
			Node curr_node = this.next;
			this.next = null;
			while(this.stk.size() > 0)
			{
				Pair p = this.stk.peek();
				if(p.state == -1)
				{
					this.next = p.node;
					p.state++;
					break;
				}
				else if(p.state == p.node.children.size())
				{
					this.stk.pop();
				}
				else    
				{
					this.stk.push(new Pair(p.node.children.get(p.state) , -1));
					p.state++;
				}

			}
			return curr_node;
		}

	}

	protected static class Node
	{
		protected int data;
		protected ArrayList<Node> children = new ArrayList<Node>();

		Node(int data)
		{
			this.data = data;
		}

	}



	public static void printIterativePreAndPost(Node root)
	{
		Stack<Pair> stk = new Stack<Pair>();
		stk.push(new Pair(root , -1));

		StringBuilder pre = new StringBuilder("");
		StringBuilder post = new StringBuilder("");

		while(stk.size() > 0)
		{
			Pair p = stk.peek();
			if(p.state == -1)
			{
				pre.append(p.node.data + " ");
				p.state++;
			}
			else if(p.state == p.node.children.size())
			{
				post.append(p.node.data + " ");
				stk.pop();
			}
			else    
			{
				stk.push(new Pair(p.node.children.get(p.state) , -1));
				p.state++;
			}

		}
		System.out.println(pre);
		System.out.println(post);

	}

	protected static class Pair
	{
		Node node;
		int state;
		Pair(Node node , int state)
		{
			this.node = node;
			this.state = state;
		}
	}

	public static int diameter = Integer.MIN_VALUE;
	public static int getDiameter(Node root)
	{
		int dc = -1;
		int sdc = -1;
		for(Node n : root.children)
		{
			int a = getDiameter(n);
			if(a > dc)
			{
				sdc = dc;
				dc = a;
			}
			else if(a > sdc)
			{
				sdc = a;
			}
		}
		if(dc + sdc + 2 > diameter)
			diameter = dc + sdc + 2;

		return dc + 1;

	}

	public static int maxSum = Integer.MIN_VALUE;
	public static int getMaxSumTree(Node root)
	{
		int curr_sum = 0;
		for(Node n : root.children)
		{
			int mx = getMaxSumTree(n);
			curr_sum += mx;
		}
		if(curr_sum + root.data > maxSum)
			maxSum = curr_sum + root.data;
		return curr_sum + root.data;
	}

	public static Node constructTree(int[] arr) 
	{
		Stack<Node> stk = new Stack<Node>();
		Node root = null;
		for(int i : arr)
		{
			if(i == -1)
			{
				root = stk.pop(); 
				continue;
			}
			Node n = new Node(i);
			if(stk.size() != 0)
				stk.peek().children.add(n);
			stk.push(n);
		}
		return root;
	}


}
