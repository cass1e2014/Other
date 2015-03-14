import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 所谓 anagram, 就是两个词所用的字母及其个数都是一样的，但是，字母的位置不一样。比如 abcc 和 cbca 就是 anagram. 
 * 两个字符串如果是anagram，它们经过排序后得到的两个字符串一定相等。

 * 
 */

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> anagrams(String[] strs) {
		if(strs == null){
			return null;
		}
		
		List<String> result = new ArrayList<String>();
		if(strs.length == 1){
			return result;
		}
		
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < strs.length; i++){
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String sorted = new String(temp);
			
			if(! map.containsKey(sorted)){
				ArrayList<String> templist = new ArrayList<String>();
				templist.add(strs[i]);
				map.put(sorted, templist);
			}else{
				map.get(sorted).add(strs[i]);
			}
		}
		
		
		for(ArrayList<String> tempArrayList : map.values()){
			if(tempArrayList.size() > 1){
				for(String a : tempArrayList){
						result.add(a);
				}
			}
		}
			
		return result;
	}
}




