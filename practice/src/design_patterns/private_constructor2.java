package design_patterns;

public class private_constructor2
{
	private static private_constructor2 pc2 = null;
	
	private  private_constructor2()
	{
		System.out.println("inside private constructors 2");

	}
	
	public static private_constructor2 getInstance()
	{
		if(pc2 == null)
		{
			pc2 = new private_constructor2();
		}
		return pc2;
	}

}
