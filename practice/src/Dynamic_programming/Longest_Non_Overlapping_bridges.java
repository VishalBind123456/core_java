package Dynamic_programming;
import java.util.*;
public class Longest_Non_Overlapping_bridges {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 10;
		int[] north = {10,2,8,17,21,50,41,60,80,1};
		int[] south = {20,7,15,3,40,4,57,80,90,30};

		// printMax(n , north , south);
		printMaxUsingLIS(n , north , south);

	}

	public static void printMaxUsingLIS(int n , int[] north , int[] south)
	{
		Pair2[] bridge = new Pair2[n];
		for(int i = 0 ; i < n ; i++)
			bridge[i] = new Pair2(north[i] , south[i]);

		System.out.println(Arrays.toString(bridge));

		Arrays.sort(bridge);
		System.out.println(Arrays.toString(bridge));
		int[] dp = new int[n];
		// int overall_max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++)
		{
			dp[i] = 1;
			int max = Integer.MIN_VALUE;
			for(int j = i-1 ; j >= 0 ; j--)
			{
				if(bridge[j].s < bridge[i].s)
				{
					if(dp[j] > max)
					{
						dp[i] = dp[j] + 1;
						max = dp[i];
						// overall_max = (overall_max < max) ? max : overall_max ;

					}
				}
			}
		}

		System.out.println(Arrays.toString(dp));



	}

	public static class Pair2 implements Comparable<Pair2>
	{
		int n;
		int s;
		Pair2(int n,int s)
		{
			this.n = n;
			this.s = s;
		}
		public int compareTo(Pair2 o)
		{
			return this.n - o.n;
		}
		public String toString()
		{
			return this.n + " " + this.s;
		}
	}

	public static void printMax(int n , int[] north , int[] south)
	{
		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		ArrayList<String> ss = new ArrayList<String>(); 

		String str = "";
		for(int i = 0 ; i < n ; i++)
			str += i;

		dq.addLast(new Pair(0 , str , ""));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.idx == str.length())
			{
				ss.add(p.psf);
				continue;
			}

			dq.addLast(new Pair(p.idx+1 , str , p.psf + str.charAt(p.idx)));
			dq.addLast(new Pair(p.idx+1 , str , p.psf));

		}

		ss.sort((s1 , s2) -> {
			int x = s2.length() - s1.length();
			return x;
		});
		System.out.println(ss);

		firstLoop:
		for(String s : ss)
		{
			boolean flag = true;
			secondLoop:
			for(int i = 0 ; i < s.length() ; i++)
			{
				for(int j = i+1 ; j < s.length() ; j++)
				{
					int x = (north[s.charAt(i)-'0'] - north[s.charAt(j)-'0']) * (south[s.charAt(i)-'0'] - south[s.charAt(j)-'0']);
					if(x < 0)
					{
						flag = false;
						break secondLoop;
					}
				}
			}
			if(flag)
			{
				System.out.println(s);
				break firstLoop;
			}

		}

	} 

	public static class Pair
	{
		int idx;
		String str;
		String psf;
		Pair(int idx,String str,String psf)
		{
			this.idx = idx;
			this.str = str;
			this.psf = psf;
		}
	}

}
