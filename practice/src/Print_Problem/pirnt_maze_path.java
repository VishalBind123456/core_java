package Print_Problem;

public class pirnt_maze_path {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int sr = 1 , sc = 1 , dr = 3 , dc = 3;
		printPath(sr , sc , dr , dc , "");

	}

	public static void printPath(int sr , int sc , int dr , int dc , String ans)
	{
		if(sr == dr && sc == dc)
		{
			System.out.println(ans);
			return ;
		}

		for(int r = 1; sr+r <= dr ; r++)
		{
			printPath(sr+r , sc , dr , dc , "v" + r + " " + ans);
		}

		for(int c = 1; sc+c <= dc ; c++)
		{
			printPath(sr , sc+c , dr , dc , "h" + c + " " + ans);
		}

		for(int d = 1; sr+d <= dr && sc+d <= dc ; d++)
		{
			printPath(sr+d , sc+d , dr , dc , "d" + d + " " + ans);
		}
	}

}
