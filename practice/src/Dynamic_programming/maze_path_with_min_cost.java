package Dynamic_programming;

import java.util.*;

public class maze_path_with_min_cost {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sr = 0 , sc = 0;
		int[][] cost_arr = {
			{0 , 1 , 5 , 6 },
			{6 , 1 , 6 , 4 },
			{8 , 1 , 1 , 1 },
			{2 , 7 , 4 , 1 },
		};

		for(int[] arr : getPath(cost_arr , sr , sc))
		{
			System.out.println(Arrays.toString(arr));

		}


	}

	public static int[][] getPath(int[][] cost_arr , int sr , int sc)
	{

		int row  = cost_arr.length , col  = cost_arr[0].length;
		int[][] res = new int[row][col];
		String[][] res_path = new String[row][col];

		res[row-1][col-1] = 0;
		res_path[row-1][col-1] = "";

		for(int i = row-1 ; i >= 0 ; i--)
		{
			for(int j = col-1 ; j >= 0 ; j--)
			{
				if(i == row-1 && j == col-1){ continue;	}
				int down = (i+1 >= row) ? Integer.MAX_VALUE : cost_arr[i+1][j] + res[i+1][j];
				int right = (j+1 >= col) ? Integer.MAX_VALUE : cost_arr[i][j+1] + res[i][j+1];
				res_path[i][j] = (right < down) ? "r"+res_path[i][j+1] : "d"+res_path[i+1][j];
				res[i][j] = Math.min(down , right);

				//int diagonal = (j+1 >= col || i+1 >= row) ? Integer.MAX_VALUE : cost_arr[i+1][j+1] + res[i+1][j+1];
				//res[i][j] = Math.min(Math.min(down , right) , diagonal);

			}
		} 
		
		for(String[] arr : res_path)
		{
			System.out.println(Arrays.toString(arr));
		}

		return res;

	}

}
