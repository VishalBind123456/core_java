package Print_Problem;

import java.util.Arrays;

public class keypad_combination {
	
	static String[] keys = {"abc" , "def" , "ghi" , "jkl" , "mno" , "pqr" , "st" , "uv" , "wx" , "yz" };

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		printCombination("555" , "");
	}
	
	public static void printCombination(String key , String ans)
	{
		//String ques = key.substring(0,0);
		
		// System.out.println(key.substring(0,1));

		if(key.length() == 0 )
		{
			System.out.println(ans);
			return;
		}
		
		String[] arr = keys[Integer.parseInt(key.substring(0,1))].split("");
		
		String ques = key.substring(1);
		for(String s : arr)
		{
			printCombination(ques , s + ans);
		}
		
	}

}
