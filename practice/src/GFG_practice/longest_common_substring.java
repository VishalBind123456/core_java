package GFG_practice;
import java.util.*;
public class longest_common_substring {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "acb";

		// printLCSS(str1 , str2);		//----> Longest Common Sub Sequence -----
		printLCSS_2(str1 , str2);		//----> Longest Common Sub Sequence 2 -----

	}

	public static void printLCSS_2(String str1 , String str2)
	{
		int shorter = 0;
		int longer = 0;
		if(str1.length() <= str2.length())
		{
			shorter = str1.length();
			longer = str2.length();
		}
		else  
		{
			shorter = str2.length();
			longer = str1.length();
		}

		ArrayList<String>[] arr_ls = new ArrayList[shorter + 1];
		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			arr_ls[i] = new ArrayList<>();
		}


		for(int i = 1 ; i <= shorter ; i++)
		{
			for(int j = 0 ; j+i <= longer ; j++)
			{
				arr_ls[i].add(str1.substring(j , j+i));

			}

		}

		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			System.out.println(arr_ls[i]);
	
		}

		for(int i = shorter ; i >= 1 ; i--)
		{	
			boolean flag = false;
			for(int j = 0 ; j+i <= shorter ; j++)
			{
				for(String s : arr_ls[i])
				{
					if(s.equals(str2.substring(j , j+i)))
					{
						System.out.println(str2.substring(j , j+i));	//----> for all answers we can add all answers in arraylist-----
						flag = true;
					}
				}

			}
			if(flag)
				break;

		}	


	} 


	public static void printLCSS(String str1 , String str2) 
	{
		int shorter = 0;
		int longer = 0;
		if(str1.length() <= str2.length())
		{
			shorter = str1.length();
			longer = str2.length();
		}
		else  
		{
			shorter = str2.length();
			longer = str1.length();
		}

		ArrayList<String>[] arr_ls = new ArrayList[shorter];

		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			arr_ls[i] = new ArrayList<>();
		}


		for(int i = 0 ; i < longer ; i++ )
		{	
			for(int j = i ; j < i + shorter && j < longer ; j++ )
			{
				arr_ls[j-i].add(str1.substring(i , j+1));
			}

		}

		for(int i = 0 ; i < arr_ls.length ; i++ )
		{
			System.out.println(arr_ls[i]);
	
		}



		outer:
		for(int i = shorter; i > 0 ; i--)
		{	
			for(int j = 0 ; j < i && j < shorter ; j++)
			{
				for(String s : arr_ls[i-j - 1])
				{
					if(s.equals(str2.substring(j , i)))
					{
						System.out.println(str2.substring(j , i));	//----> for all answers we can add all answers in arraylist-----
						break outer;
					}
				}
			}

		}



	}

}
