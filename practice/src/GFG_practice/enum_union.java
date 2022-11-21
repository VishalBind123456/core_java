package GFG_practice;

import java.util.*;
import java.io.*;

public class enum_union
{
	
	public static int data = 777;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(data);
		enum days {
			monday,tuesday,wednesday,thursday,friday,saturday,sunday
		};

		days d1 = days.sunday;
//		String str1 = "sunday";
//		System.out.println(d1.equals(str1));
		System.out.println(d1);
		
		enum_union eu = new enum_union();
		enum_union.test t1 = eu.new test();
		System.out.println(t1.data2);
	}
	
	public class test
	{
		public static int data2 = 100;
		public int idx;
		test()
		{
			this.idx = 55;
		}

	}

}

