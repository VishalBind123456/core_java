package Dynamic_programming;
import java.util.*;
public class printAllPathsWithMinimumJumps {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {3,3,0,2,1,2,4,2,0,0};
		printMinPath(arr);

	}

	public static void printMinPath(int[] arr)
	{
		Integer[] res = new Integer[arr.length];

		res[res.length-1] = 0; 
		for(int i = res.length - 2 ; i >= 0 ; i--)
		{
			if(arr[i] == 0)
			{
				res[i] = null;
				continue;
			}
			int min_step = Integer.MAX_VALUE;
			for(int j = 1 ; j <= arr[i] ; j++)
			{
				if(i+j < res.length && res[i+j] != null && res[i+j] + 1 < min_step)
				{
					min_step = res[i+j] + 1;
				}
			}
			res[i] = min_step;

		}

		System.out.println(Arrays.toString(res));

		/*StringBuilder sb = new StringBuilder("");
		for(int i = 0 ; i < arr.length ; )
		{
			int min = Integer.MAX_VALUE;
			int idx = i;
			sb.append(i + " ");
			for(int j = 1 ; j <= arr[i] ; j++)
			{
				if(i+j < res.length && res[i+j] != null && res[i+j] < min)
				{
					min = res[i+j];
					idx = i+j;
				}
			}
			i = (i == idx) ? ++i : idx ;
			// System.out.println(i + " ");
		} 
		System.out.println(sb);*/

		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(0 , arr[0] , "0" , arr.length-1));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.src == p.dest)
			{
				System.out.println(p.psf);
				continue;
			}

			for(int i = 1 ; i <= p.steps ; i++)
			{
				if(p.src+i < arr.length && res[p.src+i] != null && res[p.src+i] == res[p.src]-1)
				{
					dq.addLast(new Pair(p.src+i , arr[p.src+i] , p.psf + "-" + (p.src+i) , p.dest));
				}
			}
		}


	} 


	public static class Pair
	{
		int src;
		int steps;
		String psf;
		int dest;

		Pair(int src,int steps,String psf,int dest)
		{
			this.src =   src;
			this.steps = steps;
			this.psf =   psf;
			this.dest =  dest;			
		}
		
	}

}
