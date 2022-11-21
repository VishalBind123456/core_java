package GFG_practice;
import java.util.*;
public class Find_Kth_Largest_Element {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {3,1,8,7,4,2,5,2};
		int[] res = get_Five_Largest(arr);
		System.out.println(Arrays.toString(res));

		int[] p = {8 , 10};

		int min_time = (p[0] < p[1]) ? Math.max(p[0] + res[0] , p[1] + res[4]) : Math.max(p[1] + res[0] , p[0] + res[4]) ;

		System.out.println( min_time );
	}

	public static int[] get_Five_Largest(int[] arr)
	{

		int l1;	//---largest 1
		int l2;	//---largest 2
		int l3;	//---largest 3
		int l4;	//---largest 4
		int l5;	//---largest 5

		l1 = l2 = l3 = l4 = l5 = Integer.MIN_VALUE;

		for(int i = 0 ; i < arr.length ; i++)
		{

			if(arr[i] > l1)
			{
				l5 = l4;
				l4 = l3;
				l3 = l2;
				l2 = l1;
				l1 = arr[i];
			}
			else if(arr[i] > l2)
			{
				l5 = l4;
				l4 = l3;
				l3 = l2;
				l2 = arr[i];
			}
			else if(arr[i] > l3)
			{
				l5 = l4;
				l4 = l3;
				l3 = arr[i];
			}
			else if(arr[i] > l4)
			{

				l5 = l4;
				l4 = arr[i];
			}
			else if(arr[i] > l5)
			{
				l5 = arr[i];
			}
		}

		int[] res = new int[5];
		res[0] = l1;
		res[1] = l2;
		res[2] = l3;
		res[3] = l4;
		res[4] = l5;

		// System.out.println(l1 + " " + l2 + " " + l3 + " " + l4 + " " + l5);

		return res;

	} 

}
