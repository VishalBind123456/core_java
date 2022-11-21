package Dynamic_programming;

import java.util.*;

public class Decode_ways {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		char[] codes = {'-','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String num = "21123";
		System.out.println( decode(num , codes) );
	}

	public static ArrayList<String> decode(String num , char[] codes)
	{
		ArrayList<String>[] arr_al = new ArrayList[num.length() + 1];
		arr_al[0] = new ArrayList<String>();
		arr_al[0].add("");

		for(int i = 1 ; i < arr_al.length ; i++)
		{
			arr_al[i] = new ArrayList<String>();
			for(String s : arr_al[i-1])
			{
				int code_idx = Integer.parseInt(num.substring(i-1 , i));
				if(code_idx != 0)
				{
					arr_al[i].add( s + codes[code_idx] );
				}
			}

			if(i >= 2)
			{
				for(String s : arr_al[i-2])
				{
					int code_idx = Integer.parseInt(num.substring(i-2 , i));
					if(code_idx < codes.length && code_idx > 9)
					{
						arr_al[i].add( s + codes[code_idx] );
					}
				}
			}

		}

		return arr_al[num.length()];

	} 

}
