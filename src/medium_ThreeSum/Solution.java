package medium_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import easy_ReverseLinkedList.List;

public class Solution {
    /*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
	 * Find all unique triplets in the array which gives the sum of zero.
	 * Note: The solution set must not contain duplicate triplets.
	 * For example, given array S = [-1, 0, 1, 2, -1, -4],
	 * A solution set is:
	 * [
	 * [-1, 0, 1],
	 * [-1, -1, 2]
	 * ]
	 */

    //using dynamic programming
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        //do 2sum
        //List a = new List();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> for2Sum = new ArrayList<>();

        for2Sum.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                for2Sum.add(nums[i]);
                continue;
            }
            ArrayList<Integer> temp = twoSum(for2Sum, -nums[i]);
            if (!temp.isEmpty()) {
                for (int m = 0; m < temp.size(); m += 2) {
                    ArrayList<Integer> tripple = new ArrayList<>();
                    tripple.add(temp.get(m));
                    tripple.add(temp.get(m + 1));
                    tripple.add(nums[i]);
                    results.add(tripple);
                }
            }
            for2Sum.add(nums[i]);
        }
        return results;
    }

    private static ArrayList<Integer> twoSum(ArrayList<Integer> newNums, int target) {
        int i = 0;
        int j = newNums.size() - 1;
        Integer[] nums = new Integer[j + 1];
        newNums.toArray(nums);
        ArrayList<Integer> results = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                results.add(nums[i]);
                results.add(nums[j]);
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 1, 2, 3};
        ArrayList<ArrayList<Integer>> set = threeSum(nums);
        for (ArrayList<Integer> list : set) {
            for (Integer i : list) {
                System.out.print(i + ", ");
            }
            System.out.println("");
        }
    }
}
