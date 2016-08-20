package easy_AddDigits;

public class Solution {

	public int addDigits(int number){
		if(number%9==0){
			return 9;
		}
		return number%9;
	}
	
	public static void main(String [] args){
		int number=892317482;
		Solution s=new Solution();
		System.out.println(s.addDigits(number));
	}
}
