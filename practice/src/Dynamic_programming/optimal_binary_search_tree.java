package Dynamic_programming;
import java.util.*;
public class optimal_binary_search_tree {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	
		// int[] arr = {3,1,2,1};
		int[] arr = {34,8,50};
		printOptimalBST(arr);

	}

	public static void printOptimalBST(int[] arr)
	{
		int[][] dp = new int[arr.length][arr.length];

		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp.length ; j++,i++)
			{
				if(gap == 0)
				{
					dp[i][j] = arr[j];
				}
				else  
				{
					int min = Integer.MAX_VALUE;
					for(int k = i ; k <= j ; k++)
					{
						int lv = (k == i) ? 0 : dp[i][k-1];
						int rv = (k == j) ? 0 : dp[k+1][j];
						// int mv = arr[k];	//---> middle value , we will not add because it will get added in loop below ----

						int total = lv + rv;
						for(int x = i ; x <= j ; x++)	
							total += arr[x];

						if(total < min)
							min = total;
					}
					dp[i][j] = min;

				}

			}
		}

		for(int[] ar :dp)
			System.out.println(Arrays.toString(ar));

	} 

}
