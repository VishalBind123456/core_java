package Dynamic_programming;
import java.util.*;
public class find_water_in_glass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k = 7;
		int row = 3;
		int col = 1;

		findWater(k , row , col);
	}

	public static void findWater(int k , int row , int col)
	{
		double[][] dp = new double[row+1][row+1];

		dp[0][0] = k;
		for(int i = 0 ; i < dp.length-1 ; i++)
		{
			for(int j = 0 ; j <= i ; j++)
			{
				if(dp[i][j] >= 1)
				{
					double spare = dp[i][j] - 1;
					dp[i][j] = 1;
					dp[i+1][j] += spare/2;
					dp[i+1][j+1] += spare/2;
				}
			}
		}

		for(double[] ar : dp)
			System.out.println(Arrays.toString(ar));

	} 

}
