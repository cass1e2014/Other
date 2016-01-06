/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example: 
 * 1 -> A 
 * 2 -> B 
 * 3 -> C 
 * ... 
 * 26 -> Z 
 * 27 -> AA 
 * 28 -> AB
 * 
 * @author cassie9082
 * 
 */
public class ExcelSheetColumnTitle {
	/*
	 * Transfer 10-base number to 26-base number
	 */
	public String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			int offset = n % 26;
			char c = (char) (offset + 'A');
			sb.insert(0, c);
			n /= 26;
		}
		return sb.toString();
	}
}
