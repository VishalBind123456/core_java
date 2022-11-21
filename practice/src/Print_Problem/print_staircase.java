package Print_Problem;

public class print_staircase {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int n = 5;
		printPath(n , "");

	}

	public static void printPath(int n , String ans)
	{

		if(n < 0)
		{
			return ;
		}
		
		if(n == 0)
		{
			System.out.println(ans);
			return ;
		}

		for(int i = 1 ; i <= 3 ; i++)
		{
			printPath(n-i , i+ans);
		}
	}

}
