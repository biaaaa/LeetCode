package easy_ReverseString;

public class Solution {

	public String reverseString(String s){
		//it is not a good method since the String's concatenation will generate new String each time;
		//This process will run out of memory and cause Time Limit Exceeded;
		String newString="";

		for(int i =0;i<s.length();i++){
			newString+=s.charAt(s.length()-1-i);
		}
		return newString;
		
	}
	
	public static void main(String [] args){
		Solution sl = new Solution();
		String s = "herrrrttghfgsdfg   df llo";
		System.out.println(sl.reverseString(s));
	}
}
