package GFG_practice;

import java.util.*;

public class best_Apartment {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		block[] blocks = {
			new block(false , true , false) ,
			new block(true , false , false) ,
			new block(true , true , false)  ,
			new block(false , true , false) ,
			new block(false , true , true) ,
		};

		String[] req = {"gym" , "school" , "store"};		//-----> not used anywhere -----
		Integer[][] ans = new Integer[blocks.length][req.length];

		for(Integer [] arr1 : ans)
		{
			Arrays.fill(arr1 , Integer.MAX_VALUE);
		}

		int sum = Integer.MAX_VALUE;
		int block_idx = 0;
		int max_step = Integer.MAX_VALUE;
		for(int i = 0 , temp = 0 ; i < blocks.length ; i++)
		{
			for(int j = 0 ; j < blocks.length ; j++)
			{
				ans[i][0] = (blocks[j].gym == true) ? Math.min(ans[i][0] , Math.abs(j-i)) : ans[i][0];
				ans[i][1] = (blocks[j].school == true) ? Math.min(ans[i][1] , Math.abs(j-i)) : ans[i][1];
				ans[i][2] = (blocks[j].store == true) ? Math.min(ans[i][2] , Math.abs(j-i)) : ans[i][2];
				temp = ans[i][0] + ans[i][1] + ans[i][2];
			}

			if(sum >= temp)
			{
				sum = temp;
				Integer max = Collections.max(Arrays.asList(ans[i]));
				if(max < max_step)
				{
					block_idx = i;
				}
			}

		}

		for(Integer[] arr1 : ans)
		{
			System.out.println(Arrays.toString(arr1));
		}

		System.out.println("total steps = " + sum + " " + "block index = " + block_idx + "\nappartemt in this block has minimum steps from all sources");

	}

	public static class block
	{
		boolean gym ;
		boolean school ;
		boolean store ;

		block(boolean gym , boolean school  ,boolean store)
		{
			this.gym = gym;
			this.school = school;
			this.store = store;
		}
	}

}
