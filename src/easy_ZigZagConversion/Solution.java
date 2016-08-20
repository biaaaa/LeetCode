package easy_ZigZagConversion;


public class Solution {

	public static String convert(String s, int numRows){
		if(s.equals("")){
			return "";
		}
		int zigs=s.length()/(2*numRows-2);
		System.out.println("zigs: "+zigs);
		int columns=0;
		if(s.length()%(2*numRows-2)==0){
			columns=zigs*(numRows-1);
		}
		else if(s.length()%(2*numRows-2)<=numRows){
			columns=zigs*(numRows-1)+1;
		}else{
			columns=zigs*(numRows-1)+s.length()%(2*numRows-2)-(numRows-1);
		}
		System.out.println("columns: "+columns);
		int span=2*numRows-2;
		int l=2*numRows-4;  //l means the distance of the long row and its single number;
		
		StringBuffer result = new StringBuffer();
		for(int i=0;i<numRows;i++){
			if(i==0||i==numRows-1){
				for(int j=0;(j/span)*(numRows-1)<=columns&&i+j<s.length();j+=span){
					
					result.append(s.charAt(i+j));
				}
			}
			else{
				for(int j=0;(j/span)*(numRows-1)<=columns&&i+j<s.length();j+=span){
					
					result.append(s.charAt(i+j));
					if((j/span)*(numRows-1)+l/2<=columns&&i+j+l<s.length())
						result.append(s.charAt(i+j+l));
				}
				l-=2;
				if(l==0){
					l=2*numRows-4;
				}
			}
		}
		
		return result.toString();
	}
	
	public static void main(String [] args){
		String s="ABCDEF";
		int nRow=4;
		System.out.println(convert(s, nRow));

	}
}
