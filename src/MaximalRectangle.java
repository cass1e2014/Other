import java.util.Arrays;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * 这道题可以应用之前解过的Largetst Rectangle in Histogram一题辅助解决。解决方法是：
 * 
 * 按照每一行计算列中有1的个数，作为高度，当遇见0时，这一列高度就为0。然后对每一行计算 Largetst Rectangle in
 * Histogram，最后得到的就是结果。
 * 
 * @author cassie9082
 * 
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix[0].length == 0 || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[] height = new int[n];// 对每一列构造数组，作为长度

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					height[j] = 0;
				} else {
					height[j] += 1;
				}
			}
			max = Math.max(max, largestRectangleArea(height));  //做完一行就会call一次方法算最大面积
		}
		return max;
	}

	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= height.length; i++){
            int current = (i == height.length) ? -1 : height[i];
            while(!stack.isEmpty() && current <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
	}
}
