package easy_TwoSum;

import java.util.Arrays;

public class Solution {

	public static int[] twoSum(int[] nums, int target){
		int [] newnums = nums.clone();
		Arrays.sort(newnums);

		int i=0;
		int j=newnums.length-1;
		while(i<=j){
			if(newnums[i]+newnums[j]<target){
				i++;
			}
			else if(newnums[i]+newnums[j]>target){
				j--;
			}else{
				break;
			}
		}
		int m=-1;
		int n=-1;
		for(int k =0;k<nums.length;k++){
			if(nums[k]==newnums[i]&&m==-1){
				m=k;
			}
			else if(nums[k]==newnums[j]&&n==-1){
				n=k;
			}
		}
		
		int[] result={m,n};

		return result;
	}
	
	public static void main(String[] args){
		int[] nums={2, 11, 4, 11, 33};
		int target=22;
		int[] result=twoSum(nums, target);
		for(int i : result){
			System.out.print(i+" ");
		}
		
	}
}
