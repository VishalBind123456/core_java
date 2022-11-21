package Dynamic_programming;
import java.util.*;
public class printAllMinCostPath {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] arr = {
			{2,6,1,1,3},
			{9,1,1,0,5},
			{0,7,5,2,0},
			{4,3,0,4,7},
			{2,0,1,4,1},
		};

		printAllPath(arr);
	}

	public static void printAllPath(int[][] arr)
	{
		int[][] res = new int[arr.length][arr[0].length];

		for(int i = arr.length-1 ; i >= 0 ; i--)
		{
			for(int j = arr.length-1 ; j >= 0 ; j--)
			{
				if(i == arr.length-1 && j == arr.length-1)
				{
					res[i][j] = arr[i][j];
				}
				else if(i == arr.length-1)
				{
					res[i][j] = arr[i][j] + res[i][j+1];
				}
				else if(j == arr.length-1)
				{
					res[i][j] = arr[i][j] + res[i+1][j];
				}
				else
				{
					res[i][j] = arr[i][j] + Math.min(res[i+1][j] , res[i][j+1]);
				}
			}
		}

		for(int[] ar : res)
			System.out.println(Arrays.toString(ar));

		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(0 , 0 , arr.length-1 , arr[0].length-1 , "0"));

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.r == p.dr && p.c == p.dc)
			{
				System.out.println(p.psf);
				continue;
			}

			if(p.c+1 < arr[p.r].length && res[p.r][p.c+1] == res[p.r][p.c] - arr[p.r][p.c])
				dq.add(new Pair(p.r , p.c+1 , p.dr , p.dc , p.psf + "->" + "h"));

			if(p.r+1 < arr.length && res[p.r+1][p.c] == res[p.r][p.c] - arr[p.r][p.c])
				dq.add(new Pair(p.r+1, p.c , p.dr , p.dc , p.psf + "->" + "v"));


		}

	} 

	public static class Pair
	{
		int r;
		int c;
		int dr;
		int dc;
		String psf;

		Pair(int r, int c, int dr, int dc, String psf)
		{
			this.r =   r;
			this.c =   c;
			this.dr =  dr;
			this.dc =  dc;
			this.psf = psf;
		}

	}

}
