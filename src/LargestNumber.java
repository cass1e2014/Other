import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author cassie9082
 * 
 */
public class LargestNumber {
	/*
	 * 用Arrays.sort(array, Comparactor<..>(){
	 * 	  int compare(String s1, String s2){
	 * 		String ab = s1 + s2;
	 * 		String ba = s2 + s1;
	 * 		return ba.compareTo(s2);
	 * 	  }
	 * });来比较
	 */
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String ab = s1 + s2;
				String ba = s2 + s1;
				return ba.compareTo(ab);
			}
		});

		StringBuffer sb = new StringBuffer();
		for (String str : strs) {
			sb.append(str);
		}

		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();

	}
}
