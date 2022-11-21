package Dynamic_programming;

public class Max_sum_non_adjacent_elements {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {5 , 10 , 10 , 100 , 5 , 6};

		// getMaxSum_recursive(arr , 0 , 0 , "" , true);
		// System.out.println(max_path + " ---> " + max_sum);

		getMaxSum_DP(arr);
	}

	public static void getMaxSum_DP(int[] arr)
	{
		int[] inc = new int[arr.length + 1];
		String[] inc_path = new String[arr.length + 1];
		inc_path[0] = "";

		int[] exc = new int[arr.length + 1];
		String[] exc_path = new String[arr.length + 1];
		exc_path[0] = "";

		for(int i = 1 ; i <= arr.length ; i++)
		{
			inc[i] = exc[i-1] + arr[i-1];
			inc_path[i] = exc_path[i-1] + " " + arr[i-1];

			exc[i] = Math.max(inc[i-1] , exc[i-1]);
			exc_path[i] = (inc[i-1] >= exc[i-1]) ? inc_path[i-1] : exc_path[i-1] ;
		}

		if(inc[arr.length] > exc[arr.length])
		{
			System.out.println(inc[arr.length] + " ---> " + inc_path[arr.length]);
		}
		else 
		{
			System.out.println(exc[arr.length] + " ---> " + exc_path[arr.length]);

		}


	}

	public static int max_sum = 0;
	public static String max_path = "";

	public static void getMaxSum_recursive(int[] arr , int idx , int sum , String path , boolean flag)
	{
		if(idx == arr.length)
		{
			if(sum > max_sum)
			{
				max_sum = sum;
				max_path = path;
			}
			return;
		}

		if(flag == true)
		{
			getMaxSum_recursive(arr , idx + 1 ,  sum , path , false);
		}
		else
		{
			getMaxSum_recursive(arr , idx + 1 , sum + arr[idx] , path + " " + arr[idx] , true);
			getMaxSum_recursive(arr , idx + 1 , sum , path , false);
		}

	} 

}
