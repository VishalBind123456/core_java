package Dynamic_programming;
import java.util.*;
public class Cherry_Pickup {

	public static int max_cherry = 0;
	public static String max_path = "";

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] arr = {
			{1,1,1,0,0},
			{0,0,1,0,0},
			{0,0,1,0,1},
			{1,0,1,0,0},
			{0,0,1,1,1},
		};

		StringBuilder sb = new StringBuilder("S");
		cp1(arr , 0 , 0 , 0 , sb);
		System.out.println(max_cherry);
		System.out.println(max_path);

	}

	public static void cp1(int[][] arr , int row , int col , int csf , StringBuilder sb)
	{
		if(row > arr.length-1 || col > arr[row].length-1)
			return;
		
		if(arr[row][col] == -1)
			return;

		if(row == arr.length-1 && col == arr[row].length-1)
		{
			reverse_cp1(arr , row , col , csf , sb);
			return;
		}

		int cherry = arr[row][col];
		arr[row][col] = 0;

		cp1(arr , row+1 , col , csf+cherry , sb.append("D"));
		sb.deleteCharAt(sb.length()-1);		
		// arr[row][col] = cherry;
		cp1(arr , row , col+1 , csf+cherry , sb.append("R"));		
		sb.deleteCharAt(sb.length()-1);		
		arr[row][col] = cherry;

		return;

	}

	public static void reverse_cp1(int[][] arr , int row , int col , int csf , StringBuilder sb)
	{
		if(row < 0 || col < 0)
			return;

		if(arr[row][col] == -1)
			return;

		if(row == 0 && col == 0)
		{
			if(csf > max_cherry)
			{
				max_cherry = csf;
				max_path = sb.toString();
				// System.out.println(max_path);
				// System.out.println(max_cherry);
			}
			return;
		}

		int cherry = arr[row][col];
		arr[row][col] = 0;

		reverse_cp1(arr , row-1 , col , csf+cherry , sb.append("U"));		
		sb.deleteCharAt(sb.length()-1);		
		// arr[row][col] = cherry;
		reverse_cp1(arr , row , col-1 , csf+cherry , sb.append("L"));		
		sb.deleteCharAt(sb.length()-1);		
		arr[row][col] = cherry;

		return;

	}

}
