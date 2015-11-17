import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author cassie9082
 * 
 */
//字符形式一样
//把相对应的字母存hashmap，过2遍
public class IsomorphicStrings {
	//HashTable : Time O(2N), Space O(26)
    public boolean isIsomorphic(String s, String t) {
    	int n = s.length();
    	int nt = t.length();
    	if(n != nt)		return false;
    	
    	//change s to t
    	Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!map.containsKey(cs)){
                map.put(cs, ct);
            }else if(map.get(cs) != ct){
                return false;
            }
        }
        
        //change t to s
        map.clear();
        for(int i = 0; i < n; i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!map.containsKey(ct)){
                map.put(ct, cs);
            }else if(map.get(ct) != cs){
                return false;
            }
        }
        return true;
    }
}
