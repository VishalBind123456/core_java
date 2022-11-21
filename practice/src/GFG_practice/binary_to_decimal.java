package GFG_practice;

public class binary_to_decimal {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String binary = "10001000";
		
		System.out.println(toDecimal(binary));

	}
	
	public static int toDecimal(String binary)
	{
		int decimal = 0;
        int pow = 1;
        
        String arr[] = binary.split("");			System.out.println(arr.length);
        
        for(String s : arr)
        {
            decimal = decimal + (int)(Math.pow(2 , (arr.length - pow)) * Integer.parseInt(s));
            pow++; 
        }
        return decimal;
	}
	
	

}

