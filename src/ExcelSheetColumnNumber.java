/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * 
 * @author cassie9082
 *
 */
public class ExcelSheetColumnNumber {
    /*
    This question is an reverse question of the previous one. Let's still an transforming 26-base number to a 10-base number. Before we solve this question, let's consider how to convert a string to a number. For e.g. "123" -> 123, we start from the most significant digit,
        1 + result * 10 = 1
        2 + rssult * 10 = 12
        3 + result * 10 = 123

    So the solution here is the same, except for replacing the 10 by 26. Also noted that we need to add number by 1 each time since this question is index-1 started. 

    */
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
