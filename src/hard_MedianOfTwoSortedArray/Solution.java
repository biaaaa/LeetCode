package hard_MedianOfTwoSortedArray;

public class Solution {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int n=nums1.length+nums2.length;
		System.out.println(n);
		int i=0;
		int j=0;
		int c=0;
		double med1=0;
		double med2=0;
		double med=0;
		int num=0;
		while(c<=n/2&&i<nums1.length&&j<nums2.length){

			if(nums1[i]<nums2[j]){
				num=nums1[i];
				if(c==n/2-1){
					med1=num;
				}
				if(c==n/2&&n%2==0){
					med2=num;
					med=(med1+med2)/2;
					break;
				}else if(c==n/2&&n%2==1){
					med=num;
					break;
				}
				i++;
				c++;
			}else{
				num=nums2[j];
				if(c==n/2-1){
					med1=num;
				}
				if(c==n/2&&n%2==0){
					med2=num;
					med=(med1+med2)/2;
					break;
				}else if(c==n/2&&n%2==1){
					med=num;
					break;
				}
				j++;
				c++;
			}
		}
		while(c<=n/2&&i<nums1.length&&j>=nums2.length){
			num=nums1[i];
			if(c==n/2-1){
				med1=num;
			}
			if(c==n/2&&n%2==1){
				med2=num;
				med=(med1+med2)/2;
				break;
			}else if(c==n/2&&n%2==0){
				med=num;
				break;
			}
			i++;
			c++;
		}
		while(c<=n/2&&i>=nums1.length&&j<nums2.length){
			num=nums2[j];
			if(c==n/2-1){
				med1=num;
			}
			if(c==n/2&&n%2==0){
				med2=num;
				med=(med1+med2)/2;
				break;
			}else if(c==n/2&&n%2==1){
				med=num;
				break;
			}
			j++;
			c++;
		}
		return med;
	}
	
	public static void main(String [] args){
		int[] nums1={1,2};
		int[] nums2={3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
