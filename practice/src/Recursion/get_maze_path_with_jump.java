package Recursion;

import java.util.*;

public class get_maze_path_with_jump {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sr = 1 , sc = 1 , dr = 8 , dc = 8;
		
		long startTime = System.nanoTime();
		ArrayList<String> arr_al = getPath(sr , sc , dr , dc );
		long endTime = System.nanoTime();
		
		System.out.println("Execution time in milliseconds.");
		System.out.println( (float)(endTime - startTime)/1000000);
		
		//arr_al.stream().forEach(element -> { System.out.println(element); });
	}
	
	public static ArrayList<String> getPath(int sr , int sc , int dr , int dc )
	{
		ArrayList<String> res = new ArrayList<String>();
		
		if(sr == dr && sc == dc)
		{
			res.add("");
			return res;
		}
		
		if(sr > dr || sc > dc)
		{
			return res;
		}
		
		ArrayList<String> hpath = new ArrayList<String>();
		for(int i = 1 ; i <= dr ; i++)
		{
			for(String s : getPath(sr + i , sc , dr , dc ) )
			{
				hpath.add("v" + i + " " + s);
			}
		}
		
		ArrayList<String> vpath = new ArrayList<String>();
		for(int j = 1 ; j <= dc ; j++)
		{
			for(String s : getPath(sr , sc + j , dr , dc ) )
			{
				vpath.add("h" + j + " " + s);
			}
		}
		
		ArrayList<String> dpath = new ArrayList<String>();
		for(int i = 1 , j = 1 ; i <= dr && j <= dc ; i++ , j++)
		{
			for(String s : getPath(sr + i , sc + j  , dr , dc ) )
			{
				dpath.add("d" + i + " " + s);
			}
		}
		
		res.addAll(hpath);
		res.addAll(vpath);
		res.addAll(dpath);
		
		return res;
	}

}
