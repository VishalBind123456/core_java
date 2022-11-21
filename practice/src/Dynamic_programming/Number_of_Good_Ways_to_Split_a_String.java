package Dynamic_programming;
import java.util.*;
public class Number_of_Good_Ways_to_Split_a_String {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "aabaca";
		solution(str);
	}
	public static void solution(String str)
	{
		HashSet<Character> set = new HashSet<Character>();
		int len = str.length();
		int[] left = new int[len];
		int[] right = new int[len];

		int count = 0;
		for(int i = 0 ; i < len ; i++)
		{
			if(set.contains(str.charAt(i)))
			{
				left[i] = count;
			}
			else
			{
				set.add(str.charAt(i));
				count++;
				left[i] = count;
			}
		}

		set = new HashSet<Character>();
		count = 0;
		for(int i = len-1 ; i >= 0 ; i--)
		{
			if(set.contains(str.charAt(i)))
			{
				right[i] = count;
			}
			else
			{
				set.add(str.charAt(i));
				count++;
				right[i] = count;
			}
		}

		for(int i = 0 ; i < len-1 ; i++)
		{
			if(left[i] == right[i+1])
			{
				System.out.println(str.substring(0,i+1) + " " + str.substring(i+1));
			}
		}

	} 

}
