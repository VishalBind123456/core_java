package Dynamic_programming;
import java.util.*;
public class Partition_into_subset_dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;	//---> no of teams we want to make -----
		String people = "abcd";	//---> no of people we hava ----
		System.out.println( getAllTeams_R(k , people) );

	}

	/*public static void printAllTeams(int k , String people)
	{
		ArrayList<String>[] dp = new ArrayList[k+1];		//-----> store all teams at each stage ----
		for(int i = 0 ; i < dp.length ; i++)
			dp[i] = new ArrayList<String>();

		for(char ch : people.toCharArray())
			dp[1].add(ch);

		for(int i = 2 ; i < dp.length ; i++)
		{
			for(String s : dp[i-1])
				dp[i].add();
		}


	} */

	public static ArrayList<String> getAllTeams_R(int k , String people)
	{
		ArrayList<String> res = new ArrayList<>();
		if(k == people.length())
		{
			String str = "";
			for(char ch : people.toCharArray())
			{
				str += ch + " ";
			}
			res.add(str);
			return res;	
		}
		if(k == 1)
		{
			res.add(people);
			return res;
		}

		char ch = people.charAt(people.length()-1);
		ArrayList<String> left = getAllTeams_R(k , people.substring(0,people.length()-1));	
		ArrayList<String> right = getAllTeams_R(k-1 , people.substring(0,people.length()-1));

		for(String s : left)
		{
			String[] arr2 = s.split(" ");
			for(int i = 0 ; i < arr2.length ; i++)
			{
				String[] arr = s.split(" ");
				arr[i] += ch;
				res.add(String.join(" " , arr));	//------------what....???
			}

		}	

		for(String s : right)
		{
			res.add(s + " " + ch);
		}

		return res;
	}

}
