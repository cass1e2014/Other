
public class Reverse {

	public static void main(String[] args) {
		Reverse r = new Reverse();
		int result = r.reverse(123);
		System.out.println("Reverse Result ： " + result);
	}
	
	public int reverse(int x){
		int rst = 0;
		while(x != 0){
			rst = rst * 10 + x % 10;
			x = x / 10;
		}
		return rst;
	}

}
