package Dynamic_programming;

import java.util.*;

public class Count_subsequence_of_form_abc {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "abcabc";
		getSubsequence(str).stream().forEach(element -> { System.out.println(element); });

	}

	public static ArrayList<String> getSubsequence(String str)
	{
		ArrayList<String>[] arr_al = new ArrayList[str.length() + 1];
		arr_al[0] = new ArrayList<>();
		arr_al[0].add("");

		for(int i = 1 ; i < arr_al.length ; i++)
		{
			arr_al[i] = new ArrayList<>();

			// System.out.println(arr_al[i-1]);	//-------------
			
			for(String s : arr_al[i-1])
			{
				char ch = str.charAt(i-1);
				if(s.length() == 0 || s.charAt(s.length() - 1) <= ch)
				{
					arr_al[i].add(s + ch);
				}
				arr_al[i].add(s);
			}
		}
		// System.out.println(Arrays.toString(arr_al));
		return arr_al[str.length()];

	} 


}


/*abcc
abc
abbc
abb
abc
ab
acc
ac
aabc
aab
aac
aa
abc
ab
ac
a
bcc
bc
bbc
bb
bc
b
cc
c
abc
ab
ac
a
bc
b
c*/