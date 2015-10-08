/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author cassie9082
 * 
 */
public class PalindromeNumber {
	
	//"16461"
	public static void main(String[] args) {
		boolean result = isPalindrome(321123);
		System.out.println(result);
	}

	public static boolean isPalindrome(int x) {
		 if(x == 0){
	            return true;
	        }
	        
	        int temp = x;
	        int reversed = 0;
	        while(temp > 0){
	             reversed = reversed * 10 + temp % 10;
	             temp = temp / 10;
	        }
	        return reversed == x;
	}
}
