package Dynamic_programming;
import java.util.*;
public class highway_billboard {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] miles = {6,8,12,14,16};
		int[] cost = {5,8,5,3,1};
		int gap = 3;

		//printMaxCost(miles , cost , gap);

		printMaxRevenue(cost , miles , gap);

		printMaxRevenueLinear(cost , miles , gap);

	}

	public static void printMaxRevenue(int[] cost , int[] dist , int k)
	{
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		for(int i = 1 ; i < dp.length ; i++)
		{
			int max = cost[i];
			for(int j = i ; j >= 0 ; j--)
			{
				if(dist[i] - dist[j] > k)
				{
					int val = dp[j] + cost[i];
					if(val > max)
						max = val;
				}
			}
			dp[i] = max;

		}

		System.out.println(Arrays.toString(dp));

	} 

	public static void printMaxRevenueLinear(int[] cost , int[] dist , int k)
	{
		int[] dp = new int[dist[dist.length-1]+1];

		dp[0] = 0;
		int j = 0;
		for(int i = 1 ; i < dp.length ; i++)
		{
			if(i == dist[j])
			{
				dp[i] = (i-k > 0) ? Math.max(cost[j]+dp[i-k] , cost[j]) : cost[j] ;
				j++;
			}
			else
			{
				dp[i] = dp[i-1];
			}
		}
		
		System.out.println(Arrays.toString(dp));
	}

	/*public static void printMaxCost(int[] miles , int[] cost , int gap)
	{
		int[] profit = new int[cost.length]; 
		String[] path = new String[cost.length]; 

		for(int i = 0 ; i < cost.length ; i++)
		{
			profit[i] = cost[i];
			path[i] = miles[i] + "-" + cost[i];
			int max_profit = 0;
			String max_path = "";
			for(int j = i-1 ; j >= 0 ; j--)
			{
				if(miles[i] - miles[j] > gap)
				{
					if(max_profit < profit[j])
					{
						max_profit = profit[j];
						max_path = path[j] + " " ;
					}
				}
			}
			profit[i] = max_profit + profit[i];
			path[i] = max_path + path[i];

		}

		System.out.println(Arrays.toString(profit));
		System.out.println(Arrays.toString(path));

	}*/ 

}
