package GFG_practice;

public class patternPractice 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// System.out.println("*");
		int m = 4;
		int n = 4;
//		printBox(m , n);
		printTriangle(m , n);

	}
	
	public static void printTriangle(int m , int n)
	{
		for(int i = 1 ; i <= m ; i++)
		{
			
			for(int j = 1 ; j <= m-i+1 ; j++)
			{
				System.out.print("*");
			}
//			for(int j = 1 ; j <= i ; j++)
//			{
//				System.out.print("*");
//			}
			System.out.println();
		}
	}
	
	public static void printBox(int m , int n)
	{
		for(int i = 0 ; i < m ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if(i == 0 || j == 0 || i == m-1 || j == n-1)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
