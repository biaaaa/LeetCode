package easy_SortedSearch;

public class Solution {

	public static int sortedSearch(int[] nums, int target) {
		int head = 0;
		int end = nums.length - 1;

		while (head + 1 < end) {
			int split = head + (end - head) / 2;
			if (nums[split] < target) {
				head = split;
			} else {
				end = split;
			}
		}
		if (nums[head] == target) {
			return head;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		int target = 3;
		System.out.println(sortedSearch(nums, target));
	}
}
