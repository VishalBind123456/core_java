package String;

import java.util.*;

public class toggle_case_of_character {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder("Hello-MAN");
		System.out.println( sb + " <------ Original String ");
		// System.out.println( toggleCase(sb) + " <------ first method ");
		System.out.println( toggleCase_2(sb) + " <------ second method ");
 
	}

	public static StringBuilder toggleCase_2(StringBuilder str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z')
			{
				char capital = (char)('A' + ch - 'a');
				str.setCharAt(i , capital);
			}

			if(ch >= 'A' && ch <= 'Z')
			{
				char small = (char)('a' + ch - 'A');
				str.setCharAt(i , small);
			}

		}
		return str;

	}

	public static StringBuilder toggleCase(StringBuilder str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) <= 96 )
			{
				str.setCharAt(i , Character.toLowerCase(str.charAt(i)));
			}
			else  
			{
				str.setCharAt(i , Character.toUpperCase(str.charAt(i)));
			}

		}
		return str;

	} 

}
