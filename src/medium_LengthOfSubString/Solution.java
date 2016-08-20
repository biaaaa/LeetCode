package medium_LengthOfSubString;

import java.util.HashMap;


public class Solution {
    public static int lengthOfLongestSubstring(String s) {
    	
    	int l=0;
    	int maxL=0;
    	HashMap<Character,Integer> hmap = new HashMap<>();
    	
    	int i=0;
    	int j=0;
    	while(j<s.length()){
    		if(!hmap.containsKey(s.charAt(j))){
    			hmap.put(s.charAt(j), j);
    		}
    		else{
    			i=i>hmap.get(s.charAt(j))+1?i:hmap.get(s.charAt(j))+1;
    			hmap.remove(s.charAt(j));
    			hmap.put(s.charAt(j), j);
    		}
    		l=j-i+1;
    		j++;
    		maxL=maxL>l?maxL:l;
    	
    	}
    	
    	
    	return maxL;
    	
    }
    
    public static int lengthOfLongestSubstring2(String s) {
    	String oldStr = ""+s.charAt(0);
    	String newStr = "";
    	int l=1;
    	boolean lastIsIn=true;
    	for(int i=0;i<s.length();i++){
    		if(lastIsIn==true){
    			if(!oldStr.contains(s.subSequence(i, i+1))){
    				oldStr+=s.charAt(i);
    				l=oldStr.length();
    			}else{
    				newStr+=s.charAt(i);
    				lastIsIn=false;
    			}
    		}else{
    			if(!newStr.contains(s.substring(i,i+1))){
    				newStr+=s.charAt(i);
    			}else{
    				//find the duplicate's index
    				int index=newStr.indexOf(s.charAt(i));
    				newStr=newStr.substring(index+1, newStr.length());
    				newStr+=s.charAt(i);
    				}
    			}
    		if(newStr.length()>oldStr.length()){
    			oldStr=newStr;
    			newStr=new String();
    			l=oldStr.length();
    			lastIsIn=true;
    		}
    	}
    	
    	return l;
    }
    
    public static void main(String [] args){
    	String s="qqowwjefinasdfjffffabcdefghijk";
    	System.out.println(lengthOfLongestSubstring(s));
    }
}
