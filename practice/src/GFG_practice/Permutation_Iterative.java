package GFG_practice;
import java.util.*;
public class Permutation_Iterative {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		String str = "abcd";
		int n = str.length();
		int fact = factorial(n);
		for(int i = 0 ; i < fact ; i++){
			int temp = i;
			StringBuilder sb = new StringBuilder(str);
			StringBuilder sb2 = new StringBuilder("");
			for(int div = n ; div >= 1 ; div--){
				int q = temp/div;
				int r = temp%div;
				temp = q;
				sb2.append(sb.charAt(r));
				sb.deleteCharAt(r);
			}
			set.add(sb2.toString());
		}
		System.out.println(set);

	}

	public static int factorial(int n)
	{
		int ans = 1;
		while(n >= 1){
			ans *= n;
			n--;
		}
		// System.out.println(ans);
		return ans;
	} 

}
