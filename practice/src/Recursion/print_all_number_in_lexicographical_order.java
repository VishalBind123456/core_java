package Recursion;

public class print_all_number_in_lexicographical_order {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 100;
		int parent = 0;
		printNumber(n , parent);

	}

	public static void printNumber(int n , int parent)
	{
		// if(parent > n)
		// {
		// 	return;
		// }

		for(int i = 0 ; i <= 9 ; i++)
		{
			int new_parent = (parent * 10) + i;
			if(new_parent != 0 && new_parent <= n)
			{
				System.out.println(new_parent);
				printNumber(n , new_parent);
			}
		}
	} 

}
