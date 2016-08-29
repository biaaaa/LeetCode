package hard_PerfectRectangle;

import java.util.ArrayList;

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        //merge them
    	ArrayList<Integer[]> recs = new ArrayList<>();
    	int amount=rectangles.length/4;
    	for(int i=0;i<amount;i++){
    		Integer[] rec={rectangles[i][0],rectangles[i][1],rectangles[i][2],rectangles[i][3]};
    		recs.add(rec);
    	}
    	for(Integer[] rec1:recs){
    		for(Integer[] rec2:recs){
    			if(canMerge(rec1,rec2)){
    				Integer[] recNew=merge(rec1,rec2);
    			}
    		}
    	}
    	return false;
    }
    
    private boolean canMerge(Integer[] rec1, Integer[] rec2){
    	if(rec1[1]==rec2[1]&&rec1[3]==rec2[3]){
    		if(rec2[0]==rec1[2]||rec1[0]==rec2[2]){
    			return true;
    		}
    		else return false;
    	}else if(rec1[0]==rec2[0]&&rec1[2]==rec2[2]){
    		if(rec2[1]==rec1[3]||rec1[1]==rec2[3]){
    			return true;
    		}else return false;
    	}
    	return false;
    }
    
    private Integer[] merge(Integer[] rec1, Integer[] rec2){
    	if(rec1[1]==rec2[1]&&rec1[3]==rec2[3]){
    		if(rec1[0]<rec2[0]){
    			return new int[]{rec1[0],rec1[1],rec2[2],rec2[3]};
    		}else{
    			return new int[]{rec2[0],rec2[1],rec1[2],rec1[3]};
    		}
    	}else if(rec1[0]==rec2[0]&&rec1[2]==rec2[2]){
    		if(rec1[1]<rec2[1]){
    			return new int[]{rec1[0],rec1[1],rec2[2],rec2[3]};
    		}else{
    			return new int[]{rec2[0],rec2[1],rec1[2],rec1[3]};
    		}
    	}else{
    		return new int[]{0,0,0,0};
    	}
    }
}