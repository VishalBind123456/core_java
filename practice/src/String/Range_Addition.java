package String;

import java.util.*;

public class Range_Addition {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int length = 7;
		/*int[][] updates = {
			{1 , 3 , 2},
			{2 , 4 , 3},
			{0 , 2 , -2},
		};*/

		int[][] updates = {
			{2 , 4 , 3},
			{1 , 2 , -1},
			{0 , 5 , 2},
			{4 , 6 , 3},
		};

		int[] arr = new int[length];
		System.out.println(Arrays.toString(arr));

		int[] updated_arr = printRangeUpdate(updates , arr);

		System.out.println(Arrays.toString(updated_arr));

	}

	public static int[] printRangeUpdate(int[][] update_arr , int[] arr)
	{
		int[] temp_arr = new int[arr.length + 1];
		for(int[] sub_arr : update_arr)
		{
			temp_arr[sub_arr[0]] += sub_arr[2];
			temp_arr[sub_arr[1] + 1] += -(sub_arr[2]);
		}

		for(int i = 1 ; i < temp_arr.length ; i++)
		{
			temp_arr[i] += temp_arr[i-1];
		}

		return Arrays.copyOfRange(temp_arr , 0 , temp_arr.length-1);

	}

}
