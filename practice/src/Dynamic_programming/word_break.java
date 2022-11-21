package Dynamic_programming;
import java.util.*;
public class word_break {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] arr = {"loves","pep","coding","pepcoding","man","mango","go","ice","cream","icecream"};
		get_no_of_sentences(arr);
		get_no_of_sentences_DP(arr);
	}
	
	public static void get_no_of_sentences_DP(String[] arr)
	{
		HashSet<String> set = new HashSet<String>(Arrays.asList(arr));
		String sentence  = "lovespepcodingmangoicecream";

		int[] dp = new int[sentence.length()+1];
		dp[0] = 1;

		int j = 0;
		for(int i = 1 ; i < dp.length ; i++)
		{
			if(set.contains(sentence.substring(j,i)))
			{
				for(int k = j ; k >= 0 ; k--)
				{
					if(set.contains(sentence.substring(k,i)))
					{
						dp[i] += dp[k];
					}
				}
				j = i;
			}
		}

		System.out.println(Arrays.toString(dp));

	}


	public static void get_no_of_sentences(String[] arr)
	{
		HashSet<String> set = new HashSet<String>(Arrays.asList(arr));
		String sentence  = "lovespepcodingmangoicecream";
		int[][] dp = new int[sentence.length()][sentence.length()];

		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(0));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();

			if(p.idx >= sentence.length())
			{
				System.out.println(p.al);
				continue;
			}

			for(int i = p.idx ; i <= sentence.length() ; i++)
			{
				String str = sentence.substring(p.idx,i);
				if(set.contains(str))
				{
					Pair temp = new Pair(i);
					temp.al.addAll(p.al);
					temp.al.add(str);
					dq.addLast(temp);
				}
			}

		}
		
		// System.out.println(sentence);
	} 

	public static class Pair
	{
		int idx;
		ArrayList<String> al = new ArrayList<String>();
		Pair(int idx)
		{
			this.idx = idx;
		}
	}

}
