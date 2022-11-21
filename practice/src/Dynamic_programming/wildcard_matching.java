package Dynamic_programming;
import java.util.*;
public class wildcard_matching {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "baaabab";
		String pattern = "ba*a?";	//----> here * means it can become anything and anyLength ----
		printMatching(str , pattern);
	}

	/*public static void printMatching(String str , String pattern)
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
					else if(pattern.charAt(i-1) == '?')
					{
						dp[i][j] = dp[i-1][j-1];
					}
					else if(pattern.charAt(i-1) == '*')	
					{
						dp[i][j] = dp[i-2][j];	
						if(pattern.charAt(i-2) == '?' || pattern.charAt(i-2) == str.charAt(j-1))
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

	}*/

	public static void printMatching(String str , String pattern)
	{
		int[][] dp = new int[pattern.length()+1][str.length()+1];
		for(int i = dp.length-1 ; i >= 0 ; i--)
		{
			for(int j = dp[i].length-1 ; j >= 0 ; j--)
			{
				if(i == dp.length-1 && j == dp[i].length-1)
				{
					dp[i][j] = 1;
				}
				else if(i == dp.length-1)
				{
					dp[i][j] = 0;
				}
				else if(j == dp[i].length-1)
				{
					if(pattern.charAt(i) == '*')
					{
						dp[i][j] = dp[i+1][j];
					}
					else
					{
						dp[i][j] = 0;
					}
				}
				else  
				{
					if(pattern.charAt(i) == str.charAt(j))
					{
						dp[i][j] = dp[i+1][j+1];
					}
					else if(pattern.charAt(i) == '?')
					{
						dp[i][j] = dp[i+1][j+1];
					}
					else if(pattern.charAt(i) == '*')
					{
						// dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);	//---->both are correct ----> n square complexity 
						for(int k = j ; k < dp[i+1].length ; k++)			//----> n cube complexity
							if(dp[i+1][k] == 1)
								dp[i][j] = 1;

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


