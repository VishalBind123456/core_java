package Dynamic_programming;
import java.util.*;
public class Egg_Dropping_Problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int eggs = 3 , floors = 7;
		solution(eggs , floors);

	}

	public static void solution(int eggs , int floors)
	{
		int[][] dp = new int[eggs+1][floors+1];

		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[i].length ; j++)
			{
				if(i == 0)
				{
					dp[i][j] = 0;	//----> here should be null ----
				}
				else if(j == 0)
				{
					dp[i][j] = 0;
				}
				else if(i == 1)
				{
					dp[i][j] = j;
				}
				else if(j == 1)
				{
					dp[i][j] = 1;
				}
				else
				{
					int min = Integer.MAX_VALUE;
					for(int k = j-1 ; k >= 0 ; k--)
					{
						int val = Math.max(dp[i][k] , dp[i-1][j-k-1]);
						min = (val < min) ? val : min ;
					}
					dp[i][j] = min+1;
				}


			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));

	} 

}
