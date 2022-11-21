package Dynamic_programming;
import java.util.*;
public class Max_Profit_k_transaction_allowed {

	public final int num1;
	public static final int num2;

	{
		num1 = 100;
	}

	static 
	{
		num2 = 200;
	}

	public void printSomeNumber()
	{
		System.out.println(num1);
		System.out.println(num2);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {9,6,7,6,3,8};
		int k = 3;


		Max_Profit_k_transaction_allowed obj = new 	Max_Profit_k_transaction_allowed();
		obj.printSomeNumber();	
		obj.printMaxProfit(arr , k);	


	}

	public static void printMaxProfit(int[] arr , int k)
	{
		int[][] board = new int[k+1][arr.length];
		String[][] board_path = new String[k+1][arr.length];

		for(int i = 0 ; i < board.length ; i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j = 0 ; j < board[i].length ; j++)
			{
				if(i == 0 && j == 0)
				{
					board[i][j] = 0;
					board_path[i][j] = "";
				}
				else if(j == 0)
				{
					board[i][j] = 0;
					board_path[i][j] = "";
					for(int y = 0 ; y <= i ; y++)
						board_path[i][j] += "b0s0" + " ";
				}
				else if(i == 0)
				{
					board[i][j] = 0;
					board_path[i][j] = "";
				}
				else
				{
					board[i][j] = board[i][j-1];
					board_path[i][j] = board_path[i][j-1];
					int x = j-1;
					if(board[i-1][x] - arr[x] > max)
					{
						max = board[i-1][x] - arr[x];
						if(max + arr[j] > board[i][j-1])
						{
							board[i][j] = board[i-1][x] + (arr[j] - arr[x]);
							board_path[i][j] = board_path[i-1][x] + "b" + x + "s" + j + " ";

						}

					}

					/*for(int x = j-1 ; x >= 0 ; x--)
					{
						if(board[i-1][x] + arr[j] - arr[x] > board[i][j])
						{
							board[i][j] = board[i-1][x] + (arr[j] - arr[x]);
							board_path[i][j] = board_path[i-1][x] + "b" + x + "s" + j + " ";

						}
					}*/

				}

			}

		}

		for(String[] ar : board_path)
			System.out.println(Arrays.toString(ar));

		for(int[] ar : board)
			System.out.println(Arrays.toString(ar));

	
	} 


}
