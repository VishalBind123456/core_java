package Dynamic_programming;
import java.util.*;
public class Zero_One_Knapsack_Problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		/*int[] val = {15 , 14 , 10 , 45 ,30};	
		int[] wt = {2 , 5 , 1 , 3 , 4};
		int max_wt = 7;*/

		int[] val = {60 , 100 , 120};
		int[] wt = {10 , 20 , 25};
		int max_wt = 50;
		
		int n = wt.length; 

		// getMaxValue(n , val ,  wt , max_wt);
		double x = fractional_knapsack(n , val ,  wt , max_wt);
		System.out.println(x);

	}

	public static double fractional_knapsack(int n , int[] val , int[] wt , int max_wt)
	{
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());
		for(int i = 0 ; i < n ; i++)
		{
			pq.add( new Pair(wt[i] , val[i]) );
		}

		double curr_value = 0;
		int curr_weight = 0;


		while(pq.size() > 0)
		{
			Pair p = pq.remove();
			if(curr_weight + p.weight > max_wt)
			{
				curr_value += p.value * (max_wt - curr_weight)/p.weight; 
				break;
			}
			curr_weight += p.weight;
			curr_value += p.value;
		}

		return curr_value;

	}

	public static int getMaxValue(int n , int[] val , int[] wt , int max_wt)
	{

		int[][] board = new int[n+1][max_wt + 1];

		for(int i = 0 ; i <= n ; i++)
		{
			for(int j = 0 ; j <= max_wt ; j++)
			{

				if(i == 0 && j == 0)
				{
					board[i][j] = 0;
				}
				else if(i == 0)
				{
					board[i][j] = 0;
				}
				else if(j == 0)
				{
					board[i][j] = 0;
				}
				else if(wt[i-1] > j)
				{
					board[i][j] = board[i-1][j];
				}
				else if(wt[i-1] == j)
				{
					board[i][j] = Math.max(val[i-1] , board[i-1][j]);
				}
				else if(wt[i-1] < j)
				{
					board[i][j] = Math.max(val[i-1] + board[i-1][j-wt[i-1]] , board[i-1][j]);	//----> for 0/1 knapsack problem
					// board[i][j] = Math.max(val[i-1] + board[i][j-wt[i-1]] , board[i-1][j]);	//----> for unbounded 0/1 knapsack problem
				}

			}

		}

		for(int[] ar : board)
		{
			System.out.println(Arrays.toString(ar));
		}

		StringBuilder sb = new StringBuilder("");
		int i = n;
		int j = max_wt;
		while(j != 0)
		{
			if(board[i-1][j] == board[i][j])
			{
				i = i-1;
			}
			else   
			{
				sb.append(wt[i-1] + " ");
				j = j - wt[i-1];
			}
		}
		System.out.println(sb);

		return board[n][max_wt];

	} 


	public static class Pair implements Comparable<Pair>
	{
		int weight;
		int value;

		Pair(int weight , int value)
		{
			this.weight = weight;
			this.value = value;
		}

		public int compareTo(Pair o)
		{
			return this.value - o.value;
		}
	}








	/*public static void getMaxValue(int n , int[] val , int[] wt , int max_wt)
	{
		int[][] res = new int[n + 1][max_wt + 1];

		for(int i = 0 ; i <= n ; i++)
		{
			for(int j = 0 ; j <= max_wt ; j++)
			{
				if(i == 0 || j == 0)
				{
					res[i][j] = 0;
				}
				else
				{
					if( j - wt[i-1] >= 0  &&  res[i-1][j] < (res[i-1][j-wt[i-1]] + val[i-1]) ) 
					{
						res[i][j] = res[i-1][j-wt[i-1]] + val[i-1];		
					}
					else
					{
						res[i][j] = res[i-1][j];	
					}
				}
			}			
		}

		for(int[] arr2 : res)
		{
			System.out.println(Arrays.toString(arr2)); 
		}
		

		String path = "";
		for(int i = n , j = max_wt ; res[i][j] > 0 ; )
		{

			if(res[i-1][j] < res[i][j])
			{
				path =  wt[i-1] + " " + path;
				j = j - wt[i-1];
				i = i - 1;
			}
			else
			{
				i = i - 1;
			}
		}
		
		System.out.println("Items with following weight should be taken"); 
		System.out.println(path); 



	}*/ 


}
