package GFG_practice;
import java.util.*;
public class minimize_ugliness_of_String {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "111011";
		int n = str.length();
		int cash = 7;
		int swap = 3;
		int flip = 2;

		String ans = (swap < flip) ? swap( str , cash , swap) : flip( str , cash , flip) ;
		System.out.println(ans);

	}

	public static String swap(String str , int cash , int swap)
	{
		StringBuilder sb = new StringBuilder(str);

		int one_idx = -1;

		for(int i = 0 ; i < str.length() ; )
		{
			if(sb.charAt(i) == '0' && one_idx == -1)
			{
				i++;
			}
			else if(sb.charAt(i) == '1')
			{
				if(one_idx == -1)
				{
					one_idx = i;
				}
				i++;
			} 
			else if(cash >= swap) 
			{
				sb.setCharAt(one_idx , '0');
				sb.setCharAt(i , '1');

				cash -= swap;
				one_idx++;
				i++;

			}
		}

		return sb.toString();

	}


	public static String flip(String str , int cash , int flip)
	{
		StringBuilder sb = new StringBuilder(str);

		for(int i = 0 ; i < str.length() ; i++)
		{
			if(cash >= flip && str.charAt(i) == '1')
			{
				cash -= flip;
				sb.setCharAt(i , '0');

				// System.out.println(sb);
			}
		}

		return sb.toString();

	} 



}
