package Dynamic_programming;
import java.util.*;
public class Arithmetic_slices {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {2,5,9,12,15,18,22,26,30,34,36,38,40,41};
		get_no_of_AP(arr);
		int[] arr2 = {4,2,3,5,2,6,7,9,8,11};
		get_subsequence_AP(arr2);
	}

	public static void get_subsequence_AP(int[] arr)
	{
		HashMap<Integer , Integer>[] arr_map = new HashMap[arr.length];
		HashMap<Integer , String>[] str_map = new HashMap[arr.length];
		HashMap<Integer , ArrayList<String>> ans_map = new HashMap<Integer , ArrayList<String>>();

		for(int i = 0 ; i < arr_map.length ; i++)
		{
			arr_map[i] = new HashMap<Integer , Integer>();
			str_map[i] = new HashMap<Integer , String>();
		}

		for(int i = 1 ; i < arr.length ; i++)
		{
			for(int j = i-1 ; j >= 0 ; j--)
			{
				if(arr_map[j].containsKey(arr[i]-arr[j]))
				{
					arr_map[i].put(arr[i]-arr[j] , arr_map[j].get(arr[i]-arr[j]) + 1);
					str_map[i].put(arr[i]-arr[j] , str_map[j].get(arr[i]-arr[j]) + "-" + arr[i]);
					if(ans_map.containsKey(arr[i]-arr[j]))
					{
						ans_map.get(arr[i]-arr[j]).add(str_map[i].get(arr[i]-arr[j]));
					}
					else
					{
						ans_map.put(arr[i]-arr[j] , new ArrayList<String>());
						ans_map.get(arr[i]-arr[j]).add(str_map[i].get(arr[i]-arr[j]));
					}

				}	
				else if(arr_map[i].containsKey(arr[i]-arr[j]))
				{
					arr_map[i].put(arr[i]-arr[j] , arr_map[i].get(arr[i]-arr[j]) + 1);
				}	
				else
				{
					arr_map[i].put(arr[i]-arr[j] , 1);
					str_map[i].put(arr[i]-arr[j] , arr[j]+"-"+arr[i]);
				}		
			}
		}

		System.out.println("\n" + Arrays.toString(arr));
		System.out.println(Arrays.toString(arr_map));
		System.out.println(Arrays.toString(str_map));
		System.out.println(ans_map);

	}

	public static void get_no_of_AP(int[] arr)
	{
		int[] dp = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i < 2)
			{
				dp[i] = 0;
			}
			else
			{
				if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2])
					dp[i] = dp[i-1]+1;
				else
					dp[i] = 0;
			}  
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.stream(dp).sum());

	} 

}
