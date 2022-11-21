package String;

import java.util.*;
import java.util.Arrays.*;

public class remove_prime_numbers_from_arraylist {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Integer[] array = {8,14,9,17,8,6,13,2,42};

		ArrayList<Integer> arrlst = new ArrayList<>();
		Collections.addAll(arrlst , array);
		removePrimeNumbers(arrlst);
	}

	public static void removePrimeNumbers(ArrayList<Integer> arrlst)
	{
		for(int i = 0 ; i < arrlst.size() ; i++)
		{
			int n = (int)arrlst.get(i);
			boolean flag = true;

			for(int j = 2 ; j <= Math.sqrt(n) ; j++)
			{
				if(n%j == 0)
				{
					flag = false;
					break;
				}
			}
			if(flag)
			{
				arrlst.remove(i);
				i--;
			}
		}

		System.out.println(arrlst);
	} 
}
