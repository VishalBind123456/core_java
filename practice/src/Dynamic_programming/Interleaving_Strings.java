package Dynamic_programming;
import java.util.*;
public class Interleaving_Strings {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String s1 = "aabcc"; 
		String s2 = "dbbca"; 
		String ques = "aadbbcbcac";

		recursive(s1 , s2 , ques);
		tabulation(s1 , s2 , ques);

	}

	public static void tabulation(String s1 , String s2 , String ques)
	{
		int[][] dp = new int[s1.length()+1][s2.length()+1];

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
					if(s2.charAt(j-1) == ques.charAt(i+j-1))
						dp[i][j] = dp[i][j-1];
					else
						dp[i][j] = 0;
				}
				else if(j == 0)
				{
					if(s1.charAt(i-1) == ques.charAt(i+j-1))
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = 0;
				}
				else
				{
					if(s1.charAt(i-1) == ques.charAt(i+j-1))
						dp[i][j] = dp[i-1][j];
					else if(s2.charAt(j-1) == ques.charAt(i+j-1))
						dp[i][j] = dp[i][j-1];
				}

			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));

	}

	public static void recursive(String s1 , String s2 , String ques)
	{
		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(0,0,0));

		boolean ans = false;

		outerLoop:
		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();

			if(s1.length() + s2.length() != ques.length())
				break;

			while(true)
			{
				if(p.s1_idx < s1.length() && p.s2_idx < s2.length() && ques.charAt(p.ques_idx) == s1.charAt(p.s1_idx) && ques.charAt(p.ques_idx) == s2.charAt(p.s2_idx))
				{
					dq.add(new Pair(p.s1_idx+1, p.s2_idx, p.ques_idx+1));
					dq.add(new Pair(p.s1_idx, p.s2_idx+1, p.ques_idx+1));
					break;
				}
				else if(p.s1_idx < s1.length() && ques.charAt(p.ques_idx) == s1.charAt(p.s1_idx))
				{
					p.s1_idx++;
					p.ques_idx++;
				}
				else if(p.s2_idx < s2.length() && ques.charAt(p.ques_idx) == s2.charAt(p.s2_idx))
				{
					p.s2_idx++;
					p.ques_idx++;
				}
				else
				{
					break;
				}

				if(p.ques_idx == ques.length())
				{
					ans = true;
					break outerLoop;
				}
			
			}
		}

		System.out.println(ans);


	} 

	public static class Pair
	{
		int s1_idx;
		int s2_idx;
		int ques_idx;
		Pair(int s1_idx, int s2_idx, int ques_idx)
		{
			this.s1_idx =   s1_idx;
			this.s2_idx =   s2_idx;
			this.ques_idx = ques_idx;
		}
	}

}
