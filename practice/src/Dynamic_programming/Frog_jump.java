package Dynamic_programming;
import java.util.*;
public class Frog_jump {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {0,1,3,5,6,8,12,17};	//----- if you add 18 here then from will not be rechable ------
		solution(arr);
	}

	public static void solution(int[] arr)
	{
		int dest = arr[arr.length-1];
		int[] stone_position = new int[dest+1];
		for(int i = 0 , j = 0 ; i < stone_position.length ; i++)
		{
			if(i == arr[j])
			{
				stone_position[i] = 1;
				j++; 
			}
		}
		System.out.println(Arrays.toString(stone_position));

		TreeMap<Integer , HashSet<Integer>> hmap = new TreeMap<Integer , HashSet<Integer>>();
		for(int i = 0 ; i < arr.length ; i++)
			hmap.put(arr[i] , new HashSet<Integer>());

		hmap.get(0).add(1);

		for(Map.Entry<Integer , HashSet<Integer>> entry : hmap.entrySet())
		{
			// System.out.println(entry.getKey() + " ----> " + entry.getValue());
			int curr_stone = (int)entry.getKey();
			for(int i : entry.getValue())
			{
				// System.out.println(i);
				if(curr_stone+i <= dest && stone_position[curr_stone+i] == 1)
				{
					hmap.get(curr_stone+i).add(i);
					hmap.get(curr_stone+i).add(i+1);
					if(i-1 > 0)
						hmap.get(curr_stone+i).add(i-1);
				}
			}
		}
		System.out.println(hmap);	

		boolean ans;
		System.out.println(ans = (hmap.get(dest).size() != 0) ? true : false);

	} 

}
