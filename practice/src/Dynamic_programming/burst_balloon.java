package Dynamic_programming;

public class burst_balloon {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {5,2,4,9};
		// int[] arr = {2,3,1,5,6,4};
		printMaxScore(arr);

	}

	public static void printMaxScore(int[] arr)
	{
		int[][] dp = new int[arr.length][arr.length];

		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp.length ; j++, i++ )
			{
				int max = Integer.MIN_VALUE;
				for(int k = i ; k <= j ; k++)
				{
					int lv = (k == i) ? 0 : dp[i][k-1];
					int rv = (k == j) ? 0 : dp[k+1][j];
					int mv = arr[k];

					int left = (i == 0) ? 1 : arr[i-1]; 
					int right = (j == arr.length-1) ? 1 : arr[j+1];

					int total = left * mv * right; 
					total = total + lv + rv;
					if(total > max)
						max = total;
				}

				dp[i][j] = max;

			}
		}

		System.out.println(dp[0][dp.length-1]);

	} 

}

