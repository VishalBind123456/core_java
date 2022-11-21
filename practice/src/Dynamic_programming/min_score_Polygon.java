package Dynamic_programming;
import java.util.*;
public class min_score_Polygon {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,4};
		printlnMinScore(arr);

	}

	public static void printlnMinScore(int[] arr)
	{
		int[][] dp = new int[arr.length][arr.length];
		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp.length ; j++,i++)
			{
				if(gap == 0 || gap == 1)
				{
					dp[i][j] = 0;
				}
				else if(gap == 2)
				{
					dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
				}
				else  
				{
					int min = Integer.MAX_VALUE;
					for(int k = i+1 ; k < j ; k++)
					{
						int lv = dp[i][k];
						int rv = dp[k][j];
						int curr_tri = arr[i] * arr[j] * arr[k];

						int total = lv + rv + curr_tri;
						if(total < min)
							min = total;
					}
					dp[i][j] = min;
				}
			}
		}
		
		System.out.println(dp[0][dp.length-1]);

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));


	} 

}
