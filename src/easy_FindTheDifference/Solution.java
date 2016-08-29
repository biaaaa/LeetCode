package easy_FindTheDifference;

public class Solution {
    public char findTheDifference(String s, String t) {
        char f=0;
        for(int i=0;i<s.length();i++){
        	f^=s.charAt(i);
        	f^=t.charAt(i);
        }
        f^=t.charAt(s.length());
        return f;
    }
}
