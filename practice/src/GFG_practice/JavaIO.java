package GFG_practice;
import java.io.*;

public class JavaIO 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			String path = "/home/vishal/All_Practice/test.txt";
			boolean bool = false; //---> append to data OR replace the data.
			
//			long s = System.nanoTime();
//			FileOutputStream fout = new FileOutputStream(path , bool);
//			BufferedOutputStream bout = new BufferedOutputStream(fout);
//			String data = "hello how are you";
//			byte[] b = data.getBytes();
//			// fout.write(b);
//			bout.write(b);
//			bout.flush();
//			
//			
//			FileReader fin = new FileReader(path);
//			BufferedReader bin = new BufferedReader(fin);
//			while(true)
//			{
//				// int i = fin.read();
//				int i = bin.read();
//				if(i == -1)
//					break;
//				System.out.print((char)i);
//			}
//			long e = System.nanoTime();
//			System.out.print("\n  <-- " + (e-s) + " nano sec ");
			
			//--------------------------------------------------------------------------
			FileWriter fw = new FileWriter(path , bool);
			BufferedWriter bw = new BufferedWriter(fw);
			String data2 = "hello how are you";
			char[] c = data2.toCharArray();
			fw.write(c);
			fw.close();
//			bw.write(c);
//			bw.flush();
			
			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while(true)
			{
				int i = fr.read();
//				int i = br.read();
				if(i == -1)
					break;
				System.out.print((char)i);
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}

}
