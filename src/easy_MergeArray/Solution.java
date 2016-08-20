package easy_MergeArray;

public class Solution {

	public int[] mergeSortedArray(int[] A, int[] B) {
		int pa = 0, pb = 0, pr = 0;
		int[] result = new int[A.length + B.length];

		while (pa < A.length && pb < B.length) {
			if (A[pa] < B[pb]) {
				result[pr] = A[pa];
				pa++;
				pr++;
			} else {
				result[pr] = B[pb];
				pb++;
				pr++;
			}
		}
		while (pa < A.length && pb == B.length) {
			result[pr] = A[pa];
			pa++;
			pr++;
		}
		while (pa == A.length && pb < B.length) {
			result[pr] = B[pb];
			pb++;
			pr++;
		}

		return result;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = { 1, 2, 3, 4 };
		int[] B = { 2, 4, 5, 6, 9 };
		int[] result = s.mergeSortedArray(A, B);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
