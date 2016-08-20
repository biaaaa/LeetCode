package easy_strStr;

public class Solution {

	public int strStr(String source, String target){
		int lengthT = target.length();
		
		for(int i =0 ; i<=source.length()-lengthT;i++){
			if(source.charAt(i)==target.charAt(0)){
				if(source.substring(i, i+lengthT).equals(target)){
					return i;
				}
			}
		}		
		return -1;
	}
	
	public int strKMP(String source, String target){
		//calculate the lps - longest prefix suffix with O(k), in which k is the target's length.
		int[] lps= new int[target.length()];
		lps[0]=-1;
		lps[1]=0;
		int j=0;
		int k=-1;
		while(j<target.length()-1){
			if(k==-1 || target.charAt(j)==target.charAt(k)){
				k++;
				j++;
				lps[j]=k;
			}
			else{
				k=lps[k];
			}			
		}
		
		
		//retrieve the target in source, which costs time complexity of O(n) - n is the length of source.
		//So, in total, the time is O(n+k)=O(n); (k is shorter than n)
		int i=0;
		j=0;
		while(i<source.length()){

			if(source.charAt(i)==target.charAt(j)){
				i++;
				j++;
				if(j==target.length()){
					return i-j;
				}
			}
			else if(j!=0){
				j=lps[j];
			}
			else{
				i++;
			}			
		}
		
		return -1;
		
	}
	
	
	
	public static void main(String[] args){
		Solution s = new Solution();
		String source = "abcdabcdabcc";
		String target = "abcdabc";
		//System.out.println(s.strStr(source, target));
		System.out.println(s.strKMP(source, target));
	}
}
