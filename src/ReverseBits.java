/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 * n & 1：取最后一位的值；val << 1：进位；|：加上末尾值，注意用 + 会出错，由符号位引起，区别 -1 + 1 = 0 和 -1 | 1 = -1。
 * 
 * Time O(n) space O(1)
 * 
 * @author cassie9082
 * 
 */
public class ReverseBits {
	public int reverseBits(int n) {
        int reversed = 0;
        for(int i = 0; i < 32; i++){
            reversed = (reversed << 1) | (n & 1); //(n & 1)--> get last degit
            n = n >> 1;
        }
        return reversed;
    }
}
