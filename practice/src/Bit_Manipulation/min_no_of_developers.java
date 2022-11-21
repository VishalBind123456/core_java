package Bit_Manipulation;

import java.util.*;

public class min_no_of_developers {

	public static void main(String[] args)
	{

		HashMap<Character , Integer> hmap = new HashMap<Character , Integer>(); 

		String target = "abcde";
		String[] skill = {"ac" , "bd" , "abcd" , "e"};
		int[] skill_val = new int[skill.length];
		int target_val = (1 << target.length()) - 1;

		for(int i = 0 ; i < target.length() ; i++)
		{
			hmap.put(target.charAt(i) , 1 << i);
		}

		for(int i = 0 ; i < skill.length ; i++)
		{
			for(int j = 0 ; j < skill[i].length() ; j++)
			{
				skill_val[i] = (hmap.get(skill[i].charAt(j)) | skill_val[i]) ; 

			}
		}

		// System.out.println(hmap + " <----- hmap ");
		// System.out.println(Arrays.toString(skill_val) + " <----- skill_val ");
		// System.out.println(target_val);

		System.out.println(  printMinDevelopers(skill_val , 0 , 0 , new StringBuilder("") , target_val)  );


	}

	public static StringBuilder printMinDevelopers(int[] skill_val , int idx , int ans_val , StringBuilder ans_path , int target_val)
	{
		
		// System.out.println(ans_val + " " + ans_path);


		if(ans_val == target_val)
		{
			// System.out.println(ans_val + " " + ans_path);
			StringBuilder res = new StringBuilder(ans_path);
			return res;
		}

		if(idx == skill_val.length)
		{
			return null;
		}

		StringBuilder without = printMinDevelopers(skill_val , idx+1 , ans_val , ans_path , target_val);		

		StringBuilder with = printMinDevelopers(skill_val , idx+1, (ans_val | skill_val[idx]) , ans_path.append(idx) , target_val);		
		ans_path.deleteCharAt(ans_path.length()-1);

		if(without == null && with == null)
		{
			return null ;
		}
		else if(without == null )
		{
			return with;
		}
		else if(with == null)
		{
			return without;
		}
		else
		{
			StringBuilder ans = ( without.length() > with.length() ) ? with : without;
			return ans ;

		}


	}























































	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub


		String target = "abcde";
		String[] skill = { "ac" , "bd" , "abcd" , "e" };
		int[] val = new int[skill.length];

		int mask = 1;

		HashMap<Character , Integer> hmap  = new HashMap<Character , Integer>();
		
		for(int i = 0 ; i < target.length() ;  i++)
		{
			hmap.put(target.charAt(i) , mask);
			mask = mask << 1; 
		}	

		int target_val = mask - 1;


		for(int i = 0 ; i < skill.length ;  i++)
		{
			int count = 0;
			for(int j = 0 ; j < skill[i].length() ;  j++)
			{
				count = count + hmap.get(skill[i].charAt(j)) ; 
			} 
			val[i] = count;

		}
		
		System.out.println(getSubsequence(val , skill , target_val , 0 , ""));

	}

	public static ArrayList<String> getSubsequence(int[] val , String[] skill , int target_val , int value , String ans)
	{
		ArrayList<String> res = new ArrayList<String>();

		if( value == target_val )
		{
			res.add(ans);
			return res;
		}

		if( val.length == 0 )
		{
			return res;
		}

		res.addAll( getSubsequence(Arrays.copyOfRange(val , 1 , val.length) , Arrays.copyOfRange(skill , 1 , skill.length) , target_val , (value | val[0]) , ans + skill[0]) );
		res.addAll( getSubsequence(Arrays.copyOfRange(val , 1 , val.length) , Arrays.copyOfRange(skill , 1 , skill.length) , target_val , value , ans) );

		return res;

	}*/ 



}
