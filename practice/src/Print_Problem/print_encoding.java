package Print_Problem;

public class print_encoding {

	static String[] code = {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z"};

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int x = '8';
		System.out.println( x - '0' );
		printEncoding("993" , "");
	}

	public static void printEncoding(String ques , String ans)
	{
		if(ques.length() == 0)
		{
			System.out.println(ans);
			return ;
		}

		for(int i = 1 ; i <= (String.valueOf(code.length).length()) &&  i <= ques.length() && Integer.parseInt(ques.substring(0,i)) < code.length ; i++ )
		{
			if(Integer.parseInt(ques.substring(0,i)) == 0)
			{
				return ;
			}
			String str = code[Integer.parseInt(ques.substring(0,i)) - 1];
			printEncoding(ques.substring(i) , ans + str );
		}
	}



}
