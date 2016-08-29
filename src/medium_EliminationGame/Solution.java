package medium_EliminationGame;

public class Solution {
    public int lastRemaining(int n) {
        if(n==1)return 1;
        if(n==2||n==3)return 2;
        
        if(n%2==0)n++;
        if(n%4==1){
            n=n/4;
            return 4*lastRemaining(n)-2;
        }else{
            n=(n-3)/4;
            return 4*lastRemaining(n);
        }
    }
}
