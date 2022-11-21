package Dynamic_programming;
import java.util.*;
public class Delete_and_earn {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {3,2,3,7,4};
		printMaxEarning(arr);

	}

	public static void printMaxEarning(int[] arr)
	{
		// int[] dp  = new int[arr.length+1];
		Arrays.sort(arr);
		int max = arr[arr.length-1];
		
		int[] temp = new int[max+1];
		int[] inc  = new int[max+1];
		int[] exc  = new int[max+1];

		System.out.println(Arrays.toString(arr));

		for(int i = 0 ; i < arr.length ; i++)
			temp[arr[i]]++;
		System.out.println(Arrays.toString(temp));

		// dp[0] = 0;
		inc[0] = 0;
		exc[0] = 0;
		for(int i = 1 ; i < inc.length ; i++)
		{
			int val = 0;
			inc[i] = exc[i-1] + i*temp[i];
			exc[i] = Math.max(inc[i-1] , exc[i-1]);
		}

		System.out.println(Arrays.toString(inc));
		System.out.println(Arrays.toString(exc));
	
	} 

}
