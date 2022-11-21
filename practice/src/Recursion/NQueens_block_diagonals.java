package Recursion;

import java.util.*;

public class NQueens_block_diagonals {

	public static boolean[][] board = null; 
	public static boolean[] column = null; 
	public static boolean[] diagonal1 = null; 
	public static boolean[] diagonal2 = null; 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int n = 4;
		board = new boolean[n][n];
		column = new boolean[n];
		diagonal1 = new boolean[2*n-1];
		diagonal2 = new boolean[2*n-1];
		long start = System.nanoTime();
		printNQueens(0);
		long end = System.nanoTime();
		System.out.println(end - start);


	}

	public static void printNQueens(int row)
	{
		if(row == board.length)
		{
			for(boolean[] b : board)
			{
				System.out.println(Arrays.toString(b));
			}
			System.out.println("");
			return;
		}

		for(int j = 0 ; j < board[0].length ; j++)
		{
			if(columnCheck(j) && diagonal1Check(row , j) && diagonal2Check(row , j))
			{
				board[row][j] = true;
				column[j] = true;
				diagonal1[row + j] = true;
				diagonal2[row - j + board.length - 1] = true;
				printNQueens(row + 1);
				column[j] = false;
				diagonal1[row + j] = false;
				diagonal2[row - j + board.length - 1] = false;
				board[row][j] = false;

			}

		}

		return;
	}

	public static boolean columnCheck(int col)
	{
		if(column[col] == true)
		{
			return false;
		}
		return true;
	}

	public static boolean diagonal1Check(int row , int col)
	{
		if(diagonal1[row + col] == true)
		{
			return false;
		}
		return true;

	}

	public static boolean diagonal2Check(int row , int col)
	{
		if(diagonal2[row - col + board.length - 1] == true)
		{
			return false;
		}
		return true;
	}



}
