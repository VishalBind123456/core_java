package Bit_Manipulation;

import java.util.*;

public class Number_of_valid_words_for_each_puzzle {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] puzzle = {"aboveyz" , "abrodyz" , "absolute" , "absoryz" , "actresz" , "gaswxyz"};
		String[] word = {"aaaa" , "asas" , "able" , "ability" , "actt" , "actor" , "access"};

		int[] word_values = new int[word.length];
		int[] puzzle_values = new int[puzzle.length];

		HashMap<Character , Integer> hmap = new HashMap<Character , Integer>();

		// Character ch = new Character((char)97);
		// System.out.println(ch);

		for(int i = 0 ; i < 26 ; i++)
		{
			hmap.put((char)(97+i) , (1 << i));
		}

		// System.out.println(hmap);

		for(int i = 0 ; i < puzzle.length ; i++)
		{
			for(int j = 0 ; j < puzzle[i].length() ; j++)
			{
				puzzle_values[i] = puzzle_values[i] | hmap.get(puzzle[i].charAt(j));
			}
		}

		for(int i = 0 ; i < word.length ; i++)
		{
			for(int j = 0 ; j < word[i].length() ; j++)
			{
				word_values[i] = word_values[i] | hmap.get(word[i].charAt(j));
			}
		}

		printValidWords(word_values , puzzle_values);

	}

	public static void printValidWords(int[] word_values , int[] puzzle_values)
	{

		String[] puzzle_ans = new String[puzzle_values.length];

		for(int i = 0 ; i < puzzle_values.length ; i++)
		{
			for(int j = 0 ; j < word_values.length ; j++)
			{
				if((puzzle_values[i] & word_values[j]) == word_values[j])
				{
					puzzle_ans[i] = (puzzle_ans[i] == null) ? j + " " : puzzle_ans[i] + j + " ";
				}

			}
		}				
	
		System.out.println(Arrays.toString(puzzle_ans));

	}




}
