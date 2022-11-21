package Dynamic_programming;

import java.util.*;

public class get_maze_path_with_jump {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sr = 1 , sc = 1 , dr = 8 , dc = 8;

		long start = System.nanoTime();
		getPath(sr , sc , dr , dc);
		long end = System.nanoTime();
		
		System.out.println("Execution time in milliseconds.");
		System.out.println( (float)(end-start)/1000000 );
		
		//getPath(sr , sc , dr , dc).stream().forEach(element -> { System.out.println(element); });

	}
	
	public static ArrayList<String> getPath(int sr , int sc , int dr , int dc)
	{
		ArrayList<String>[][] res = new ArrayList[dr+1][dc+1];
		
		for(int a = 0 ; a < res.length ; a++)
		{
			for(int b = 0 ; b < res[0].length ; b++)
			{
				res[a][b] = new ArrayList<String>();
			}
		}
		
		res[dr][dc].add("");

		for(int i = dr ; i >= 1 ; i--)
		{
			for(int j = dc ; j >= 1 ; j--)
			{
				for(int r = 1 ; i+r <= dr ; r++)
				{
					for(String s : res[i+r][j])
					{
						res[i][j].add("v" + r + " " + s);
					}
				}	

				for(int c = 1 ; j+c <= dc ; c++)
				{
					for(String s : res[i][j+c])
					{
						res[i][j].add("h" + c + " " + s);
					}
				}

				for(int d = 1 ; i+d <= dr && j+d <= dc ; d++)
				{
					for(String s : res[i+d][j+d])
					{
						res[i][j].add("d" + d + " " + s);
					}
				}
			}
		}
		return res[1][1];
	}

}
