package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * @author stick
 *
 */
public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int i = 0;
		for (; i < intervals.length; i++) {
			int arr[] = intervals[i];
			if (arr[1] < newInterval[0]) {
				result.add(arr);
			} else if (arr[1] == newInterval[0]) {
				newInterval[0] = arr[0];
			} else {
				if (arr[1] <= newInterval[1]) {
					newInterval[0] = Math.min(newInterval[0], arr[0]);
				} else {
					if (arr[0] <= newInterval[0]) {
						result.add(arr);
						break;
					} else if (arr[0] <= newInterval[1]) {
						newInterval[1] = arr[1];
					} else {
						result.add(newInterval);
						result.add(arr);
						break;
					}
				}
			}
		}
		if (i == intervals.length) {
			result.add(newInterval);
		}
		for (i++; i < intervals.length; i++) {
			result.add(intervals[i]);
		}
		int[][] eResult = new int[result.size()][2];
		for (int index = 0; index < result.size(); index++) {
			eResult[index] = result.get(index);
		}
		return eResult;
	}

	public static void main(String[] args) {
		InsertInterval test = new InsertInterval();
		System.out.println(Arrays.deepToString(test.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 })));
	}
}
