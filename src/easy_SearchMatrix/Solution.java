package easy_SearchMatrix;

public class Solution {

	public static boolean searchMatrix(int[][] matrix, int target){
		int head=0;
		int end=matrix.length;
		
		while(head+1<end){
			int split=head+(end-head)/2;
			if(matrix[split][0]<target){
				head=split;
			}
			else if(matrix[split][0]>target){
				end=split;
			}
			else{
				return true;
			}
		}
		int m=0;
		
		if(matrix[end][0]<target){
			m=end;
		}
		else{
			m=head;
		}
		
		head=0;
		end=matrix[0].length;
		
		while(head+1<end){
			int split=head+(end-head)/2;
			if(matrix[m][split]<target){
				head=split;
			}
			else if(matrix[m][split]>target){
				end=split;
			}
			else{
				return true;
			}
		}
		
		if(matrix[m][head]==target){
			return true;
		}
		if(matrix[m][end]==target){
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int target=12;
		System.out.println(searchMatrix(matrix, target));
	}
}
