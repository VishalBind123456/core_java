package Dynamic_programming;
import java.util.*;
public class two_key_keyboard {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ch = "A";
		int n = 18;
		printMinMoves(ch , n);

	}

	public static void printMinMoves(String ch , int n)
	{
		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair('c' , "c" , ch , ch));
		dq.addLast(new Pair('p' , "p" , ch , ""));
		
		boolean flag = false;
		int min_length = 0;

		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			if(p.psf.length() > n)
			{
				continue;
			}
			if(p.ans_str.length() == n && flag == false)
			{
				flag = true;
				min_length = p.psf.length();
			}
			if(flag == true && p.psf.length() == min_length && p.ans_str.length() == n)
			{
				System.out.println(p);
				continue;
			}

			if(p.prev_opr == 'c')
			{
				dq.addLast(new Pair('p' , p.psf + "p" , p.ans_str + p.copy , p.copy));
				dq.addLast(new Pair('c' , p.psf + "c" , p.ans_str          , p.copy));
			}
			if(p.prev_opr == 'p')
			{
				dq.addLast(new Pair('p' , p.psf + "p" , p.ans_str + p.copy , p.copy));
				dq.addLast(new Pair('c' , p.psf + "c" , p.ans_str    	  , p.ans_str));
			}
		}


	} 

	public static class Pair
	{
		char prev_opr;
		String psf;
		String ans_str;
		String copy;

		Pair(char prev_opr , String psf , String ans_str , String copy)
		{
			this.prev_opr = prev_opr;
			this.psf =  psf;	
			this.ans_str =  ans_str;	
			this.copy =  copy;	
		}

		public String toString()
		{
			return this.prev_opr + " " + this.psf + " " + this.ans_str + " " + this.copy;
		}

	}

}
