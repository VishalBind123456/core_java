package Bit_Manipulation;

import java.util.*;

public class on_off_toggle_check {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int b = 123;

		int[] arr = getBits(b);
		System.out.println(Arrays.toString(arr));

		int num = getNum(arr);
		System.out.println(num);

		int onmask = 1;
		int offmask = 1;
		int togglemask = 1;
		int detectmask = 1;

		int j = 2; //--- 2nd bit to on
		int k = 3; //--- 3rd bit to off
		int l = 4; //--- 4th bit to toggle
		int m = 2; //--- 2nd bit to check

		int x = onmask << j;

		// System.out.println(Arrays.toString(getBits(x)));
		// System.out.println(getNum(getBits(x)));

		System.out.println(Arrays.toString(getBits(num | x)) + "  <----- 2 nd bit is turned on ");

		x = offmask << k;
		x = ~x;
		System.out.println(Arrays.toString(getBits(num & x)) + "  <----- 3 rd bit is turned off ");

		x = togglemask << l;
		System.out.println(Arrays.toString(getBits(num ^ x)) + "  <----- 4 th bit is toggled ");

		x = detectmask << m;
		boolean val = ((num & x) == 0 ) ? false : true;
		System.out.println( val + "  <-----  2 nd bit detected ");








	}

	public static int[] getBits(int num)
	{
		String str = "";
		while(num != 0 )
		{
			str = str + num%2;
			num = (num/2);
		}

		int[] arr = new int[str.length()];
		for(int i = 0 ; i < arr.length ; i++)
		{
			arr[i] = Integer.parseInt(str.split("")[i]);
		}

		return arr;
	}

	public static int getNum(int[] arr)
	{
		int num = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			num = (int)(num + arr[i]*(Math.pow(2 , i)));
		}

		return num;
	}



}




