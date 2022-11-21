package GFG_practice;
import java.util.*;
public class card_shift_game {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] arr = {"black" , "grey" , "brown" , "red" , "pink"};
		int position = 3;
		String str = "black";

		System.out.println( getMinShifts(arr , str , position) );

	}

	public static int getMinShifts(String[] arr , String str , int position)
	{
		List<String> list = new ArrayList<String>();

		for(int i = 0 ; i < arr.length ; i++)
		{
			list.add(arr[i]);
		}

		int forward = Math.abs(position - list.indexOf(str));
		int reverse = list.size() - Math.abs(position - list.indexOf(str));
		
		return Math.min(forward , reverse);


	} 

}
