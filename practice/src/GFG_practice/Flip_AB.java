package GFG_practice;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.lang.StringBuilder;
import java.lang.Thread;
public class Flip_AB {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_no = sc.nextInt();
						sc.nextLine();	//------> to move curser to next line ----
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		String[][] grid_1 = new String[n][m];
		for(int i = 0 ; i < n ; i++)
			grid_1[i] = sc.nextLine().split("");

						sc.nextLine();	//------> to move curser to next line ----
		String[][] grid_2 = new String[n][m];
		for(int i = 0 ; i < n ; i++)
			grid_2[i] = sc.nextLine().split("");

		
		System.out.println();
		for(String[] ar : grid_1)
			System.out.println(Arrays.toString(ar));
		for(String[] ar : grid_2)
			System.out.println(Arrays.toString(ar));
		
		sc.close();

		printPath(n , m , grid_1 , grid_2);

	}

	public static void printPath(int n , int m , String[][] grid_1 , String[][] grid_2) throws InterruptedException
	{
		StringBuilder sb1 = new StringBuilder("");
		StringBuilder sb2 = new StringBuilder("");
		boolean[] row_visited = new boolean[n];
		boolean[] col_visited = new boolean[m];
		Arrays.fill(row_visited , false);
		Arrays.fill(col_visited , false);
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < m ; j++) 
			{
				sb1.append(grid_1[i][j]); 
				sb2.append(grid_2[i][j]);
			}
		} 
			// System.out.println(sb1);	//--------------------------

		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		dq.addLast(new Pair(sb1.toString() , sb2.toString() , row_visited , col_visited , ""));

		while(dq.size() > 0)
		{
			try
			{

				Pair p = (Pair)dq.peekFirst().clone();
				Thread.sleep(1000);
				System.out.println(p);	//--------------------------djdjdjjjdjddj--------
				if(p.sb1.toString().equals(p.sb2.toString()))
				{
					System.out.println(p);
					break;
				}

				for(int i = 0 ; i < n ; i++)	//-----> row fixed 
				{
					if(p.row_visited[i] == false)
					{
						p.row_visited[i] = true;
						dq.addLast(new Pair(p.sb1.toString() , p.sb2.toString() , Arrays.copyOfRange(p.row_visited , 0 , n) , Arrays.copyOfRange(p.col_visited , 0 , m) , p.psf.toString())); 
						for(int j = 0 ; j < m ; j++)	//-----> column variable
						{
							if(p.sb1.charAt(i*n + j) == 'A')
								p.sb1.setCharAt(i*n + j , 'B');
							else
								p.sb1.setCharAt(i*n + j , 'A');
						}
						dq.addLast(new Pair(p.sb1.toString() , p.sb2.toString() , Arrays.copyOfRange(p.row_visited , 0 , n) , Arrays.copyOfRange(p.col_visited , 0 , m) , p.psf.toString() + "r" + i + " ")); 
						break;
					}
				}
				// System.out.println(dq.peekLast());	//--------------------------jsjskskskks------------

				p = dq.pollFirst();
				// System.out.println(p);	//--------------------------jsjskskskks------------
				for(int j = 0 ; j < m ; j++)	//-----> column fixed 
				{
					if(p.col_visited[j] == false)
					{
						p.col_visited[j] = true;
						dq.addLast(new Pair(p.sb1.toString() , p.sb2.toString() , Arrays.copyOfRange(p.row_visited , 0 , n) , Arrays.copyOfRange(p.col_visited , 0 , m) , p.psf.toString())); 
						for(int i = 0 ; i < n ; i++)	//-----> row variable
						{
							if(p.sb1.charAt(i*m + j) == 'A')
								p.sb1.setCharAt(i*m + j , 'B');
							else
								p.sb1.setCharAt(i*m + j , 'A');

						}
						dq.addLast(new Pair(p.sb1.toString() , p.sb2.toString() , Arrays.copyOfRange(p.row_visited , 0 , n) , Arrays.copyOfRange(p.col_visited , 0 , m) , p.psf.toString() + "c" + j + " ")); 
						break;
					}
				}

				// System.out.println(dq.peekLast());	//--------------------------jsjskskskks------------
				// break; //---------------------------------------------------------jsjjsjsjsj-----
			}
			catch(CloneNotSupportedException e)
			{
				System.out.println("CloneNotSupportedException....!!!");
			}

		}



	} 

	public static class Pair implements Cloneable
	{
		StringBuilder sb1 ;
		StringBuilder sb2 ;
		boolean[] row_visited;
		boolean[] col_visited;
		StringBuilder psf ;
		Pair(String s1 ,String s2 , boolean[] row_visited , boolean[] col_visited , String psf)
		{
			this.sb1 = new StringBuilder(s1);
			this.sb2 = new StringBuilder(s2);
			this.row_visited = row_visited;
			this.col_visited = col_visited;
			this.psf = new StringBuilder(psf);
		}

		public Object clone() throws CloneNotSupportedException
		{
			Pair p = (Pair)super.clone();
			p.sb1 = new StringBuilder(this.sb1.toString());
			p.sb2 = new StringBuilder(this.sb2.toString());
			p.row_visited = Arrays.copyOfRange(this.row_visited , 0 , this.row_visited.length);
			p.col_visited = Arrays.copyOfRange(this.col_visited , 0 , this.col_visited.length);
			p.psf = new StringBuilder(this.psf.toString());
			return p;

		}

		public String toString()
		{
			return this.sb1 + "\n" + this.sb2 + "\n" + Arrays.toString(row_visited) + "\n" + Arrays.toString(col_visited) + "\n" + this.psf; 
		}


	}


}

/*
1
3 4
AAAB
AAAB
BAAA

BABA
ABAB
BBAA
*/