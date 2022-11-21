package Recursion;

import java.util.*;

public class flood_fill {

	static String[][] maze = {
		{"0" , "0" , "0" , "0" },
		{"0" , "1" , "1" , "0" },
		{"0" , "0" , "1" , "0" },
		{"1" , "0" , "0" , "0" },
	};

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sr = 0 , sc = 0 , dr = 3 , dc = 3;		
		getPath(sr , sc , dr , dc).stream().forEach(element -> { System.out.println(element); });

	}

	public static ArrayList<String> getPath(int sr , int sc , int dr , int dc)
	{
		ArrayList<String> res = new ArrayList<String>();

		if(sr < 0 || sc < 0 || sr > dr || sc > dc)
		{
			return res;
		}

		if(maze[sr][sc] == "1" || maze[sr][sc] == "true")
		{
			return res;
		}

		if(sr == dr && sc == dc)
		{
			res.add("");
			return res;
		}

		maze[sr][sc] = "true"; // set current position as marked. so that we don't stuck in loop...

	    ArrayList<String> top    = getPath(sr - 1 , sc , dr , dc);
	    ArrayList<String> left   = getPath(sr , sc - 1 , dr , dc);
	    ArrayList<String> bottom = getPath(sr + 1 , sc , dr , dc);
	    ArrayList<String> right  = getPath(sr , sc + 1 , dr , dc);

	    for(String s : top){ 	res.add("t" + s); }
	    for(String s : left){ 	res.add("l" + s); }
	    for(String s : bottom){ res.add("b" + s); }
	    for(String s : right){ 	res.add("r" + s); }

		maze[sr][sc] = "0"; // reset original value before leaving this stack level...
		return res;

	}

}
