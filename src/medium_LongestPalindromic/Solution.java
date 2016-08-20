package medium_LongestPalindromic;

public class Solution {
    public static String longestPalindrome(String s) {
    	if(s.equals("")){
    		return "";
    	}
    	int l=0;
    	
    	String s1="";
    	for(int i=0;i<s.length()-l/2;i++){
    		int j=1;
    		int lTemp=1;
    		while(i-j>=0&&i+j<s.length()){
    			if(s.charAt(i-j)==s.charAt(i+j)){
    				lTemp+=2;
    			}else{
    				break;
    			}
	    		j++;
    		}
    		if(lTemp>l){
    			l=lTemp;
    			s1=s.substring(i-j+1, i+j);
    		}
    		

    	}
    	for(int i=0;i<s.length()-1-l/2;i++){
    		if(s.charAt(i)==s.charAt(i+1)){
        		int j=1;
        		int lTemp=2;
        		while(i-j>=0&&i+j+1<s.length()){
        			if(s.charAt(i-j)==s.charAt(i+j+1)){
        				lTemp+=2;
        			}else{
        				break;
        			}
    	    		j++;
        		}
        		if(lTemp>l){
        			l=lTemp;
        			s1=s.substring(i-j+1, i+j+1);
        		}

    		}
    	}
    	
    	
        return s1;
    }
    
    public static void main(String[] args){
    	String s="abcdeabaedcccccccc";
    	System.out.println(longestPalindrome(s));
    }
}