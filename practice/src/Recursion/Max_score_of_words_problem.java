package Recursion;

import java.util.*;

public class Max_score_of_words_problem {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int idx = 0;
		String[] words = {"dog" , "cat" , "dad" , "good"};
		int[] farr =  {1,1,1,3,0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		// System.out.println(farr.length);
		int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		int max = getMaxScore(words , farr , score ,idx);
		System.out.println(max);

	}

	public static int getMaxScore(String[] words , int[] farr , int[] score , int idx)
	{
		if(idx >= words.length)
		{
			return 0;
		}

		int no_score = 0 + getMaxScore(words , farr , score , idx+1);	//-------> current word not included ----------

		//-------> Now we have to include the word ------------
		int yes_score = 0;
		boolean flag = true;
		for(int i = 0 ; i < words[idx].length() ; i++)
		{
			char ch = words[idx].charAt(i);
			farr[ch - 'a']--;
			flag = (farr[ch - 'a'] < 0) ? false : flag;

			yes_score = yes_score + score[ch - 'a'];
		} 

		if(flag)
		{
			yes_score = yes_score + getMaxScore(words , farr , score , idx+1);	
		}
		else  
		{
			for(int i = 0 ; i < words[idx].length() ; i++)
			{
				char ch = words[idx].charAt(i);
				farr[ch - 'a']++;
			} 
			// yes_score = 0;  //<-------------------------------why this is here. .......

		}

		return Math.max(no_score , yes_score);

	}



}
