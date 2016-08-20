package easy_AplusB;

public class Solution {

	public static int aPlusB(int a, int b) {

		// A plus B is a loop of sum and carry, when the carry is 0, the loop
		// finished. Sum is come from 'xor', and carry from 'and'

		while (b != 0) {
			int xorR = a ^ b;
			int andR = a & b;
			andR = andR << 1;
			// System.out.println("a: "+Integer.toBinaryString(a));
			// System.out.println("b: "+Integer.toBinaryString(b));
			// System.out.println("xor: "+Integer.toBinaryString(xorR));
			// System.out.println("and: "+Integer.toBinaryString(andR));
			// System.out.println("sum: "+Integer.toBinaryString(xorR|andR));
			a = xorR;
			b = andR;
		}
		return a;
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 10;

		System.out.println(aPlusB(a, b));

	}

}
