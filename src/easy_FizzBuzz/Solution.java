package easy_FizzBuzz;

import java.util.ArrayList;

public class Solution {

	public ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("fizz buzz");
			} else if (i % 3 == 0) {
				result.add("fizz");
			} else if (i % 5 == 0) {
				result.add("buzz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		ArrayList<String> result = s.fizzBuzz(15);
		for (String str : result) {
			System.out.print(str + ", ");
		}
	}
}
