/**
 * String to Integer(atoi) Implement atoi to convert a string to an integer.
 * 
 * @author cassie9082
 * 
 */
public class Atoi {

	public static void main(String[] args) {
		Atoi a = new Atoi();
		int result = a.atoi("9223372036854775809");
		System.out.println("result is ： " + result);
	}

	public int atoi(String str) {
		 if(str == null || str.length() == 0){
	            return 0;
	        }
	        
	        str = str.trim();
	        int sign = 1;
	        int index = 0;
	        if(str.charAt(0) == '-'){
	            sign = -1;
	            index ++;
	        }else if(str.charAt(0) == '+'){
	            index ++;
	        }
	        
	        long num = 0;
	        for(; index < str.length(); index ++){
	            if(str.charAt(index) < '0' || str.charAt(index) > '9'){
					break;
				}
	            num = num * 10 + str.charAt(index) - '0';
	            if(num > Integer.MAX_VALUE){
	                break;
	            }
	            if(num < Integer.MIN_VALUE){
	                break;
	            }
	        }
	        
	        if(num *  sign > Integer.MAX_VALUE){
	            return Integer.MAX_VALUE;
	        }
	        if(num * sign < Integer.MIN_VALUE){
	            return Integer.MIN_VALUE;
	        }
	        return (int)num * sign;

	}

}
