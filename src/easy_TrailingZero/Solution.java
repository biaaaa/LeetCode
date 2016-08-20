package easy_TrailingZero;

public class Solution {

	public long trailingZeros(long n) {

		// We make a prime factorization with the n, when there are 2*5 it
		// generates a 0 at the end. So, there are many 2s in the n factorial,
		// the only decision element is 5. Thus we can count the 5s in n. That
		// is, the 5, 25, 125 in the multiply result.

		long count = 0;

		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}

		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.trailingZeros(40));
	}

}
