package Dynamic_programming;

import java.util.*;

public class print_stairs {

	public static void main(String[] args)
	{
		int[] arr = {2,4,1,0,2,3};
		getPaths(arr);



	}
	public static ArrayList<String> getPaths(int[] arr)
	{
		ArrayList<String>[] arr_al = new ArrayList[arr.length + 1];
		for(int i = 0 ; i < arr_al.length ; i++)
		{
			arr_al[i] = new ArrayList<>();
		}
		arr_al[6].add("");

		for(int i = arr.length - 1 ; i >= 0 ; i--)
		{
			for(int j = 1 ; j <= arr[i] ; j++)
			{
				if(i+j < arr_al.length)
				{
					for(String s : arr_al[i + j])
					{
						arr_al[i].add(j + s);
					}
				}
			}
		}

		for(int i = 0 ; i < arr_al.length ; i++)
		{
			System.out.println(arr_al[i]);
		}

		int min_moves = Integer.MAX_VALUE;
		for(String s : arr_al[0])
		{
			if(s.length() < min_moves)
				min_moves = s.length();
		}
		System.out.println(min_moves);

		return arr_al[0];

	}


	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int n = 13;
		int[] arr = {5 , 5 , 2 , 4 , 1  , 5  , 9  , 8 , 6 , 3 , 8 , 9 , 1};
		
		// int n = 3;
		// int[] arr = {2 , 2 , 3};
		
		System.out.println(  printCount(n , arr)  );
		
//		for(ArrayList<String> al : printPaths(n , arr) )
//		{
//			System.out.println(Arrays.toString(  al.toArray(new String[al.size()])  ));
//		}

		ArrayList<String>[] arr_al =  printPaths(n , arr);
		for(String s : arr_al[0])
		{

			System.out.println(s);
		}
	}
	
	public static int printCount(int n , int[] arr)
	{
		int[] dp = new int[n+1];			//storage and assign meaning 
		dp[n] = 1;							//identify small problem and direction to solve
		
		for(int i = n-1 ; i >= 0 ; i-- )    //travell and solve
		{
			//Integer  min =  Integer.MAX_VALUE;
			for(int j = 1 ; j <= arr[i] && i+j <= n ; j++)
			{
				// if(min > dp[i+j]);
				// {
				// 	min = 1 + dp[i+j];
				// }
				dp[i] = dp[i] + dp[i+j];								
			}
			//dp[i] = min;
		}
		return dp[0];
	}
	
	//public static void printPaths(int n , int[] arr)
	public static ArrayList<String>[] printPaths(int n , int[] arr)
	{
		ArrayList<String>[] arr_al = new ArrayList[n+1];  //storage and assign meaning 
		
		arr_al[n] = new ArrayList<String>();
		arr_al[n].add("");
		
		for(int i = n-1 ; i >= 0 ; i-- )
		{
			arr_al[i] = new ArrayList<String>();

			for(int j = 1 ; j <= arr[i] && i + j <= n ; j++ )
			{
				Integer  min =  Integer.MAX_VALUE;
				for(String s : arr_al[i+j])
				{
					if(s.length() < min)
					{
						min = s.length();
					}
				}

				for(String s : arr_al[i+j])
				{
					if(s.length() == min)
					{
						arr_al[i].add(j + s);
					}
				}
			}
		}
		return arr_al;
	}*/


}
