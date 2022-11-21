package Dynamic_programming;
import java.util.*;
public class regular_expression_matching {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "mississippi";
		String pattern = "mis*i.*p*i";

		printMatching(str , pattern);

	}

	public static void printMatching(String str , String pattern)
	{
		int[][] dp = new int[pattern.length()+1][str.length()+1];

		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[i].length ; j++)
			{
				if(i == 0 && j == 0)
				{
					dp[i][j] = 1;
				}
				else if(i == 0)
				{
					dp[i][j] = 0;
				}
				else if(j == 0)
				{
					if(pattern.charAt(i-1) == '*')
						dp[i][j] = dp[i-2][j];
					else
						dp[i][j] = 0;
				}
				else
				{
					if(pattern.charAt(i-1) == str.charAt(j-1))
					{
						dp[i][j] = dp[i-1][j-1];
					}
					else if(pattern.charAt(i-1) == '.')
					{
						dp[i][j] = dp[i-1][j-1];
					}
					else if(pattern.charAt(i-1) == '*')	
					{
						dp[i][j] = dp[i-2][j];	
						if(pattern.charAt(i-2) == '.' || pattern.charAt(i-2) == str.charAt(j-1))
							dp[i][j] = dp[i-2][j] | dp[i][j-1];	
					}						 
					else  
					{
						dp[i][j] = 0;
					}

				}
			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));

	} 

}
