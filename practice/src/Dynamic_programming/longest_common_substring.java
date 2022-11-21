package Dynamic_programming;
import java.util.*;
public class longest_common_substring {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str1 = "xyzabcp";
		String str2 = "pqabcxy";
		printLCSS(str1 , str2);

		String str = "abcabc";
		printLRSS(str);

	}

	public static void printLRSS(String str)
	{
		int[][] dp = new int[str.length()+1][str.length()+1];

		for(int i = dp.length-1 ; i >= 0 ; i--)
		{
			for(int j = dp[i].length-1 ; j >= 0 ; j--)
			{
				if(i == dp.length-1 || j == dp[i].length-1)
				{
					dp[i][j] = 0;
				}
				else if(str.charAt(i) == str.charAt(j) && i != j)
				{
					dp[i][j] = dp[i+1][j+1] + 1;
				}
				else
				{
					dp[i][j] = Math.max(dp[i+1][j] , dp[i][j+1]);
				}
			}
		}

		for(int[] str_ar : dp)
			System.out.println(Arrays.toString(str_ar));

	}

	public static void printLCSS(String str1 , String str2)
	{
		String[][] dp = new String[str1.length()+1][str2.length()+1];

		int lcss = 0;
		String lcss_String = "";
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[i].length ; j++)
			{
				if(i == 0 || j == 0)
				{
					dp[i][j] = "";
				}
				else
				{
					dp[i][j] = (str1.charAt(i-1) == str2.charAt(j-1)) ? dp[i-1][j-1] + str1.charAt(i-1) : "";
					if(dp[i][j].length() > lcss)
					{
						lcss = dp[i][j].length();
						lcss_String = dp[i][j];
					}
				}
			}
		}

		for(String[] str : dp)
			System.out.println(Arrays.toString(str));

		System.out.println(lcss + "  " + lcss_String);

	} 

}
