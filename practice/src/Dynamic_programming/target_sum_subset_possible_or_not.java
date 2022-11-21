package Dynamic_programming;

import java.util.*;

public class target_sum_subset_possible_or_not {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] collection = {1 , 4 , 3 , 2 , 7};
		int target = 10;

		// isSubsetPossible(collection , target);
		boolean[][] board = isSubsetPossible_2(collection , target);
		printAllCombinations(board , collection , board.length-1 , board[0].length-1 , "");
	}

	public static void printAllCombinations(boolean[][] board , int[] collection , int i , int j , String ans)
	{
		if(i < 0 || j < 0)
		{
			return ;
		}

		if( i == 0 && j == 0 )
		{
			System.out.println(ans);
			return ;
		}

		if(board[i-1][j] == true)
		{
			printAllCombinations(board , collection , i-1 , j , ans);		
		}
		if(board[i][j] == true)
		{
			printAllCombinations(board , collection , i-1 , j-collection[i-1] , ans + collection[i-1]);		
		}


	}

	public static boolean[][] isSubsetPossible_2(int[] collection , int target)	//-----> for practice only ------
	{
		boolean[][] board = new boolean[collection.length + 1][target + 1];

		for(int i = 0 ; i <= collection.length ; i++ )
		{
			for(int j = 0 ; j <= target ; j++ )
			{
				if(i == 0 && j == 0)
				{
					board[i][j] = true;
				}
				else if(i == 0)
				{
					board[i][j] = false;
				}
				else if(j == 0)
				{
					board[i][j] = true;
				}
				else 
				{
					if(j - collection[i-1] < 0)
					{
						board[i][j] = board[i-1][j];
					}
					else if(j - collection[i-1] == 0)
					{
						board[i][j] = true;
					}
					else if(board[i-1][j - collection[i-1]])  
					{
						board[i][j] = true;
					}

				}

			}

		} 

		for(boolean[] b : board)
		{
			System.out.println(Arrays.toString(b));
		}

		return board;

	}





	/*public static void isSubsetPossible(int[] collection , int target)
	{
		boolean[][] res_table = new boolean[collection.length+1][target+1];
		ArrayList<String> arr_ls = new ArrayList<String>(); 

		for(int i = 0 ; i <= collection.length ; i++)
		{
			for(int j = 0 ; j <= target ; j++)
			{
				if(i==0 && j==0)
				{
					res_table[i][j] = true;
				}
				else if(i == 0)
				{
					res_table[i][j] = false;
				}
				else if(j == 0)
				{
					res_table[i][j] = true;
				}
				else
				{
					if(res_table[i-1][j] == true)
					{
						res_table[i][j] = true;
					}
					else if(j-collection[i-1] >= 0)
					{
						if(res_table[i-1][j-collection[i-1]] == true)
						{
							res_table[i][j] = true;
						}
					}
					else
					{
						res_table[i][j] = false;
					}
					
				}
			}	
		}

		
		String ans = "";
		outer:
		for(int i = collection.length ; i >= 0 ; )
		{
			for(int j = target ; j >= 0 ; )
			{
				if(j == 0)
				{
					break outer;
				}

				if(res_table[i][j] == true)
				{
					ans = collection[i-1] + " " + ans;
					j = j-collection[i-1];
					i = i-1;
				}
				else
				{
					i = i-1;	
				}


			}	
		}



		for(boolean[] arr2 : res_table)
		{
			System.out.println(Arrays.toString(arr2));
		}
		System.out.println(ans);

	}*/


}
