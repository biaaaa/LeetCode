package hard_MaximumSubarrayIII;

public class Solution {
	/**
	 * @param nums
	 *            : A list of integers
	 * @param k
	 *            : An integer denote to find k non-overlapping subarrays
	 * @return: An integer denote the sum of max k non-overlapping subarrays
	 */
	public static int max(int a, int b, int c) {
		return a > b ? max(a, c) : max(b, c);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public int maximumSubarray(int[] nums, int k) {
		// Dynamic Programming:
		// S(i,k)=
		// if A(i-1) is in the subarray of S(i-1,k): max[S(i-1,k)+Ai, S(i-1,k),
		// S(i-1,k-1)+Ai]
		// if A(i-1) is not in subarray of S(i-1,k): max[S(i-1,k-1)+Ai,
		// S(i-1,k)]

		
		int[][] s = new int[nums.length][k + 1];
		boolean[][] last = new boolean[nums.length][k + 1];

		s[0][0] = 0;
		s[0][1] = nums[0];
		last[0][0] = false;
		last[0][1] = true;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j <= i + 1 && j <= k; j++) {
				if (i + 1 == j) {
					s[i][j] = s[i - 1][j - 1] + nums[i];
					last[i][j] = true;
				} else {
					if (s[i - 1][j - 1] + nums[i] > s[i - 1][j]) {
						s[i][j] = s[i - 1][j - 1] + nums[i];
						last[i][j] = true;
					} else {
						s[i][j] = s[i - 1][j];
						last[i][j] = false;
					}
					if(last[i-1][j]){
						if(s[i][j]<s[i-1][j]+nums[i]){
							s[i][j]=s[i-1][j]+nums[i];
							last[i][j]=true;
						}
					}
					else {
						int sum=0;
						for(int m=i-1;last[m][j]!=true;m--){
							sum+=nums[m];
						}
						if(s[i][j]<s[i-1][j]+sum+nums[i]){
							s[i][j]=s[i-1][j]+sum+nums[i];
							last[i][j]=true;
						}
					}
				}
			}
		}

		return s[nums.length - 1][k];

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2, -9, 5, 1, -4, 6, 0, -7, 8};
		int k = 2;

		System.out.println(s.maximumSubarray(nums, k));
	}
}
