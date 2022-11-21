package GFG_practice;
import java.util.*;
public class first_non_duplicate_letter {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "aabbcc";
		System.out.println( getCharacter(str) );

	}

	public static int getCharacter(String str)
	{
		HashMap<Character , Pair> hmap = new HashMap<Character , Pair>();
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(hmap.containsKey(ch))
			{	
				hmap.get(ch).count++;
				hmap.put(ch , hmap.get(ch));
			}
			else  
			{
				Pair p = new Pair(i , 1);
				hmap.put(ch , p);
			}
		}

		for(Map.Entry<Character , Pair> entry : hmap.entrySet())
		{
			if(entry.getValue().count == 1)
			{
				return entry.getValue().index;
			}
		}

		return -1;

	} 

	public static class Pair
	{
		int index;
		int count;

		Pair(int index , int count)
		{
			this.index = index;
			this.count = count;
		}
	}

}
