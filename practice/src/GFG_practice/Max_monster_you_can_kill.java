package GFG_practice;
import java.util.*;
public class Max_monster_you_can_kill {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] mp = {101 , 100 , 304};
		int[] bp = {100 , 1 , 524};
		int hp = 100;

		System.out.println( getMax(mp , bp , hp) );

	}

	public static int getMax(int[] mp , int[] bp , int hp)
	{
		PriorityQueue<Monster> pq = new PriorityQueue<Monster>(); 
		for(int i = 0 ; i < mp.length ; i++)
		{
			pq.add(new Monster(mp[i] , bp[i]));
		}

		int count = 0;

		while(pq.size() > 0 && hp >= pq.peek().mp)
		{
			hp += pq.peek().bp;
			count++;
			pq.remove();
		}

		return count;


	} 






	public static class Monster implements Comparable<Monster>
	{
		int mp;
		int bp;
		Monster(int mp , int bp)
		{

			this.mp = mp;
			this.bp = bp;
		}

		public int compareTo(Monster o)
		{
			return this.mp - o.mp;
		}
	}

}
