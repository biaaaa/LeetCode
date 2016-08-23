package medium_SingleNumber;

public class Solution {
    public int singleNumber(int[] nums) {
        //HashMap<Integer,Integer> map = new HashMap<>();
        //HashSet<Integer> set = new HashSet<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
                sum^=nums[i];

        }
        return sum;
    }
}