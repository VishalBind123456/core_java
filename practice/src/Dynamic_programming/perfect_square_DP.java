package Dynamic_programming;
import java.util.*;
public class perfect_square_DP {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 11;
		printMinValue(n);

	}

	public static void printMinValue(int n)
	{
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j = i-1 ; j >= 0 ; j--)
			{
				if(i >= (int)Math.pow(j , 2))
				{
					if(dp[i - (int)Math.pow(j , 2)] + 1 < min)
					{
						min = dp[i - (int)Math.pow(j , 2)] + 1;	
						dp[i] = dp[i - (int)Math.pow(j , 2)] + 1;
					}
				}
			}

		}


		System.out.println(Arrays.toString(dp));


	} 

}
