package hard_Ksum;

public class Solution {
	/**
	 * @param A
	 *            : an integer array.
	 * @param k
	 *            : a positive integer (k <= length(A))
	 * @param target
	 *            : a integer
	 * @return an integer
	 */
	public int kSum(int A[], int k, int target) {

		int[][][] s = new int[k + 1][A.length][target + 1];

		for (int j = 0; j < A.length; j++) {
			s[0][j][0] = 1;
			s[1][j][A[j]] = 1;
		}

		for (int i = 1; i < k + 1; i++) {
			for (int j = 1; j < A.length; j++) {
				for (int l = 0; l < target + 1; l++) {
					if (l >= A[j]) {
						s[i][j][l] = s[i][j - 1][l] + s[i - 1][j - 1][l - A[j]];
					} else {
						s[i][j][l] = s[i][j - 1][l];
					}
				}
			}
		}

		return s[k][A.length - 1][target];
	}
}
