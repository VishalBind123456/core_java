package Dynamic_programming;
import java.util.*;
public class Longest_Increasing_Subsequence {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {10,22,9,33,21,50,41,60,80,3};
		printLongestIncreasingSS(arr);
	}

	public static void printLongestIncreasingSS(int[] arr)
	{
		int[] dp = new int[arr.length];
		String[] dp_path = new String[arr.length];

		int max_ss = 0;
		String max_path = "";
		int idx = 0;
		dp[0] = 1;
		dp_path[0] = arr[0] + " ";
		for(int i = 1 ; i < arr.length ; i++)
		{
			int max = Integer.MIN_VALUE;
			dp[i] = 1;
			dp_path[i] = arr[i] + " ";

			for(int j = i-1 ; j >= 0 ; j--)
			{
				if(arr[i] > arr[j])
				{
					if(dp[j] > max)
					{
						max = dp[j];
						dp[i] = max + 1;
						dp_path[i] = dp_path[j] + arr[i] + " ";

					}
					if(dp[i] > max_ss)
					{
						max_ss = dp[i];
						max_path = dp_path[i];
						idx = i;
					}

				}
			}
		}

		System.out.println(Arrays.toString(arr) + " <---- arr ");
		System.out.println(Arrays.toString(dp) + " <---- dp ");
		System.out.println(max_ss);
		System.out.println(max_path);

		ArrayDeque<Pair> dq = new  ArrayDeque<Pair>();
		for(int i = 1 ; i < arr.length ; i++)
			if(dp[i] == max_ss)
				dq.addLast(new Pair(i , arr[i] + " " , max_ss));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.curr_idx == 0)
			{
				System.out.println(p.psf + " <--- by reverse engg ");
				continue;
			}
			for(int j = p.curr_idx - 1 ; j >= 0 ; j--)
				if(dp[j] == p.curr_len-1)
					dq.addLast(new Pair(j , arr[j] + " " + p.psf , p.curr_len-1));
		}

	} 

	public static class Pair
	{
		int curr_idx;
		String psf;
		int curr_len;
		Pair(int curr_idx,String psf,int curr_len)
		{
			this.curr_idx = curr_idx;
			this.psf =      psf;
			this.curr_len =      curr_len;
		}

	}

}
