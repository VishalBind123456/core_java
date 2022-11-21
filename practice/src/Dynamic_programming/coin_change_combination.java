package Dynamic_programming;

import java.util.*;

public class coin_change_combination {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] coins = { 1,2,3,4,5 };
		int target = 7;

		getCombination(coins , target);

	}

	public static void getCombination(int[] coins , int target)
	{
		int[] res_arr = new int[target+1];
		ArrayList<String>[] res_path = new ArrayList[target+1];

		for(int i = 0 ; i <= target ; i++)
		{
			res_arr[i] = 0;
			res_path[i] = new ArrayList<String>();
		}

		res_path[0].add("");
		res_arr[0] = 1;

		for(int j = 0 ; j < coins.length ; j++)	
		{
			for(int i = coins[j] ; i <= target ; i++)
			{
				res_arr[i] = res_arr[i] + res_arr[i-coins[j]];

				if(res_arr[i-coins[j]] != 0)
				{
					for(String s : res_path[i-coins[j]])
					{
						res_path[i].add(s + " " + coins[j]);	
					}

				}
			}		
		}

		System.out.println(Arrays.toString(res_arr));
		for(ArrayList<String> arr_ls : res_path )
		{
			System.out.println(Arrays.toString(arr_ls.toArray()));
		}


	}

}
