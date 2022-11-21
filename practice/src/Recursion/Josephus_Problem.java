package Recursion;

public class Josephus_Problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 5 , k = 3;
		System.out.println( solution(n , k)  +  " <---- Element of this index will survive ");

	}

	public static int solution(int n , int k)
	{
		if(n == 1)
		{
			return 0;	//---> for n = 1 means Only 1 element is remaining therefore return index = 0;
		}

		int x = solution(n-1 , k);
		x = (x + k)%n;	//-----> here this trick plays an important role .....
		return x;
	} 

}
