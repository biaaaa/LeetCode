package medium_LexicographicalNumbers;

/*
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> lexicalOrder(int n) {
        int i=1;
    	int w=10;
    	while(n>=w){
    		w*=10;
    	}
    	w/=100;
    	if(w==0){
    		w=1;
    	}
    	if(n/10+1==10*w){
    	    w*=10;
    	}
    	ArrayList<Integer> results = new ArrayList<>();
    	while(i<=n){
    		results.add(i);
    		while((i*=10)<=n){
    			results.add(i);
    		}
    		i/=10;
    		while((i+=1)<=n){
    			if(i%10==0)break;
    			results.add(i);
    		}
    		i-=1;
    		i=i/10+1;
    		if(i==w)break;
    		while(i%10==0){
    			i/=10;
    		}
    	}
        return results;
    }
    
    public static void main(String[] args){
    	int n=100;
    	ArrayList<Integer> out = lexicalOrder(n);
    	for(Integer i:out){

    		System.out.print(i+", ");
    		if((i+1)%100==0){
    			System.out.println("");
    		}
    	}
    }
}