import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * @author cassie9082
 *
 */
public class WordPattern {
	//与isomorphic strings十分类似
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            char c = pattern.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, s);
            }else if(!map.get(c).equals(s)){
                return false;
            }
        }
        
        Map<String, Character> map2 = new HashMap<String, Character>();
        for(int i = 0; i < pattern.length(); i++){
            String s = words[i];
            char c = pattern.charAt(i);
            if(!map2.containsKey(s)){
                map2.put(s, c);
            }else if(map2.get(s) != c){
                return false;
            }
        }
        return true;
    }
}
