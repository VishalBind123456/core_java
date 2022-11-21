package String;

public class print_all_substring {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "Emil peed deep lime";
		String[] arr = str.split(" ");
		str = String.join("" , arr).toLowerCase();
		printAllSubstring(str);

		printAllPalindromicSubstring(str);
	}

	public static void printAllSubstring(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			for(int j = i+1 ; j <= str.length() ; j++)
			{
				System.out.print(str.substring(i , j) + " ");
			}
			System.out.println();

		}
	} 

	public static void printAllPalindromicSubstring(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			for(int j = i+1 ; j <= str.length() ; j++)
			{
				boolean flag = true; 
				for(int m = i , n = j-1 ; m <= n  ; m++ , n--)
				{
					if(str.charAt(m) != str.charAt(n))
					{
						flag = false;
						break;
					}
				}
				if(flag)
				{
					System.out.print(str.substring(i , j) + " ");
				}

			}
			System.out.println();

		}


	}



}
