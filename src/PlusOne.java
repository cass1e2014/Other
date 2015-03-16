import java.util.Arrays;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number. 
 * The digits are stored such that the most significant digit is at the head of the list.
 * [1,9] + 1 = [2,0]
 * [9,9] + 1 = [1,0,0]
 */

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 9, 9 };
		System.out.println(Arrays.toString(plusOne(digits)));
	}

	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int carry = 1;
		int p = digits.length - 1;// 把p指向array的最后一位，从最后一位开始往左移
		while (p >= 0) {
			int sum = digits[p] + carry;
			carry = sum / 10;
			digits[p] = sum % 10;
			p--;
		}
		if (carry != 0) {
			int[] newArray = new int[digits.length + 1];
			newArray[0] = carry;
			System.arraycopy(digits, 0, newArray, 1, digits.length);
			return newArray;
		}
		return digits;//如果没有需要一个新的数位放carry，只要返回新的digits[]就可以啦！
	}
}
