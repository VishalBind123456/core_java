package Bit_Manipulation;

public class find_element_that_appears_once_among_thrice 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] elements = {51,57,51,57,63,38,57,63,63,51};
		getElement(elements);


	}

	public static void getElement(int[] elements)
	{
		int tn = Integer.MAX_VALUE;	//---> to make every bit ON ----
		int tnp1 = 0;
		int tnp2 = 0;

		for(int i = 0 ; i < elements.length ; i++)
		{
			int res1 = tn & elements[i];
			int res2 = tnp1 & elements[i];
			int res3 = tnp2 & elements[i];

			tn = tn & (~res1);
			tnp1 = tnp1 | res1;

			tnp1 = tnp1 & (~res2);
			tnp2 = tnp2 | res2;

			tnp2 = tnp2 & (~res3);
			tn = tn | res3;

		}

		System.out.println(tnp1);
	}

}
