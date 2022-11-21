package GFG_practice;

import java.util.Arrays;

public class jumping_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num = 22645;
		System.out.println(jumpingNums(num));

	}

	static long jumpingNums(long X) {
		// code here
		long ans = 0;
		for (long i = X; i > 0; i--) {
			if (jumping_numbers.isJumping(i)) {
				ans = i;
				break;
			}
		}
		return ans;
	}

	static boolean isJumping(long num) {

		String str = String.valueOf(num);
		String arr[] = str.split("");
		Integer arr2[] = Arrays.asList(arr).stream().map(i -> { return Integer.parseInt(i);}).toArray(Integer[]::new);

		
		  if(arr2.length == 1) 
		  { 
			  return true; 
		  } 
		  for(int i = 0 ; i < (arr2.length - 1) ; i++) 
		  { 
			  if(Math.abs(arr2[i] - arr2[i+1]) != 1) 
			  { 
				  return false; 
			  } 
			  
		  }
		 
		return true;
	}

}














