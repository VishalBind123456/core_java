package Dynamic_programming;
import java.util.*;
public class Distinct_Echo_Substrings {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ques = "abcabcabc";
		printDistinctSubstring(ques);

	}

	public static void printDistinctSubstring(String ques)
	{
		HashSet<String> set = new HashSet<String>();
		for(int len = 1 ; len <= ques.length()/2 ; len++)
		{
			int count = 0;
			for(int i = 0 , j = len ; j < ques.length() ; i++,j++)
			{
				if(ques.charAt(i) == ques.charAt(j))
					count++;
				else
					count = 0;

				if(count == len)
				{
					set.add(ques.substring(i,j));
					count--;
				}

			}
		}

		System.out.println(set);

	} 

}
