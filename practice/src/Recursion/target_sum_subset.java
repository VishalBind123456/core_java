package Recursion;

import java.util.*;

public class target_sum_subset {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// int [] arr = {1,2,3,4};
		// int sum = Arrays.stream(arr).sum();
		// System.out.println(sum); 

		int[] arr = {10 , 20 , 30 , 40 , 50};
		int target = 70;

		ArrayList<Integer> arr_al = new ArrayList<Integer>();		

		getSubset(arr , target , arr_al ).stream().forEach(element -> { System.out.println(Arrays.toString(element.toArray())); });

	}

	public static ArrayList<ArrayList<Integer>> getSubset(int[] arr , int target , ArrayList<Integer> ans)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if(ans.stream().mapToLong(Integer::longValue).sum() == (long)target)
		{
			res.add(ans);
			return res;
		}

		if(arr.length == 0)
		{
			return res;
		}
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(ans);
		ArrayList<ArrayList<Integer>> without = getSubset(Arrays.copyOfRange(arr , 1 , arr.length) , target  , temp);
		temp.add(arr[0]);
		ArrayList<ArrayList<Integer>> with = getSubset(Arrays.copyOfRange(arr , 1 , arr.length) , target , temp);	

		res.addAll(with);	
		res.addAll(without);

		return res;	
	} 




}
