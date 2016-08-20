package easy_InsertInterval;

import java.util.ArrayList;

public class Demo {
	
	public static void main(String[] args) {
		ArrayList<Interval> array = new ArrayList<>();

		Interval newInterval = new Interval(13, 18);
		
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(5, 7);
		Interval i3 = new Interval(9, 11);
		Interval i4 = new Interval(12, 19);
		Interval i5 = new Interval(25, 103);
		Interval i6 = new Interval(177, 3333);

		array.add(i1);
		array.add(i2);
		array.add(i3);
		array.add(i4);
		array.add(i5);
		array.add(i6);

		for (Interval i : array) {
			System.out.println("[" + i.getStart() + ", " + i.getEnd() + "]");
		}

		System.out.println("-----------------------------");

		array = Solution.insert(array, newInterval);

		for (Interval i : array) {
			System.out.println("[" + i.getStart() + ", " + i.getEnd() + "]");
		}
	}
}
