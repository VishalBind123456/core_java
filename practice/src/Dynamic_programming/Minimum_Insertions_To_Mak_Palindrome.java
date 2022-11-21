package Dynamic_programming;
import java.util.*;
public class Minimum_Insertions_To_Mak_Palindrome {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// String str = "abbcabda";
		String str = "abkccbc";
		getMinInsertion(str);

		// String str = "abcd";
		// findAllSubsequences(str);

	}

	public static void getPalindromicSubsequence(String str)
	{
		int[][] dp = new int[str.length()][str.length()];
		for(int gap = 0 ; gap < dp.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp.length ; j++, i++)
			{
				if(gap == 0)
				{
					dp[i][j] = 1;
				}
				else if(gap == 1)
				{
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = 2;
					else
						dp[i][j] = 1;
				}
				else
				{
					if(str.charAt(i) == str.charAt(j))
					{
						dp[i][j] = dp[i+1][j-1] + 2;
					}
					else
					{
						dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
					}
				}

			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));
	}

	public static void getMinInsertion(String str)
	{

		getPalindromicSubsequence(str);

		StringBuilder sb = new StringBuilder("");

	} 

	public static void findAllSubsequences(String str)
	{
		ArrayList<String> al_1 = new ArrayList<String>();
		ArrayList<String> al_2 = new ArrayList<String>();

		if(str.length()%2 == 0)
		{
			int i = str.length()/2 - 1;
			int j = str.length()/2;
			al_1.add("");
			for(int left = i, right = j ; left >= 0 ; left--, right++)
			{
				for(String s : al_1)
				{
					al_2.add(s);
					al_2.add(str.charAt(left) + s);
					al_2.add(s + str.charAt(right));
					al_2.add(str.charAt(left) + s + str.charAt(right));
				}
				al_1 = al_2;
				al_2 = new ArrayList<String>();
			}
		}
		else  
		{
			int i = str.length()/2;
			int j = str.length()/2;

			al_1.add("");
			al_1.add(str.charAt(i)+"");

			for(int left = i-1, right = j+1 ; left >= 0 ; left--, right++)
			{
				for(String s : al_1)
				{
					al_2.add(s);
					al_2.add(str.charAt(left) + s);
					al_2.add(s + str.charAt(right));
					al_2.add(str.charAt(left) + s + str.charAt(right));
				}
				al_1 = al_2;
				al_2 = new ArrayList<String>();
			}
		}

		System.out.println(al_1);
	}

}

