package Dynamic_programming;

import java.util.*;

public class goldmine_problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] arr = {
			{2 , 2 , 5 , 1 , 3},
			{4 , 7 , 1 , 9 , 6},
			{2 , 3 , 3 , 1 , 1},
			{3 , 4 , 6 , 5 , 2},
			{4 , 2 , 5 , 4 , 6},
		};

		getMaxGold(arr);


	}

	public static void getMaxGold(int[][] arr) 
	{
		int row = arr.length , col = arr[0].length;

		int[][] res = new int[row][col];
		String[][] res_path = new String[row][col];

		for(int i = 0 ; i < row ; i++)
		{
			res[i][col-1] = arr[i][col-1];
			res_path[i][col-1] = " ";
		}	

		for(int j = col-2 ; j >= 0 ; j--)
		{
			for(int i = row-1 ; i >= 0 ; i--)
			{
				int du = (i-1 < 0) ? Integer.MIN_VALUE : arr[i][j] + res[i-1][j+1];
				int rr = arr[i][j] + res[i][j+1];
				int dd = (i+1 >= row) ? Integer.MIN_VALUE : arr[i][j] + res[i+1][j+1];

				int max = Math.max(Math.max(du , rr) , dd);
				res[i][j] =  max;

				if(max == du){ res_path[i][j] = "du " + res_path[i-1][j+1];  }
				if(max == rr){ res_path[i][j] = "rr " + res_path[i][j+1];    }
				if(max == dd){ res_path[i][j] = "dd " + res_path[i+1][j+1];  }

			}	
				
		}

		for(int[] arr2 : res)
		{
			System.out.println(Arrays.toString(arr2));
		}
		
		System.out.println("\n Respective paths .... \n" );

		for(String[] arr3 : res_path)
		{
			System.out.println(Arrays.toString(arr3));
		}

	}

}
