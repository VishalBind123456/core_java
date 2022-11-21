package Stack;
import java.util.*;
public class duplicate_brackets 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String expr = "(a+b)+((c+d)))";
//		String expr = "((a+b)+(c+d))";
		boolean bool = duplicateBrackets(expr);
		System.out.println("duplicateBrackets -> " + bool);
		boolean bool2 = balancedBrackets(expr);
		System.out.println("balancedBrackets -> " + bool2);
	}

	public static boolean balancedBrackets(String expr)
	{
		Stack<Character> stk = new Stack<>();
		int b1 , b2 , b3;
		b1 = b2 = b3 = 0;
		for(int i = 0 ; i < expr.length() ; i++)
		{
			char ch = expr.charAt(i);
			switch(ch)
			{
				case '(': 
					b1++; 
					break; 
				case '{': 
					b2++; 
					break;
				case '[': 
					b3++; 
					break;
				case ')': 
					b1--; 
					break; 
				case '}': 
					b2--; 
					break;
				case ']': 
					b3--; 
					break;
				default:
					//-----nothing for default; 
			}
		}
		if(b1 != 0 || b2 != 0 || b3 != 0)
		{
			return false;
		}
		try
		{
			for(int i = 0 ; i < expr.length() ; i++)
			{
				char ch = expr.charAt(i);
				if(ch == ')')
				{
					while(stk.peek() != '(')
					{
						stk.pop();
					}
					stk.pop();
				}
				else if(ch == '}')
				{
					while(stk.peek() != '{')
					{
						stk.pop();
					}
					stk.pop();
				}
				else if(ch == ']')
				{
					while(stk.peek() != '[')
					{
						stk.pop();
					}	
					stk.pop();
				}
				else
				{
					stk.push(ch);
				}
			}
			if(stk.size() > 0) return false;
		}
		catch(EmptyStackException e)
		{
			return false;
		}
		return true;
	}

	public static boolean duplicateBrackets(String expr)
	{
		Stack<Character> stk = new Stack<>();
		for(int i = 0 ; i < expr.length() ; i++){
			if(expr.charAt(i) == ')'){
				if(stk.peek() == '('){
					return false;
				}
				while(stk.peek() != '('){
					stk.pop();
				}
				stk.pop();	//----> pop last '(' ...
			}
			else{
				stk.push(expr.charAt(i));
			}
		}
		return true;
	}


}
