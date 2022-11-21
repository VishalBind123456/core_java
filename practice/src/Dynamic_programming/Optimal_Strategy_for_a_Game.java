package Dynamic_programming;
import java.util.*;
public class Optimal_Strategy_for_a_Game {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {20,30,2,10};
		solution(arr);

	}

	public static void solution(int[] arr)
	{
		int[][] dp = new int[arr.length][arr.length];

		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0 , j = gap ; j < dp.length ; j++ , i++)
			{
				if(i == j)
				{
					dp[i][j] = arr[i];
				}
				else if(gap == 1)  
				{
					dp[i][j] = Math.max(arr[i] , arr[j]);
				}
				else
				{
					int right = Math.min(dp[i+2][j] , dp[i+1][j-1]) + arr[i];
					int left = Math.min(dp[i+1][j-1] , dp[i][j-2]) + arr[j];

					if(right > left)
					{
						dp[i][j] = right;
					}
					else
					{
						dp[i][j] = left;
					}

				}

			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));



	} 

}
