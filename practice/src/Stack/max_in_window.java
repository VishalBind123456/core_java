package Stack;
import java.util.*;
public class max_in_window 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int arr[] = {2,9,3,8,1,7,12,6};
		int k = 4;
		printAllWindow(arr , k);
	}

	public static void printAllWindow(int[] arr , int k)
	{
		int[] res = new int[arr.length];
		Stack<Integer> stk = new Stack<Integer>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			while(stk.size() > 0 && arr[stk.peek()] < arr[i])
			{
				res[stk.peek()] = i;
				stk.pop(); 
			}
			stk.push(i);
			res[i] = Integer.MAX_VALUE;
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(res));

		int[] win = new int[arr.length];
		int i = 0 , j = 0 , prev = 0;
		for(int idx = 0 ; idx <= arr.length-k ; idx++)
		{
			i = j = prev = idx;
			while(j < i+k)
			{
				prev = j;
				j = res[j];
			}
			win[i] = arr[prev];
		}
		System.out.println(Arrays.toString(win));
	} 

}
