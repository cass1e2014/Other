/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 
 * （杨辉三角）
 */

/*
 * 既然讲到了Pascal‘s Triangle，即杨辉三角。那么就先去Wikipedia上面复习一下杨辉三角吧：
 * ”杨辉三角形，又称賈憲三角形、帕斯卡三角形、海亚姆三角形，是二项式係數在的一种写法，形似三角形。
 * 杨辉三角形第n层（顶层称第0层，第1行，第n层即第n+1行，此处n为包含0在内的自然数）正好对应于二项式\left(a+b\right)^{n}展开的系数。例如第二层1 2 1是幂指数为2的二项式\left(a+b\right)^{2}展开形式a^{2}+2ab+b^{2}的系数。
 * 杨辉三角的性质：
 * 楊輝三角以正整數構成，數字左右对称，每行由1开始逐渐变大，然后变小，回到1。
 * 第n行的数字个数为n个。
 * 第n行的第k個數字為組合數C_{n-1}^{k-1}。
 * 第n行数字和为2^{n-1}。
 *  除每行最左側與最右側的數字以外，每个数字等于它的左上方與右上方两个数字之和（也就是說，第n行第k個數字等於第n-1行的第k-1個數字與第k個數字的和）。這是因为有組合恒等式：C_{n}^{i}=C_{n-1}^{i-1}+C_{n-1}^{i}。可用此性质写出整个楊輝三角形。
 *
 * 根据上面那个图，我们可以发现，第一行和第二行都由1组成。其他行的起始和结束都是1.内容由上一行相邻两个数组和组成。由此我们可以写出代码。
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {

	}

}
