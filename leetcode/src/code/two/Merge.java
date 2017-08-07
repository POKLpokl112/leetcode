package code.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

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
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
public class Merge {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null) {
			return new ArrayList<>();
		}

		if (intervals.size() < 2) {
			return intervals;
		}

		List<Interval> list = new ArrayList<>();
		intervals.sort(new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start>end){
				Interval in = new Interval(start, end);
				list.add(in);
				start=intervals.get(i).start;
				end = intervals.get(i).end;
				continue;
			} else {
				if(intervals.get(i).start<start){
					start=intervals.get(i).start;
				}
				if (intervals.get(i).end > end) {
					end = intervals.get(i).end;
				}

				continue;
			}
			
		}
		
		Interval in = new Interval(start, end);
		list.add(in);
		return list;
	}
	public List<Interval> merge1(List<Interval> intervals) {
		if (intervals == null) {
			return new ArrayList<>();
		}

		if (intervals.size() < 2) {
			return intervals;
		}

		List<Interval> list = new ArrayList<>();
		int end = 0;
		int k = 0;
		int max = intervals.get(0).end;
		int min = intervals.get(0).start;
		for (int i = 1; i < intervals.size(); i++) {

			if (max < intervals.get(i).end) {
				max = intervals.get(i).end;
				end = i;
			}

			if (min > intervals.get(i).start) {
				min = intervals.get(i).start;
				k = i;
			}

		}

		int start = k + 1;
		int t = intervals.get(0).end;
		while (k <= end) {
			if (start == end + 1) {
				Interval in = new Interval(intervals.get(k).start,
						intervals.get(start - 1).end);
				list.add(in);
				break;
			}

			if (intervals.get(start).start > t) {
				Interval in = new Interval(intervals.get(k).start,
						intervals.get(start - 1).end);
				list.add(in);
				k = start;
				start = k + 1;
				continue;
			}

			if (intervals.get(start).end > t) {
				t = intervals.get(start).end;
			}

			start++;

		}
		return list;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 4));
		list.add(new Interval(10, 14));
		list.add(new Interval(15, 18));
		new Merge().merge(list);
	}

}
