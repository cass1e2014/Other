/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @author cassie9082
 * 
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		int[] count = new int[256];
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i)] ++;
		}
		for(int i = 0; i < t.length(); i++){
			if(count[t.charAt(i)] == 0) return false;
			count[t.charAt(i)]--;
		}
		return true;
	}
}
