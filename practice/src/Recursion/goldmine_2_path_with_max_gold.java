package Recursion;

import java.util.*;

public class goldmine_2_path_with_max_gold {
	
	public static int sum_curr = 0;
	public static int sum_prev = 0;
	public static ArrayList<Integer> bag_curr = null;
	public static ArrayList<Integer> bag_prev = null;
	public static boolean[][] visited = {
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false},
	};

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] board = {
			{10,0,100,200,0,8,0},
			{20,0,0,0,0,6,0},
			{30,0,0,9,12,3,4},
			{40,0,2,5,8,3,11},
			{0,0,0,0,0,9,0},
			{5,6,7,0,7,4,2},
			{8,9,10,0,1,10,8},
		};

		bag_prev = new ArrayList<Integer>();
		bag_curr = new ArrayList<Integer>();

		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board[i].length ; j++)
			{
				sum_prev = 0;
				getMaxGoldPath(board , i , j);
				// System.out.println(sum_prev);	//------------------------------
				if(sum_prev > sum_curr)
				{
					sum_curr = sum_prev;
					bag_curr = bag_prev;
					bag_prev = new ArrayList<>();
				}

			}

		}

		System.out.println(sum_curr);
		System.out.println(bag_curr);

	}

	public static void getMaxGoldPath(int[][] board, int i, int j)
	{
		if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] == true || board[i][j] == 0)
		{
			return ;
		}

		visited[i][j] = true;
		bag_prev.add(board[i][j]);
		sum_prev += board[i][j];

		getMaxGoldPath(board , i-1 , j);
		getMaxGoldPath(board , i , j+1);
		getMaxGoldPath(board , i+1 , j);
		getMaxGoldPath(board , i , j-1);


	} 

}
