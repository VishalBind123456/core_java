package Dynamic_programming;
import java.util.*;
public class longest_common_subsequence {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str1 = "bcncb";
		String str2 = "abccncb";

		printlnlongestSubsequence(str1 , str2);

	}

	public static void printlnlongestSubsequence(String str1 , String str2)
	{
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i = dp.length-1 ; i >= 0 ; i--)
		{
			for(int j = dp[i].length-1 ; j >= 0 ; j--)
			{
				if(i == dp.length-1 || j == dp[0].length-1)
				{
					dp[i][j] = 0;
				}
				else
				{
					if(str1.charAt(i) == str2.charAt(j))
						dp[i][j] = dp[i+1][j+1] + 1;
					else
						dp[i][j] = Math.max(dp[i+1][j] , dp[i][j+1]);
				}

			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));

		StringBuilder ans = new StringBuilder("");
		for(int i = 0 ; i < dp.length-1 ; )
		{
			for(int j = 0 ; j < dp[i].length-1 ; )
			{
				if(str1.charAt(i) == str2.charAt(j))
				{
					ans.append(str1.charAt(i));
					System.out.println(ans.toString());
					i++; 
					j++;
				}
				else
				{
					if(dp[i][j+1] > dp[i+1][j])
						j++;
					else
						i++;
				}
			}
		}

		// System.out.println(ans.toString());

	} 


}
