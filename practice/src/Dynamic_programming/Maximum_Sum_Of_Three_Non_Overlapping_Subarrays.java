package Dynamic_programming;
import java.util.*;
public class Maximum_Sum_Of_Three_Non_Overlapping_Subarrays {
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k = 2;
		int[] arr = {1,2,1,2,6,7,5,1};
		// int k = 3;
		// int[] arr = {5,2,1,4,3,4,2,1,3,6,3,3,6};
		findMaxSum(arr , k);		
	}

	public static void findMaxSum(int[] arr , int k)
	{
		System.out.println(Arrays.toString(arr) + " <---- original Array ");
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int[] cumulative_sum = new int[arr.length];

		for(int i = 0 ; i < arr.length ; i++)
			cumulative_sum[i] = (i == 0) ? arr[i] : arr[i]+cumulative_sum[i-1] ;

		System.out.println(Arrays.toString(cumulative_sum) + " <---- cumulative_sum array ");

		int window = 0;
		for(int i = 0 ; i < left.length ; i++)
		{
			if(i < k)
			{
				window += arr[i];
				left[i] = (i == k-1) ? window : 0;
			}
			else
			{
				left[i] = Math.max(window , window+arr[i]-arr[i-k]);
			}
		}

		window = 0;
		for(int i = right.length-1 ; i >= 0 ; i--)
		{
			if(i+k >= right.length)
			{
				window += arr[i];
				right[i] = (right.length-i == k) ? window : 0;
			}
			else
			{
				right[i] = Math.max(window , window+arr[i]-arr[i+k]);
			}
		}

		System.out.println(Arrays.toString(left) + " <---- left array ");
		System.out.println(Arrays.toString(right) + " <---- right array ");

		int max_sum = Integer.MIN_VALUE;
		int m_idx = -1;
		for(int i = k ; i <= left.length-2*k ; i++)
		{
			int val = cumulative_sum[i+k-1] - cumulative_sum[i-1] + left[i-1] + right[i+k];
			if(val > max_sum)
			{
				max_sum = val;
				m_idx = i;
			}
		}

		System.out.println(max_sum);
		System.out.println(m_idx);




	} 

}
