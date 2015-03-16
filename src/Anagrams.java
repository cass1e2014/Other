import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case. 所谓 anagram,
 * 就是两个词所用的字母及其个数都是一样的，但是，字母的位置不一样。比如 abcc 和 cbca 就是 anagram.
 * 两个字符串如果是anagram，它们经过排序后得到的两个字符串一定相等。
 * 
 * 
 */

/*
 * 这道题看所给的字符串数组里面有多少个是同一个变形词变的。这道题同样使用HashMap来帮助存老值和新值，以及帮忙判断是否是变形词。
 * 
 * 首先对每个string转换成char
 * array然后排下序，HashMap里面的key存sort后的词，value存原始的词。然后如果这个排好序的词没在HashMap中出现过
 * ，那么就把这个sorted word和unsortedword put进HashMap里面。如果一个sorted
 * word是在HashMap里面存在过的，说明这个词肯定是个变形词
 * ，除了把这个词加入到返回结果中，还需要把之前第一个存进HashMap里面的value存入result中。
 */

public class Anagrams {

	public static void main(String[] args) {
		String[] strs = new String[]{"abcd" ,"bcad" ,"accd"};
		List<String> results = anagrams(strs);
		for(String result : results){
			System.out.println(result);
		}
	}

	public static List<String> anagrams(String[] strs) {
		if (strs == null) {
			return null;
		}

		List<String> result = new ArrayList<String>();
		if (strs.length == 1) {
			return result;
		}

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String sorted = new String(temp);

			if (!map.containsKey(sorted)) {
				ArrayList<String> templist = new ArrayList<String>();//local的arraylist每次for loop都会开一个新的list
				templist.add(strs[i]);
				map.put(sorted, templist);
			} else {
				map.get(sorted).add(strs[i]);
			}
		}

		for (ArrayList<String> tempArrayList : map.values()) {
			if (tempArrayList.size() > 1) {
				for (String a : tempArrayList) {
					result.add(a);
				}
			}
		}

		return result;
	}
}
