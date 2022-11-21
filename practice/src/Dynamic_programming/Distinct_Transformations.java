package Dynamic_programming;

public class Distinct_Transformations {

	public static int[][] memo;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ques = "aaaabbbccd";
		String ans = "abcd";

		memo = new int[ques.length()][ans.length()];
		int ways = getWaysRecursive(ques , ans , 0 , 0);
		System.out.println(ways);

	}
	public static int getWaysRecursive(String ques , String ans , int i , int j)
	{



		if(ques.substring(i).equals(ans.substring(j)))
			return 1;

		if(i == ques.length())
			return 0;

		if(j == ans.length())
			return 1;

		if(memo[i][j] != 0)
			return memo[i][j];

		int keep = 0;
		int discart = 0;
		if(ques.charAt(i) == ans.charAt(j))
			keep = getWaysRecursive(ques , ans , i+1 , j+1);
		discart = getWaysRecursive(ques , ans , i+1 , j);

		memo[i][j] = keep+discart;
		return keep+discart;

	} 

}
