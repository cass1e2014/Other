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
 * Time O(N), Space O(1)
 * 
 * @author cassie9082
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		int result = r.reverse(1534236469);
		System.out.println("Reverse Result ： " + result);
	}

	public int reverse(int x) {
		if(x == Integer.MIN_VALUE){
            return 0;
        }
        int num = Math.abs(x);
        int reversed = 0;
        while(num != 0){
        	//看如果reversed * 10 + num % 10之后是否会大于Integer.MAX_VALUE(把所有的运算移到右边）
            if(reversed > (Integer.MAX_VALUE - num % 10) / 10){
                return 0;
            }
            reversed = reversed * 10 + num % 10;
            num = num / 10;
        }
        return x > 0 ? reversed : -reversed;
	}
}
