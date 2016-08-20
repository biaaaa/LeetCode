package easy_InsertInterval;

import java.util.ArrayList;

public class Solution {

	public static ArrayList<Interval> insert(ArrayList<Interval> array,
			Interval newInterval) {
		int head = 0;
		int end = array.size() - 1;
		int startPosition;
		int endPosition;

		if (array.get(0).getStart() > newInterval.getStart()) {
			startPosition = -1;
			
		} else if(array.get(array.size()-1).getStart() < newInterval.getStart()){
			startPosition = array.size()-1;
		}
		else {
			while (head + 1 < end) {
				int split = head + (end - head) / 2;
				if (array.get(split).getStart() < newInterval.getStart()) {
					head = split;
				} else {
					end = split;
				}
			}
			startPosition = head;
		}
		if (array.get(array.size() - 1).getEnd() < newInterval.getEnd()) {
			endPosition = array.size();
		} else if(array.get(0).getEnd() > newInterval.getEnd()){
			endPosition = 0;
		}else {
			head = 0;
			end = array.size() - 1;

			while (head + 1 < end) {
				int split = head + (end - head) / 2;
				if (array.get(split).getEnd() < newInterval.getEnd()) {
					head = split;
				} else {
					end = split;
				}
			}

			endPosition = end;
		}
		
		//discussion
		if(startPosition==-1){
			if(endPosition!=array.size()){
				if (array.get(endPosition).getStart() > newInterval.getEnd()) {
					// case e1
					for (int i = startPosition+1; i < endPosition; i++) {
						array.remove(startPosition + 1);
					}
					array.add(0, newInterval);
				} else {
					// case e2
					array.get(endPosition).setStart(newInterval.getStart());
					for (int i = startPosition+1; i < endPosition; i++) {
						array.remove(startPosition + 1);
					}
				}
			}
			else{
				array.clear();
				array.add(newInterval);
			}
			return array;
		}
		
		if(endPosition==array.size()){
			if (array.get(startPosition).getEnd() < newInterval.getStart()){
				//s1
				for (int i = startPosition+1; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
				array.add(startPosition + 1, newInterval);
			}
			else{
				//s2
				array.get(startPosition).setEnd(newInterval.getEnd());
				for (int i = startPosition+1; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
			}
			return array;
		}
		
		
		
		//normal
		if (array.get(startPosition).getEnd() < newInterval.getStart()) {
			// case s1
			if (array.get(endPosition).getStart() > newInterval.getEnd()) {
				// case e1
				for (int i = startPosition+1; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
				array.add(startPosition + 1, newInterval);
			} else {
				// case e2
				if (array.get(endPosition).getStart() > newInterval.getStart()) {
					array.get(endPosition).setStart(newInterval.getStart());
				}
				for (int i = startPosition+1; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
			}
		} else {
			// case s2
			if (array.get(endPosition).getStart() > newInterval.getEnd()) {
				// case e1
				if (array.get(startPosition).getEnd() < newInterval.getEnd()) {
					array.get(startPosition).setEnd(newInterval.getEnd());
				}
				for (int i = startPosition+1; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
			} else {
				// case e2
				if (array.get(startPosition).getEnd() < newInterval.getEnd()) {
					array.get(startPosition).setEnd(
							array.get(endPosition).getEnd());
				}
				for (int i = startPosition; i < endPosition; i++) {
					array.remove(startPosition + 1);
				}
			}
		}

		return array;
	}

}
