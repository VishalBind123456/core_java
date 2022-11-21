package Print_Problem;

public class print_permutations {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		printPermutations("abcd" , "");

	}

	public static void printPermutations(String ques , String ans)
	{
		if(ques.length() == 0)
		{
			System.out.println(ans);
			return ;
		}

		for(int i = 0 ; i < ques.length() ; i++)
		{
			printPermutations(ques.substring(0,i) + ques.substring(i+1) , ques.charAt(i) + ans );
		}

	}

}
