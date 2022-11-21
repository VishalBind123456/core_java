package Recursion;

import java.util.*;

public class knignt_tour {

	static int mmm = 1;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int row = 2 , col = 3 , moves = 0 ;
		String[][] chess = {
			{"0" , "0" , "0", "0", "0", "0" },
			{"0" , "0" , "0", "0", "0", "0" },
			{"0" , "0" , "0", "0", "0", "0" },
			{"0" , "0" , "0", "0", "0", "0" },
			{"0" , "0" , "0", "0", "0", "0" },
			
		};
		getSolution(chess , row , col , moves , chess.length*chess[0].length - 1 , "").stream().forEach(element -> { System.out.println(element); });

	}

	public static ArrayList<String> getSolution(String[][] chess , int row , int col , int moves , int target , String ans)
	{
		ans = ans + "r" + (row+1) + "-" + "c" + (col+1) + " ";


		ArrayList<String> res = new ArrayList<String>();

		if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] == "1")
		{
			return res;
		}

		if(moves == target)
		{
			System.out.println(ans);
			System.out.println(moves);
			System.out.println(mmm);
			mmm++;

			res.add(ans);
			return res;
		}


		chess[row][col] = "1";

		res.addAll( getSolution(chess , row - 2 , col + 1 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row - 1 , col + 2 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row + 1 , col + 2 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row + 2 , col + 1 , moves + 1 , target , ans) );

		res.addAll( getSolution(chess , row + 2 , col - 1 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row + 1 , col - 2 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row - 1 , col - 2 , moves + 1 , target , ans) );
		res.addAll( getSolution(chess , row - 2 , col - 1 , moves + 1 , target , ans) );

		chess[row][col] = "0";

		return res;
	}

}


