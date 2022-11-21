package Stack;
import java.util.*;

public class merge_overlaping_intervals 
{
	public static void main(String[] args) 
	{
		int[][] arr = {
			{22,28},
			{1,8},
			{25,27},
			{14,19},
			{27,30},
			{5,12},
		};
		// printIntervals(arr);
		// Smallest_number_following_Pattern("ddiididd");
		Person p1 = new Person();
		p1.data = 30;
		Person p2 = new Person();
		p2.data = 40;
		System.out.println("p1 -> " + p1.data);
		System.out.println("p2 -> " + p2.data);
		swap(p1 , p2);
		System.out.println("p1 -> " + p1.data);
		System.out.println("p2 -> " + p2.data);
		

	}

	public static class Person
	{
		int data;
	} 

	public static void swap(Person p1 , Person p2)
	{
		Person temp;
		temp = p1;
		p1 = p2;
		p2 = temp;
	}

	public static void Smallest_number_following_Pattern(String str2)
	{
		String str = str2 + 'i';
		int counter = 1;
		class Pair
		{
			char ch;
			int val;
			Pair(char ch , int val)
			{
				this.ch = ch;
				this.val = val;
			}
		}
		Pair[] p_arr = new Pair[str.length()]; 
		for(int i = 0 ; i < str.length() ; i++)
		{
			p_arr[i] = new Pair(str.charAt(i) , 0);
		}
		Stack<Pair> stk = new Stack<Pair>();
		for(int i = 0 ; i < p_arr.length ; i++)
		{
			if(p_arr[i].ch == 'd')
			{
				stk.push(p_arr[i]);
			}
			else if(p_arr[i].ch == 'i')
			{
				p_arr[i].val = counter++;	
				while(stk.size() > 0)
				{
					stk.peek().val = counter++;
					stk.pop(); 
				}
			}
		}
		for(int i = 0 ; i < p_arr.length ; i++)
		{
			// System.out.print(p_arr[i].ch);
			System.out.print(p_arr[i].val);
		}



	}

	public static void printIntervals(int[][] arr)
	{
		Pair[] p_arr = new Pair[arr.length]; 
		for(int i = 0 ; i < arr.length ; i++)
		{
			p_arr[i] = new Pair(arr[i][0] , arr[i][1]);
		}
		Arrays.sort(p_arr , Collections.reverseOrder());
		System.out.println(Arrays.toString(p_arr));
		Stack<Pair> stk = new Stack<Pair>();
		stk.push(p_arr[0]);
		for(int i = 1 ; i < p_arr.length ; i++)
		{
			if(p_arr[i].dest >= stk.peek().src)
			{
				stk.peek().src = p_arr[i].src;
			}
			else
			{
				stk.push(p_arr[i]);
			}
		}
		while(stk.size() > 0)
		{
			System.out.println(stk.peek());
			stk.pop();
		}
	} 

	public static class Pair implements Comparable<Pair>
	{
		int src;
		int dest;
		Pair(int src,int dest)
		{
			this.src = src;
			this.dest = dest;
		}
		public int compareTo(Pair o)
		{
			return this.src - o.src;
		}
		public String toString()
		{
			return this.src + " - " + this.dest;
		}
	}

}
