package Dynamic_programming;
import java.util.*;
public class get_subsequence {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter the String");
		// String str = sc.nextLine();
		// getSubsequence(str);

		getPalindromicSubsequence("abccbc");
	}

	public static void getPalindromicSubsequence(String str)
	{
		boolean[][] board = new boolean[str.length()][str.length()];

		for(int i = 0 ; i < str.length() ; i++)
		{
			board[i][i] = true;
			if(i+1 < str.length())
				board[i+1][i] = true;
		}

		for(int i = str.length() - 1 ; i >= 0 ; i--)
		{
			for(int j = i ; j < str.length() ; j++)
			{
				if(i == j)
				{
					System.out.println(str.substring(i , j+1));
					continue;
				}

				String s = str.substring(i , j+1);
				if(s.charAt(0) == s.charAt(s.length() - 1))
				{
					// System.out.println(s);
					if(board[i+1][j-1] == true)
					{
						board[i][j] = true;
						System.out.println(s);
					}
					else  
					{
						board[i][j] = false;
					}
				}
				else  
				{
						board[i][j] = false;
				}

			}	

		}
		
		for(boolean[] b : board)
		{
			System.out.println(Arrays.toString(b));

		}

	}

	public static void getSubsequence(String str)
	{
		ArrayList<String>[] arr_ls = new ArrayList[str.length() + 1];
		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			arr_ls[i] = new ArrayList<>();
		}
		arr_ls[0].add("");

		for(int i = 1 ; i < arr_ls.length ; i++ )
		{
			char ch = str.charAt(i-1);
			for(String s : arr_ls[i-1])
			{
				arr_ls[i].add(s+ch);	
				arr_ls[i].add(s);	
			}
		}

		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			System.out.println(arr_ls[i]);
	
		}

	} 

}
