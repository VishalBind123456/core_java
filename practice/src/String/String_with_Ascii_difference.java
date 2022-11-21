package String;

public class String_with_Ascii_difference {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("abdgca");
		
		System.out.println( printWithAsciiDiff(sb) );




	}

	public static StringBuilder printWithAsciiDiff(StringBuilder str)
	{	
		StringBuilder ans = new StringBuilder("");
		if(str.length() >= 2 )
		{
			ans.append(str.charAt(0));
			for(int i = 1 ; i < str.length() ; i++)
			{
				char curr = str.charAt(i);
				char prev = str.charAt(i-1);

				ans.append((curr - prev) + "");
				ans.append(curr);

			}

		}
		return ans;

	} 

}
