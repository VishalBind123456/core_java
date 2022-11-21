package Dynamic_programming;

public class max_profit_after_buy_and_sell_stock {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// int[] arr = {11,6,7,19,4,1,6,18,4};
		// int[] arr = {1,2,3};
		// int max = getMax(arr);
		// int max = getTotal(arr);

		int[] arr = {10,15,17,20,16,18,22,20,22,20,23,25};
		// getTotalWithTransactionFee(arr);
		getTotalWithCooldown(arr);

	}

	public static void getTotalWithCooldown(int[] arr)
	{
		int bs = -arr[0];
		String bs_path = "b1";
		int ss = 0;
		String ss_path = "";
		int cds = 0;	
		String cds_path = "";	

		for(int i = 1 ; i < arr.length ; i++)
		{
			int prev_bs = bs;
			String prev_bs_path = bs_path;
			if(bs < cds + (-arr[i]))
			{
				bs = cds + (-arr[i]);
				bs_path = cds_path + "-" + "b" + (i+1);
			}

			int prev_ss = ss;
			String prev_ss_path = ss_path;
			if(ss < prev_bs + arr[i])
			{
				ss = prev_bs + arr[i];
				ss_path = prev_bs_path + "-" + "s" + (i+1);
			}

			if(cds < prev_ss)
			{
				cds = prev_ss;
				cds_path = prev_ss_path + "-" + "c" + (i+1);
			}


		}

		System.out.println(bs);
		System.out.println(bs_path);
		System.out.println(ss);
		System.out.println(ss_path);
		System.out.println(cds);
		System.out.println(cds_path);

	}

	public static void getTotalWithTransactionFee(int[] arr)
	{
		int bs = -arr[0];
		String bs_path = "b1";
		int ss = 0;
		String ss_path = "";
		int transaction_fee = 3;

		for(int i = 1 ; i < arr.length ; i++)
		{
			int prev_bs = bs;
			String prev_bs_path = bs_path;
			if(bs < ss + (-arr[i]))
			{
				bs = ss + (-arr[i]);
				bs_path = ss_path + "-" + "b" + (i+1);
			}
			if(ss < prev_bs + arr[i] - transaction_fee)
			{
				ss = prev_bs + arr[i]  - transaction_fee;
				ss_path = prev_bs_path + "-" + "s" + (i+1);
			}
			// bs = Math.max(bs , ss + (-arr[i]));
			// ss = Math.max(ss , prev_bs + (-arr[i]));
		}

		System.out.println(bs);
		System.out.println(bs_path);
		System.out.println(ss);
		System.out.println(ss_path);

	}

	public static int getMax(int[] arr)
	{
		int max_profit = Integer.MIN_VALUE;
		int least_idx = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(arr[i] < arr[least_idx])
				least_idx = i;
			if(arr[i] - arr[least_idx] > max_profit)
				max_profit = arr[i] - arr[least_idx];
		}
		return max_profit;
	}

	public static int getTotal(int[] arr)
	{
		int total = 0;
		int least_idx = 0;
		boolean flag = true;


		for(int i = 1 ; i < arr.length ; i++)
		{
			// System.out.print(" " + total);
			// System.out.print(" " + arr[least_idx]);
			// System.out.print(" " + arr[i-1]);
			// System.out.print(" " + arr[i]);
			// System.out.println();

			if(arr[i] >= arr[i-1])
			{
				if(i == arr.length-1)
				{
					total += arr[i] - arr[least_idx];
					continue;
				}

				if(flag)
					continue;
				least_idx = i-1;
				flag = true;
				// continue;
			}
			else if(arr[i] <= arr[i-1] && flag)
			{
				total += arr[i-1] - arr[least_idx];
				flag = false;
			}

		}
		return total;

	}

}
