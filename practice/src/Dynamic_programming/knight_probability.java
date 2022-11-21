package Dynamic_programming;
import java.util.*;
public class knight_probability {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k = 2;
		int size = 5;

		printKnightProbability(size , k , 2 , 2);

	}

	public static void setProbability(double[][] dp , int row , int col , double curr_prob)
	{
		int[][] arr = {
			{-2,+1},
			{-1,+2},
			{+1,+2},
			{+2,+1},
			{+2,-1},
			{+1,-2},
			{-1,-2},
			{-2,-1},
		};

		for(int[] ar : arr)
		{
			int new_row = row+ar[0];
			int new_col = col+ar[1];
			if(new_row < 0 || new_col < 0 || new_row >= dp.length || new_col >= dp.length)
				continue;
			else  
				dp[new_row][new_col] += curr_prob * (double)1/8;
			
		}

	}

	public static void printKnightProbability(int size , int k , int row , int col)
	{
		double[][] dp_1 = new double[size][size];
		double[][] dp_2 = new double[size][size];

		dp_1[row][col] = 1;

		for(int moves = 0 ; moves < k ; moves++)
		{
			for(int i = 0 ; i < size ; i++)
			{
				for(int j = 0 ; j < size ; j++)
				{
					if(dp_1[i][j] != 0)
					{
						setProbability(dp_2 , i , j , dp_1[i][j]);
					}
				}
			}
			dp_1 = dp_2;
			dp_2 = new double[size][size];

			for(double[] ar : dp_1)
				System.out.println(Arrays.toString(ar));
			System.out.println();

		
		}

		double probability = 0;
		for(double[] ar : dp_1)
			probability += Arrays.stream(ar).sum();
		
		System.out.println(probability + " <---- probability of being inside the board ");

	} 

}
