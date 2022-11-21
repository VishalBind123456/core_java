package Dynamic_programming;

import java.util.*;

public class unbound_knapsack_problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] val = {15 , 14 , 10 , 45 ,30};
		int[] wt = {2 , 5 , 1 , 3 , 4};
		int n = 5 , max_wt = 7;
		// getMaxValue(n , val ,  wt , max_wt);
		getMaxValue_2(n , val ,  wt , max_wt);
	}

	public static void getMaxValue_2(int n , int[] val , int[] wt , int max_wt)
	{
		int[] res = new int[max_wt + 1];
		String[] res_path = new String[max_wt + 1];
		for(int i = 0 ; i <= max_wt ; i++)
		{
			res[i] = 0;
			res_path[i] = "-";
		}
		for(int i = 1 ; i <= max_wt ; i++)
		{
			for(int j = 0 ; j < val.length ; j++)
			{
				if(wt[j] == i && val[j] > res[i])
				{
					res[i] = val[j];
					res_path[i] = wt[j] + "";
				}
				else if(wt[j] > i)
				{
					//----
				}
				else if(wt[j] < i)
				{
					int x = val[j] + res[i-wt[j]];
					if(x > res[i])
					{
						res[i] = x;
						res_path[i] = res_path[i-wt[j]] + "-" + wt[j];

					}
				}

			}

		}


		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(res_path));


	} 







































	/*public static void getMaxValue(int n , int[] val , int[] wt , int max_wt)
	{
		int[] res = new int[max_wt + 1];
		ArrayList<Integer>[] res_path = new ArrayList[max_wt + 1];

		for(int i = 0 ; i <= max_wt ; i++)
		{
			res_path[i] = new ArrayList<Integer>();
			res[i] = 0;
		}

		for(int j = 0 ; j <= max_wt ; j++)
		{

			for(int i = 1 ; i <= n ; i++ )
			{
				if( j - wt[i-1] >= 0 ) 
				{
					if(res[j] < res[j-wt[i-1]] + val[i-1])
					{
						res[j] = res[j-wt[i-1]] + val[i-1];

						res_path[j].clear();
						res_path[j].addAll(res_path[j-wt[i-1]]);
						res_path[j].add(wt[i-1]);

					}
				}
			}			
		}

		System.out.println(Arrays.toString(res));
		for(ArrayList<Integer> arr_ls : res_path)
		{
			System.out.println(arr_ls);

		} 
		
	}*/


}
