import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class UniqueWordAbbreviation {
	Map<String, HashSet> map = new HashMap<String, HashSet>();
	public UniqueWordAbbreviation(String[] dictionary){
		for(int i = 0; i < dictionary.length; i++){
			String s = dictionary[i];
			if(s.length() > 2){
				s = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
			}
			if(map.containsKey(s)){
				map.get(s).add(dictionary[i]);
			}else{
				HashSet<String> set = new HashSet<String>();
				set.add(dictionary[i]);
				map.put(s, set);
			}
		}
	}
	
	public boolean isUnique(String word){
		String s = word;
		if(s.length() > 2){
			s = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
		}
		if(!map.containsKey(s)){
			return true;
		}else{
			if(map.get(s).contains(word) && map.get(s).size() < 1){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] dictionary = {"deer","door","cake","card"};
		UniqueWordAbbreviation uwa = new UniqueWordAbbreviation(dictionary);
		System.out.println(uwa.isUnique("dear"));
		System.out.println(uwa.isUnique("cart"));
		System.out.println(uwa.isUnique("cane"));
		System.out.println(uwa.isUnique("make"));
	}
}

//Your ValidWordAbbr object will be instantiated and called as such:  
//UniqueWordAbbreviation uwa = new UniqueWordAbbreviation(dictionary);
//uwa.isUnique("Word");  
//uwa.isUnique("anotherWord");
