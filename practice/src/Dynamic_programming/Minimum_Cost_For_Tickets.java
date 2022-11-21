package Dynamic_programming;

public class Minimum_Cost_For_Tickets {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] days = {2,3,8,9,10,11,12,14,27};
		int[] cost = {1,5,25};
		int[] jump = {1,7,30};

		int[] dp = new int[days.length+1];

		long start  = System.nanoTime();
		int min = getMinCost(days , 0 , cost , jump , dp);
		long end  = System.nanoTime();
		System.out.println((end-start)/1000 + " <----milli sec ");

		System.out.println(min);

	}

	public static int getMinCost(int[] days , int day_idx , int[] cost , int[] jump , int[] dp)
	{
		if(day_idx == -1)
			return 0;

		if(dp[day_idx] != 0)
			return dp[day_idx];

		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < cost.length ; i++)
		{
			int x = -1;
			for(int j = 0 ; j < days.length ; j++)
			{
				if(days[day_idx]+jump[i]-1 < days[j])
				{
					x = j;
					break;
				}
			}

			int val = cost[i] +  getMinCost(days , x , cost , jump , dp);
			if(val < min)
				min = val;
		}

		dp[day_idx] = min;
		return min;
	} 

}
