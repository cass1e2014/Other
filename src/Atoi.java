/**
 * String to Integer(atoi)
 * Implement atoi to convert a string to an integer.
 * @author cassie9082
 *
 */
public class Atoi {

	public static void main(String[] args) {
		Atoi a = new Atoi();
		int result = a.atoi("-1234");
		System.out.println("result is ： " + result);
	}
	
	public int atoi(String str){
		if(str == null || str.length() == 0){
			return 0;
		}
		
		str = str.trim();//对string做trim
		int sign = 1;
		int index = 0;
		
		//数字是正的还是负的？
		if(str.charAt(index) == '+'){
			index ++;
		}else if(str.charAt(index) == '-'){
			sign = -1;
			index ++;
		}
		
		long num = 0;//先用long来放，数字可能比int大
		for(; index < str.length(); index ++){
			if(str.charAt(index) < '0' || str.charAt(index) > '9'){
				break;
			}
			num = num * 10 + str.charAt(index) - '0';//把每一个character变成数字，再一个个通过*10从前往后加上去
		}
		
		if(num * sign > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		
		if(num * sign < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		
		return (int)num * sign;
		
	}

}
