/*
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		int result = divide(16, 4);
		System.out.println(result);
	}

	public static int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) {
			return 0;
		}

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		if (b > a) {
			return 0;
		}

		long sum = 0;
		long pow = 0;
		long result = 0;
		while (a >= b) {
			pow = 1;
			sum = b;
			while (sum + sum <= a) {
				sum += sum;
				pow += pow;
			}
			a = a - sum; // a += sum;
			result = result + pow; // result += pow;
		}
		
		//#############################################
		result = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -result: result;
		//#############################################
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
			return Integer.MAX_VALUE;
		}
		
		return (int)result;
	}

}
