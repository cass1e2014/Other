import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author cassie9082
 * 
 */
public class MaxPointsOnALine {
	// Time: O(N^2), Space:O(N)
	public int maxPoints(Point[] points) {
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Point pt = points[i];
			int pointMax = 0;// max number of neighbor points on the same line
								// (exclude the same points)
			int samePoint = 0;// number of same points (exclude the point
								// itself)
			Map<Double, Integer> map = new HashMap<Double, Integer>();// <slope,
																		// number
																		// of
																		// neighbor
																		// points>
			for (int j = i + 1; j < points.length; j++) {
				Point neighbor = points[j];
				if (pt.x == neighbor.x && pt.y == neighbor.y) {
					samePoint++;
				} else {
					double s = slopeCalc(pt, neighbor);
					if (!map.containsKey(s)) {
						map.put(s, 1);
					} else {
						map.put(s, map.get(s) + 1);
					}
					pointMax = Math.max(pointMax, map.get(s));
				}
			}
			max = Math.max(max, pointMax + samePoint + 1);
		}
		return max;
	}

	public double slopeCalc(Point a, Point b) {
		if (a.x == b.x)
			return Double.POSITIVE_INFINITY;// 斜率正无穷
		if (a.y == b.y)
			return 0;
		double s = (double) (a.y - b.y) / (double) (a.x - b.x);
		return s;
	}
}

class Point{
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	Point(int a, int b){
		x = a;
		y = b;
	}
}