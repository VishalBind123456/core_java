package String;

import java.util.*;

public class permutation_of_string_iterative {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// permutaion("abc" , "");
		permutaion_2("abc");

	}

	public static void permutaion_2(String str)  //----> Iterative solution ------------- Trick based on factorial -----
	{
		int len = getFactorial(str.length());
		// System.out.println(len);
		for(int i = 0 ; i < len ; i++)
		{
			String s = "";
			StringBuilder ques = new StringBuilder(str);

			while(ques.length() != 0)
			{
				int x = i % ques.length();
				s = s + ques.charAt(x);
				ques.deleteCharAt(x);
			}
			
			System.out.println(s);

		}

	}

	public static int getFactorial(int n)
	{
		int[] fact = new int[n+1];
		fact[0] = 1;

		for(int i = 1 ; i <= n ; i++)
		{
			fact[i] =  fact[i-1] * i;
		}
		return fact[n];
	}

	public static void permutaion(String str , String ans)  //----> recursive solution -------------
	{
		if(str.length() == 0)
		{
			System.out.println(ans);
			return;
		}

		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			String ros = str.substring(0 , i) + str.substring(i+1);

			permutaion(ros , ans + ch);

		}
	} 


}
