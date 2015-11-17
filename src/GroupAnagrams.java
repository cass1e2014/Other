import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
	]
 * 
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 * 
 * @author cassie9082
 * 
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return result;
        }
    
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Arrays.sort(strs);
            for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            ArrayList<String> list = map.get(sorted);
            if(list != null){
                list.add(s);
            }else{
                list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        
        for(ArrayList<String> tmp : map.values()){
            result.add(tmp);
        }
        return result;
    }
}
