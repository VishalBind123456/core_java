package Dynamic_programming;
import java.util.*;
public class Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int key_press = 3;
		printMaxCombinations(key_press);
	}

	public static void printMaxCombinations(int k)
	{
		List<Integer>[] data = new List[10];
		for(int i = 0 ; i < data.length ; i++)
			data[i] = new ArrayList<Integer>();

		data[0] = Arrays.asList(new Integer[]{0,8});
		data[9] = Arrays.asList(new Integer[]{9,8,6});
		data[8] = Arrays.asList(new Integer[]{8,7,9,0,5});
		data[7] = Arrays.asList(new Integer[]{7,8,4});
		data[6] = Arrays.asList(new Integer[]{6,3,9,5});
		data[5] = Arrays.asList(new Integer[]{5,2,4,6,8});
		data[4] = Arrays.asList(new Integer[]{4,1,7,5});
		data[3] = Arrays.asList(new Integer[]{3,2,6});
		data[2] = Arrays.asList(new Integer[]{2,1,3,5});
		data[1] = Arrays.asList(new Integer[]{1,2,4});

		// for(List<Integer> al : data)
		// 	System.out.println(al);

		int[][] dp = new int[k+1][10];
		
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[i].length ; j++)
			{
				if(i == 0 || i == 1)
				{
					dp[i][j] = i;	
				}
				else
				{
					int val = 0;
					for(int x : data[j])
						val += dp[i-1][x];
					dp[i][j] = val;
				}

			}
		}

		for(int[] ar : dp)
			System.out.println(Arrays.toString(ar));


	} 

}
