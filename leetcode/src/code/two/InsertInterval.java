package code.two;

import java.util.ArrayList;
import java.util.List;

//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//You may assume that the intervals were initially sorted according to their start times.
//
//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
public class InsertInterval {
	
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		List<Interval> list = new ArrayList<>();
		int start = newInterval.start;
		int end = newInterval.end;
		boolean sf = true;
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).end < start) {
				list.add(intervals.get(i));
				if (i == intervals.size() - 1) {
					list.add(newInterval);
					break;
				}
				continue;
			} else {

				if (sf && start >= intervals.get(i).start
						&& start <= intervals.get(i).end) {
					newInterval.start = intervals.get(i).start;
				}
				sf = false;

				if (end >= intervals.get(i).start
						&& end <= intervals.get(i).end) {
					newInterval.end = intervals.get(i).end;
					list.add(newInterval);
					list.addAll(intervals.subList(i + 1, intervals.size()));
					break;
				} else if (end < intervals.get(i).start) {
					list.add(newInterval);
					list.addAll(intervals.subList(i, intervals.size()));
					break;
				} else {
					if (i == intervals.size() - 1) {
						list.add(newInterval);
						break;
					}
					continue;
				}
			}
		}

		return list;
    }
	
	
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 5));
		new InsertInterval().insert(list, new Interval(2, 7));
	}
	
	
	
	
	

}
