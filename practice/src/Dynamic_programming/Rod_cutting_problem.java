package Dynamic_programming;
import java.util.*;
public class Rod_cutting_problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {0,1,5,8,9,10,17,17,20};
		printMax(arr);
	}

	public static void printMax(int[] arr)
	{
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[1];
		for(int i = 2 ; i < dp.length ; i++)
		{
			int max = arr[i];
			for(int j = i ; j > 0 ; j--)
			{
				int val = arr[i-j] + arr[j];
				if(val > max)
					max = val;
			}
			dp[i] = max;
		}

		System.out.println(Arrays.toString(dp));


	} 

}
