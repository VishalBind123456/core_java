package String;

import java.util.*;

public class String_Compression {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "aaabbcccddaeef";
		System.out.println(str);
		compression1(str);
		compression2(str);

	}

	public static void compression1(String str)
	{
		StringBuilder stbr = new StringBuilder("");
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(i == 0)
			{
				stbr.append(str.charAt(i));
			}
			else  
			{
				if(str.charAt(i) != str.charAt(i-1))
				{
					stbr.append(str.charAt(i));
				}
			}
		}

		System.out.println(stbr);
	}

	public static void compression2(String str)
	{
		StringBuilder stbr = new StringBuilder("");
		int count = 1;
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(i == 0)
			{
				stbr.append(str.charAt(i));
			}
			else  
			{
				if(str.charAt(i-1) != str.charAt(i))
				{
					if(count != 1)
					{
						stbr.append(count);
						count = 1;
					}
					stbr.append(str.charAt(i));
				}
				else 
				{
					count++;
				}
			}
		}

		System.out.println(stbr);
	}

}
