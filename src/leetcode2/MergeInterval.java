package leetcode2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * @author stick
 *
 */
public class MergeInterval {

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
			return intervals;
		}

		List<Interval> result = new ArrayList<>(intervals.size());
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start < o2.start) {
					return -1;
				}

				return 0;
			}
		});

		Iterator<Interval> cur = intervals.iterator();

		Interval p = cur.next();
		Interval q;

		int left = p.start;
		int right = p.end;

		while (cur.hasNext()) {
			q = cur.next();

			if (left <= q.start && right >= q.end) {
				continue;
			} else if (left <= q.start && q.start <= right && right < q.end) {
				right = q.end;
			} else {
				result.add(new Interval(left, right));

				left = q.start;
				right = q.end;
			}
		}

		result.add(new Interval(left, right));

		return result;
	}
}
