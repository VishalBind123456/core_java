package Dynamic_programming;

import java.util.*;

public class coin_change_permutation {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int[] coins = { 2,3,5,6 };
		int target = 10;

		// getPermutation_2(coins , target);

		getPermutation_2(coins , target);

	}

	public static void getPermutation_2(int[] coins , int target)
	{
		ArrayList<String>[] arr_al= new ArrayList[target + 1];
		int[] count = new int[target + 1];
		for(int i = 0 ; i < arr_al.length ; i++)
		{
			arr_al[i] = new ArrayList<String>();
			count[i] = 0;
		}

		for(int j = 1 ; j <= target ; j++)
		{
			for(int i = 0 ; i < coins.length ; i++)
			{
				if(j-coins[i] < 0)
				{
					 
				}
				if(j-coins[i] == 0)
				{
					arr_al[j].add(coins[i] + " ");
					count[j]++;
				}
				if(j-coins[i] > 0)
				{
					for(String s : arr_al[j-coins[i]])
					{
						arr_al[j].add(s + coins[i] + " ");
					}

					for(int x = count[j-coins[i]] ; x > 0 ; x--)
					{
						count[j]++;
					}

				}

			}
		}

		System.out.println(arr_al[target]);
		System.out.println(arr_al[target].size());
		System.out.println(count[target]);


	} 













































































	/*public static void getPermutation(int[] coins , int target)
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

		for(int i = 1 ; i <= target ; i++ )
		{
			for(int idx = 0  ; idx < coins.length ; idx++)
			{
				if(i - coins[idx] >= 0)
				{
					res_arr[i] = res_arr[i] + res_arr[i - coins[idx]];

					if(res_arr[i - coins[idx]] != 0)
					{
						for(String s : res_path[i - coins[idx]])
						{
							res_path[i].add(s + " " + coins[idx]);
						}
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
	*/
}
