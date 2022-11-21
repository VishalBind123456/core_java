package Dynamic_programming;
import java.util.*;
public class Paint_houses_Min_Cost {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		HashMap<String , Integer[]> hmap = new HashMap<String , Integer[]>();
		hmap.put("cost_red" , new Integer[]{1,5,3,1});
		hmap.put("cost_blue" , new Integer[]{5,8,2,2});
		hmap.put("cost_green" , new Integer[]{7,4,9,4});

		int no_of_house = 4;

		paintHouse(hmap , no_of_house);

	}

	public static void paintHouse(HashMap<String , Integer[]> hmap , int no_of_house)
	{
		// String[] path = new String[no_of_house + 1];
		// path[0] = "";

		// int[] val = new int[no_of_house + 1];

		int[] r = new int[no_of_house + 1];
		int[] b = new int[no_of_house + 1];
		int[] g = new int[no_of_house + 1];

		for(int i = 1 ; i <= no_of_house ; i++)
		{
			r[i] = Math.min(b[i-1] , g[i-1]) + hmap.get("cost_red")[i-1];
			b[i] = Math.min(r[i-1] , g[i-1]) + hmap.get("cost_blue")[i-1];
			g[i] = Math.min(r[i-1] , b[i-1]) + hmap.get("cost_green")[i-1];

		}

		Integer[] ar = new Integer[]{r[no_of_house] , b[no_of_house] , g[no_of_house]};
		System.out.println(Collections.min(Arrays.asList(ar)));
		// System.out.println(Arrays.asList(ar).stream().mapToLong(e -> e).min());

	} 

}
