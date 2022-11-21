package Dynamic_programming;
import java.util.*;
public class all_subsequences_bfs {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String str = "abc";

		printAllSubsequences(str);
		System.out.println();
		printAllPermutations(str);		

	}

	public static void printAllSubsequences(String str)
	{
		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(str , "" , 0));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.idx == p.ques.length())
			{
				System.out.println(p.asf);
				continue;
			}

			dq.addLast(new Pair(p.ques ,  p.asf , p.idx+1));
			dq.addLast(new Pair(p.ques ,  p.asf + p.ques.charAt(p.idx) , p.idx+1));

		}
	}

	public static class Pair
	{
		String ques;
		String asf;
		int idx;
		Pair(String ques , String asf , int idx)
		{
			this.ques = ques;
			this.asf = asf;
			this.idx = idx;
		}
	}

	public static void printAllPermutations(String str)
	{
		int n = str.length();
		int fact = 1;
		for(int i = 1 ; i <= n ; i++)
			fact *= i;
			
		// System.out.println(fact);

		for(int i = 0 ; i < fact ; i++)
		{
			StringBuilder sb = new StringBuilder(str);
			StringBuilder ans = new StringBuilder("");
			while(sb.length() > 0)
			{
				int x = i%(sb.length());
				ans.append(sb.charAt(x));
				sb.deleteCharAt(x);
			}
			System.out.println(ans.toString());
		}
	}

}
