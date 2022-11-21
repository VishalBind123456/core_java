package Dynamic_programming;

public class count_binary_strings_with_no_consecutive_zeros {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int length = 6;
		System.out.println(getCount(length));

	}

	public static int getCount(int length)
	{
		int[] zeros = new int[length+1];
		int[] ones = new int[length+1];

		zeros[0] = 0;
		ones[0] = 0;

		zeros[1] = 1;
		ones[1] = 1;

		for(int i = 2 ; i <= length ; i++)
		{
			zeros[i] = ones[i-1];
			ones[i] = ones[i-1] + zeros[i-1];
		}

		return zeros[length] + ones[length];

	} 


}
