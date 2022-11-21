package Dynamic_programming;
import java.util.*;
public class Min_Palindromic_cut {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "abccbc";
		printMinCutStratigy(str);

	}

	public static void printMinCutStratigy(String str)
	{
		boolean[][] dp = new boolean[str.length()][str.length()];
		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp.length ; j++,i++)
			{
				if(gap == 0)
				{
					dp[i][j] = true;
				}
				else if(gap == 1)
				{
					dp[i][j] = (str.charAt(i) == str.charAt(j)) ? true : false;
				}
				else  
				{
					dp[i][j] = (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) ? true : false;
				} 
			}
		}

		for(boolean[] barr : dp)
			System.out.println(Arrays.toString(barr));

		System.out.println(" gap stratigy method works in n cube ");	//------------------------------------------
		int[][] dp1 = new int[str.length()][str.length()];
		for(int gap = 0 ; gap < dp1.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp1.length ; j++,i++)
			{
				if(gap == 0)
				{
					dp1[i][j] = 0;
				}
				else if(gap == 1)
				{
					dp1[i][j] = (str.charAt(i) == str.charAt(j)) ? 0 : 1;
				}
				else  
				{
					if(dp[i][j])	//----> if whole substring is palindrome then 0 cuts else we will loop through the substring ----
					{
						dp1[i][j] = 0;
					}
					else
					{
						int min = Integer.MAX_VALUE;
						for(int k = i ; k < j ; k++)
						{
							int val = dp1[i][k] + dp1[k+1][j];
							if(val < min)
								min = val;
						}
						dp1[i][j] = min + 1;

					}
				} 
			}
		}

		for(int[] ar : dp1)
			System.out.println(Arrays.toString(ar));

		System.out.println(" prefix / suffix method works in n square ");	//------------------------------------------
		int[] dp2 = new int[dp.length];
		for(int i = 1 ; i < dp2.length ; i++)
		{
			dp2[0] = 0;
			int min = Integer.MAX_VALUE;
			for(int j = i ; j > 0 ; j--)
			{
				if(dp[j][i] == true)
				{
					int val = dp2[j-1] + 1;
					if(val < min)
						min = val;
				}
			}
			dp2[i] = min;

		}
		System.out.println(Arrays.toString(dp2));

	} 

}
