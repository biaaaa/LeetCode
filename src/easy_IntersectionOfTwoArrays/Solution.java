package easy_IntersectionOfTwoArrays;

import java.util.Arrays;


public class Solution {
	
	
    public static int[] intersection(int[] nums1, int[] nums2) {

    	Arrays.sort(nums1);//o(nlogn)
        Arrays.sort(nums2);//o(mlogm)
        
        int[] intTemp=new int[nums1.length<nums2.length?nums1.length:nums2.length];
        int m=0,n=0;
        int j=0;
        while(m<nums1.length&&n<nums2.length){
        	if(nums1[m]<nums2[n]){
        		m++;
        	}else if(nums1[m]>nums2[n]){
        		n++;
        	}else{
        		intTemp[j]=nums1[m];
        		m++;
        		n++;
        		j++;
        	}
        }//o(m) or o(n)
        

        if(j==0){
        	return null;
        }else{
        	int[] intersection=new int[j];
        	for(int i=0;i<j;i++){
        		intersection[i]=intTemp[i];
        	}
        	return intersection;
        }
        
    }
    
    public static void main(String [] args){
    	int[] nums1={1,2,2,3,3,1,10,9};
    	int[] nums2={2,2,3,4,5,9,9};
    	int[] intersection=intersection(nums1,nums2);
    	for(int i : intersection){
    		System.out.print(i+" ");
    	}
    }
}
