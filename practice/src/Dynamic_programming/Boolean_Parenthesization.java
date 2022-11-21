package Dynamic_programming;
import java.util.*;
public class Boolean_Parenthesization {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str1 = "ttft";
		String str2 = "|&^";

		getTotalTrueValue(str1 , str2);

	}

	public static void getTotalTrueValue(String str1 , String str2)
	{
		int[][] dp_true = new int[str1.length()][str1.length()];
		int[][] dp_false = new int[str1.length()][str1.length()];

		for(int gap = 0 ; gap < dp_true.length ; gap++)
		{
			for(int i = 0, j = gap ; j < dp_true.length ;j++,i++)
			{
				if(gap == 0)
				{
					if(str1.charAt(i) == 't')
					{
						dp_true[i][j] = 1;
						dp_false[i][j] =  0;

					}
					else
					{
						dp_true[i][j] = 0;
						dp_false[i][j] = 1;
					}

				}
				else  
				{
					for(int k = i ; k < j ; k++)
					{
						if(str2.charAt(k) == '&')
						{
							dp_true[i][j] += dp_true[i][k] * dp_true[k+1][j];
							dp_false[i][j] += (dp_true[i][k] * dp_false[k+1][j]) + (dp_false[i][k] * dp_true[k+1][j]) 
																				   + (dp_false[i][k] * dp_false[k+1][j]);
						}
						else if(str2.charAt(k) == '|')
						{
							dp_false[i][j] += (dp_false[i][k] * dp_false[k+1][j]);
							dp_true[i][j] += (dp_true[i][k] * dp_false[k+1][j]) + (dp_false[i][k] * dp_true[k+1][j]) 
																				   + (dp_true[i][k] * dp_true[k+1][j]);
						}
						else if(str2.charAt(k) == '^')
						{
							dp_true[i][j] += (dp_true[i][k] * dp_false[k+1][j]) + (dp_false[i][k] * dp_true[k+1][j]); 
							dp_false[i][j] += (dp_true[i][k] * dp_true[k+1][j]) + (dp_false[i][k] * dp_false[k+1][j]); 
						}	
					}

				}

			}
		}

		for(int[] ar :dp_true)
			System.out.println(Arrays.toString(ar));

		System.out.println(dp_true[0][dp_true.length-1]);


	} 

}
