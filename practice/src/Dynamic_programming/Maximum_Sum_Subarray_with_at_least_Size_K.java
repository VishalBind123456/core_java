package Dynamic_programming;
import java.util.*;
public class Maximum_Sum_Subarray_with_at_least_Size_K {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,-7,6,-5,-4,4,3,3,2,-9,-5,6,1,2,1,1};
		int k = 4;
		solution(arr , k);

		boolean[] b = {false,false,false,false,false,false,false,true};
		getIndex(b);	//--->  just for practice -----
	}

	public static void getIndex(boolean[] arr)
	{
		Stack<Pair> stk = new Stack<Pair>();
		stk.push(new Pair(0 , arr.length-1));
		int idx = 0;

		while(stk.size() > 0)
		{
			Pair p = stk.pop();
			if(p.l == p.r)
			{
				idx = (arr[p.mid] == false) ? -1 : p.mid ;
				break;
			}
			if(arr[p.mid] == false)
			{
				if(arr[p.mid+1] == false)
				{
					stk.push(new Pair(p.mid+1 , p.r));
				}
				else
				{
					idx = p.mid+1;
					break;
				}
			}
			else if(arr[p.mid] == true)
			{
				if(arr[p.mid-1] == true)
				{
					stk.push(new Pair(p.l , p.mid-1));
				}
				else
				{
					idx = p.mid;
					break;
				}
			}

		}
		System.out.println(idx);

	} 

	public static class Pair
	{
		int l;
		int r;
		int mid;
		Pair(int l , int r)
		{
			this.l = l;
			this.r = r;
			this.mid = (l+r)/2;
		}
	}

	public static void solution(int[] arr , int k) 
	{
		int[] max_arr = new int[arr.length];

		int curr_max = Integer.MIN_VALUE;
		int all_max = Integer.MIN_VALUE;

		for(int i = 0 ; i < arr.length ; i++)
		{
			if(curr_max + arr[i] < arr[i])
			{
				curr_max = arr[i];
			}
			else
			{
				curr_max = curr_max + arr[i];
			}
			max_arr[i] = curr_max;
		}

		int box_sum = 0;
		for(int j = 0 ; j < k ; j++)
		{
			box_sum += arr[j];
		}

		all_max = (box_sum > all_max) ? box_sum : all_max ;

		for(int j = k ; j < arr.length ; j++)
		{
			box_sum = box_sum + arr[j] - arr[j-k];
			all_max = (box_sum > all_max) ? box_sum : all_max;
			
			if(box_sum + max_arr[j-k] > all_max)
			{
				all_max = box_sum + max_arr[j-k];
			}
		}


		System.out.println(all_max);

	}



}
