package Dynamic_programming;
import java.util.*;
public class paint_house_many_colors {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HashMap<Integer , Integer[]> hmap = new HashMap<Integer , Integer[]>();
		hmap.put(0 , new Integer[]{1,5,7,2,1,4});
		hmap.put(1 , new Integer[]{5,8,4,3,6,1});
		hmap.put(2 , new Integer[]{3,2,9,7,2,3});
		hmap.put(3 , new Integer[]{1,2,4,9,1,7});

		paintHouseManyColors(hmap , 4 , 6);
	}

	public static void paintHouseManyColors(HashMap<Integer , Integer[]> hmap , int no_of_house , int no_of_colors)
	{
		Integer[][] dp = new Integer[no_of_house][no_of_colors];

		String[] prev = new String[no_of_colors];
		String[] path = new String[no_of_colors];

		for(int i = 0 ; i < dp.length ; i++)
		{
			int least = Integer.MAX_VALUE;
			int sleast = Integer.MAX_VALUE;
			int least_idx = -1;
			int sleast_idx = -1;

			for(int j = 0 ; j < dp[i].length && i > 0 ; j++)
			{
				if(dp[i-1][j] <= least)
				{
					sleast = least;
					sleast_idx = least_idx;

					least = dp[i-1][j];
					least_idx = j;
				}
				else if(dp[i-1][j] < sleast)
				{
					sleast = dp[i-1][j];
					sleast_idx = j;
				}

			}

			// System.out.println(least + " " + least_idx + " " + sleast + " " + sleast_idx);

			for(int j = 0 ; j < dp[i].length ; j++)
			{
				if(i == 0)
				{
					dp[i][j] = hmap.get(0)[j];
					path[j] = "c" + j;
				}
				else
				{
					if(dp[i-1][j] == least)
					{
						dp[i][j] = hmap.get(i)[j] + sleast;
						path[j] = prev[sleast_idx] + "-" +  "c" + j;  
					}
					else  
					{
						dp[i][j] = hmap.get(i)[j] + least;
						path[j] = prev[least_idx] + "-" +  "c" + j;  

					}

				}
		
			}

			prev = Arrays.copyOfRange(path , 0 , path.length);
			path = new String[no_of_colors];  

			System.out.println(Arrays.toString(dp[i]));

		}

		System.out.println(Arrays.toString(prev));

	} 

}
