package Recursion;

public class print_abbriviations {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ques = "pep";
		printSubsequence(ques , "." , 0);

	}

	public static void printSubsequence(String ques , String ans , int count)
	{
		if(ques.length() == 0)
		{
			if(count > 0)
			{
				System.out.println(ans + count);
			}
			else  
			{
				System.out.println(ans);
			}
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		if(count > 0)
		{
			printSubsequence(ros , ans + count + ch , 0);		
		}
		else  
		{
			printSubsequence(ros , ans + ch , 0);		
		}
		printSubsequence(ros , ans , count + 1);		
	}


}
