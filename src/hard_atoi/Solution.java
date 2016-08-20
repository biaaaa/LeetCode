package hard_atoi;

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
	public int atoi(String str){
		//test whether it is a negative number
		int negativeSign=0;
		
		if(str.charAt(0)=='-'){
			negativeSign=1;			
		}
		//begin with 0, it can be 00001 or 0.1. for all situation we return 0;
		if(str.charAt(negativeSign+1)==0||str.charAt(str.length()-1)=='.'){
			return 0;
		}
		//is a number? at most 1 decimal
		int decimal=0;
		for(int i = negativeSign+0 ; i<str.length(); i++){
			char c = str.charAt(i);
			if(c==46){
				decimal++;
				if(decimal>1||i==negativeSign+0){
					return 0;
				}
			}
			else if(c>57||c<48){
				return 0;
			}
		}
		
		//use array for every digit
		int[] digits = new int[10];		
		for(int i=0;i<10;i++){
			digits[i]=-1;
		}
		//j is the length of the number.
		int j=0;
		for(int i = negativeSign+0 ; i<str.length(); i++){
			char c = str.charAt(i);
			if(c=='.'){
				break;
			}
			
			j=i-negativeSign;
			if(j==10){
				break;
			}
			
			switch(c){
			case 48: digits[j]=0; break;
			case 49: digits[j]=1; break;
			case 50: digits[j]=2; break;
			case 51: digits[j]=3; break;
			case 52: digits[j]=4; break;
			case 53: digits[j]=5; break;
			case 54: digits[j]=6; break;
			case 55: digits[j]=7; break;
			case 56: digits[j]=8; break;
			case 57: digits[j]=9; break;
			}
		}

		boolean overflow=false;
		if(j==10){
			int[] compare={2,1,4,7,4,8,3,6,4,7};
			for(int i=0;i<10;i++){
				if(digits[i]>compare[i]){
					overflow=true;
					break;
				}
				if(digits[i]<compare[i]){
					break;
				}
			}
		}
		int number=0;	
		if(overflow==false){
			for(int i=0;i<digits.length;i++){
				if(digits[i]==-1){
					break;
				}
				number=number*10+digits[i];
			}
		}else{
			number=2147483647;
		}
		
		if(negativeSign==0){
			return number;
		}else{
			return -number;
		}
		
	}
	
	public static void main(String [] args){
		Solution s = new Solution();
		String str="122.785213.2222";
		int number=s.atoi(str);
		System.out.println(number);
	}
}
