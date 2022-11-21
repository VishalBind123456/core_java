package Bit_Manipulation;

public class all_repeating_except_two {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {36,50,24,56,36,24,42,50};

		printTwoSingles(arr);
	}

	public static void printTwoSingles(int[] arr)
	{
		int mask = 0;
		for(int val : arr)
		{
			mask = mask ^ val;
		}

		int rmsb = mask & -mask;

		int first_num = 0;
		int second_num = 0;

		for(int val : arr)
		{
			if((val & rmsb) == 0){ first_num = first_num ^ val; }
			else { second_num = second_num ^ val; }
		}

		System.out.println(first_num + " " + second_num);

	} 

}
