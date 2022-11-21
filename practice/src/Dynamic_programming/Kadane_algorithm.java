package Dynamic_programming;

public class Kadane_algorithm {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {4,3,-2,6,-14,7,-1,4,5,7,-10,2,9,-10,-5,-9,6,1};
		solution(arr);
	}

	public static void solution(int[] arr)
	{
		int overall_max = Integer.MIN_VALUE;
		String overall_max_path = ".";
		int current_max = Integer.MIN_VALUE;
		String current_max_path = ".";

		for(int i = 0 ; i < arr.length ; i++)
		{
			current_max_path = (arr[i] > current_max+arr[i]) ? "("+arr[i]+")" : current_max_path+"("+arr[i]+")" ;
			current_max = (arr[i] > current_max+arr[i]) ? arr[i] : current_max+arr[i] ;

			overall_max_path = (current_max > overall_max) ? current_max_path : overall_max_path ; 
			overall_max = (current_max > overall_max) ? current_max : overall_max ; 

		}
		System.out.println(overall_max);
		System.out.println(overall_max_path);
	} 

}
