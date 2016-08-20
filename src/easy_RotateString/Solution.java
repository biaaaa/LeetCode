package easy_RotateString;

public class Solution {

	public void rotateString(char[] str, int offset) {
		int head = 0;
		int tail = str.length - 1;
		int newHead = 0;

		head = (head + offset) % str.length;
		tail = (tail + offset) % str.length;
		newHead = str.length - head;

		// System.out.println(newHead);

		for (int i = newHead; i < str.length; i++) {
			System.out.print(str[i] + ", ");
		}
		for (int i = 0; i < newHead; i++) {
			System.out.print(str[i]);
			if (i != newHead - 1) {
				System.out.print(", ");
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		int offset = 3;
		s.rotateString(str, offset);
	}
}
