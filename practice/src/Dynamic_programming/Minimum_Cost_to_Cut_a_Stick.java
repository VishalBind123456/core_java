package Dynamic_programming;
import java.util.*;
public class Minimum_Cost_to_Cut_a_Stick {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] cuts = {1,3,4,5};
		int n = 7;
		int[][] dp = new int[n+1][n+1];

		long start = System.nanoTime();
		int min = getMinCost(n , 0 , cuts.length-1 , cuts , dp);
		long end = System.nanoTime();

		System.out.println(min);
		System.out.println((end-start)/1000 + " <--- milli seconds ");
 
	}

	public static int getMinCost(int n , int si , int ei , int[] cuts , int[][] dp)
	{

		if(ei < si)
			return 0;

		if(dp[si][ei] != 0)
		{
			// System.out.println(dp[si][ei]);
			return dp[si][ei];
		}

		int ll = (si == 0) ? 0 : cuts[si-1];
		int rl = (ei == cuts.length-1) ? n : cuts[ei+1];
		int cost = rl - ll;
		
		if(si == ei)
			return cost;

		int min = Integer.MAX_VALUE;
		for(int i = si ; i <= ei ; i++)
		{


			int left =  getMinCost(n , si , i-1 , cuts , dp);
			int right = getMinCost(n , i+1 , ei , cuts , dp);

			int total =  left + right + cost;
			if(total < min)
				min = total;
		}

		dp[si][ei] = min;
		return min;

	} 

}
