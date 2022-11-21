package Recursion;

import java.util.*;

public class N_Queen_problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[][] chess = {
			{"0" , "0" , "0" , "0"},
			{"0" , "0" , "0" , "0"},
			{"0" , "0" , "0" , "0"},
			{"0" , "0" , "0" , "0"},
		};
		long start = System.nanoTime();
		getSolution(chess , 0 , 0 , "").stream().forEach(element -> { System.out.println(element); });
		long end = System.nanoTime();
		System.out.println(end - start);

	}

	public static ArrayList<String> getSolution(String[][] chess ,int row ,int col , String ans) 
	{
		ArrayList<String> arr_ls = new ArrayList<String>();	

		if(row == chess.length)
		{
			arr_ls.add(ans);
			return arr_ls;
		}

		for(int i = 0 ; i < chess[0].length ; i++)
		{
			if(isSafe(chess , row , i))
			{
				chess[row][i] = "1";
				arr_ls.addAll(getSolution(chess , row+1 , i , ans + "r" + row + "-" + "c" + i + " "));
				chess[row][i] = "0";
			}
		}

		return arr_ls;
	}

	public static boolean isSafe(String[][] chess , int row , int col)
	{
		for(int i = row-1 ; i >= 0 ; i--)
		{
			if(chess[i][col] == "1")
			{
				return false;
			}
		}

		for(int i = row-1 , j = col+1 ; i >= 0 && j < chess[0].length ; i-- , j++)
		{
			if(chess[i][j] == "1")
			{
				return false;
			}
		}

		for(int i = row-1 , j = col-1 ; i >= 0 && j >= 0 ; i-- , j--)
		{
			if(chess[i][j] == "1")
			{
				return false;
			}
		}

		return true;
	}

}
