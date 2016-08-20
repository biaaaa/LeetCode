package super_SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();

		int i = 0;
		for (int now : nums) {
			i++;
			while (!q.isEmpty() && now > q.peekLast()) {
				q.pollLast();
			}
			q.offer(now);
			if (i >= k) {
				ans.add(q.peekFirst());
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 4;
		System.out.println(s.maxSlidingWindow(nums, k));
	}
}