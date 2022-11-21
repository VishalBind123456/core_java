package GFG_practice;

import java.util.*;

public class continuous_subarray_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1 , 2 , 3 , 7 , 5};
		int sum = 12;
		
		System.out.print(Arrays.toString(subarraySum( arr , arr.length , sum).toArray()));

	}
	
	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
		ArrayList<Integer> al = new ArrayList<Integer>(); 
        al.add(0 , -1);
        int sum = 0;
        
        outerloop:
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = i ; j < arr.length ; j++)
            {
                sum = sum + arr[j];
                if(sum == s)
                {
                    al.set(0 , i+1);
                    al.add(1 , j+1);
                    break  outerloop;
                    
                }
                if(sum > s)
                {
                    break;
                }
                
            }
            sum = 0;
        }
        
        return al;
    }
	
}





