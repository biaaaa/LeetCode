package easy_ReverseString02;

import java.util.Arrays;
import java.util.Collections;

/*
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solution {
    public String reverseString(String s) {
    	int l = s.length();
    	StringBuffer sb = new StringBuffer("");
    	for(int i = 0 ; i<s.length() ; i++){
    		sb.append(s.charAt(l-i-1));
    	}
    	return sb.toString();
    }
	
    public String reverseString2(String s) {
    	//this won't work, c.toString() will return the memory address of it,
    	//not the concatenation result of the char array;
    	char[] cArray = s.toCharArray();
    	Collections.reverse(Arrays.asList(cArray));
    	return cArray.toString();
    }
}
