package Dynamic_programming;
import java.util.*;
public class Matrix_chain_multiplication {

	public static void main(String[] args) throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		// int[] arr = {10,30,5,60};
		// int[] arr = {3,5,7,9};
		int[] arr = {40,20,30,10,30};

		printMinMultiplication(arr);

	}

	public static void printMinMultiplication(int[] arr)
	{
		int[][] board = new int[arr.length-1][arr.length-1];

		for(int gap = 0 ; gap < board.length ; gap++)
		{
			for(int i = 0 , j = gap ; j < board.length ; j++ , i++)
			{
				if(gap == 0)
				{
					board[i][j] = 0;
				}
				else if(gap == 1)
				{
					board[i][j] = arr[i] * arr[j+1] * arr[i+1];
				}
				else if(gap > 1)
				{
					int min = Integer.MAX_VALUE;
					for(int k = i ; k < j ; k++)
					{
						int lc = board[i][k];
						int rc = board[k+1][j];
						int mc = arr[i] * arr[j+1] * arr[k+1];
						int count = lc + rc + mc;
						if(count < min)
							min = count;
					}

					board[i][j] = min;
				}
			}
		}

		System.out.println(board[0][board.length-1]);

	}

	/*public static void printMinMultiplication(int[] arr) throws CloneNotSupportedException
	{
		Matrix[] m_arr = new Matrix[arr.length-1];
		for(int i = 0 ; i < m_arr.length ; i++)
			m_arr[i] = new Matrix(arr[i] , arr[i+1] , 0);

		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		for(int i = 0 ; i < m_arr.length-1 ; i++)
		{
			Pair p = new Pair(i , i+1);
			dq.addLast(p);
			Matrix[] temp_m_arr = new Matrix[m_arr.length];
			for(int j = 0 ; j < m_arr.length ; j++)
				temp_m_arr[j] = m_arr[j].clone();
			p.m_arr = temp_m_arr;
			System.out.println(p);	//----------------------------

		}

		int min = Integer.MAX_VALUE;
		while(dq.size() > 0)
		{
			Pair p = dq.pollFirst();
			
			int count = p.m_arr[p.idx].count + p.m_arr[p.right_idx].count + (p.m_arr[p.idx].row * p.m_arr[p.right_idx].col * p.m_arr[p.idx].col);
			Matrix m = new Matrix(p.m_arr[p.idx].row , p.m_arr[p.right_idx].col , count);

			p.m_arr[p.idx] = m;
			p.m_arr[p.right_idx] = null;

			System.out.println(p);	//----------------------------
			
			int prev_idx = 0;
			boolean flag = true;
			for(int i = 1 ; i < p.m_arr.length ; i++)
			{
				if(p.m_arr[i] != null)
				{
					flag = false;
					Pair new_p = new Pair(prev_idx , i);
					dq.addLast(new_p);
					Matrix[] temp_m_arr = new Matrix[p.m_arr.length];
					for(int j = 0 ; j < p.m_arr.length ; j++)
						temp_m_arr[j] = (p.m_arr[j] == null) ? null : p.m_arr[j].clone();
					new_p.m_arr = temp_m_arr;
					prev_idx = i;
				}
			}
			if(flag && p.m_arr[0].count < min)
				min = p.m_arr[0].count;
		}

		System.out.println(min);

	}

	public static class Pair implements Cloneable
	{
		int idx;
		int right_idx;
		Matrix[] m_arr;
		Pair(int idx,int right_idx)
		{
			this.idx =       idx;
			this.right_idx = right_idx;
		}

		public String toString()
		{
			return this.idx + " " + this.right_idx + " ---> " + Arrays.toString(this.m_arr);
		}

	}

	public static class Matrix implements Cloneable
	{
		int row;
		int col;
		int count;
		Matrix(int row,int col,int count)
		{
			this.row =   row;
			this.col =   col;
			this.count = count;
		}

		public Matrix clone() throws CloneNotSupportedException
		{
			Matrix m = (Matrix)super.clone();
			return m;
		}

		public String toString()
		{
			return this.row + " " + this.col + " " + this.count;
		}

	}*/

}
