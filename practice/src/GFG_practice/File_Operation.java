package GFG_practice;

import java.util.*;
import java.io.*;

public class File_Operation 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File file = new File("/home/vishal/Desktop/file_practice.txt");
		try{
			if(!file.exists()){
				file.createNewFile();
			}
			// System.out.println(file.exists());
			FileWriter fwriter = new FileWriter(file.getAbsolutePath() , true); //---> true means append...
			fwriter.write("hello from java 2 \n");
			fwriter.close();
			
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {

					
		}
	}

}
