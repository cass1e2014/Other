/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Here are some good questions to ask before coding. Bonus points for you if
 * you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * 
 * @author cassie9082
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		int result = r.reverse(123);
		System.out.println("Reverse Result ： " + result);
	}

	public int reverse(int x) {
		int reversed = 0;
		while (x != 0) {
			reversed = reversed * 10 + x % 10;
			x = x / 10;
		}
		return reversed;
	}

}
