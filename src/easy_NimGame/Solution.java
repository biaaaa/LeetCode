package easy_NimGame;
//if the heal has 1-3 stones, the first player can win.
//if there is 4 stones, then I lose. it means 4=0 5,6,7=1,2,3
//in this law. if the number of stones mod 4 equals 0.
public class Solution {

	public boolean nimGame(int number){
		if(number%4==0)
			return false;
		return true;
	}
	
	public static void main(String[] args){
		Solution s= new Solution();
		int number=200;
		System.out.println(s.nimGame(number));
		
	}
}
