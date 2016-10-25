package duplicateNumber;

public class Solution {
	public static int duplicateNumber(int num) {
		int n = 10;
		
		while (num / n >= 10) {
			n *= 10;
		}
		System.out.println(n);
		int dup = num;
		int prev = dup / n;
		dup = dup % n;
		n /= 10;
		while(n != 0) {
			//System.out.println(n);
			int curt = dup / n;
			if(prev > curt) {
				break;
			}
			prev = curt;
			dup = dup % n;
			n /= 10;
		}
		if(n == 0) {
			n = 1;
		}else {
			n *= 10;
		}
		
		return (((num / n) * 10) + prev) * n + num % n;
		
	}
	
	public static void main(String[] args) {
		System.out.println(duplicateNumber(126345));
	}
	
}
