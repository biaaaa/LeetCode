package hard_PerfectRectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {

	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
		
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Point point = (Point) o;
	        return x == point.x && y == point.y;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
	    
	}
	
    public boolean isRectangleCover(int[][] rectangles) {
    	
    	int xmin=Integer.MAX_VALUE;
    	int xmax=Integer.MIN_VALUE;
    	int ymin=Integer.MAX_VALUE;
    	int ymax=Integer.MIN_VALUE;
    	
    	Set<Point> bottomLeft = new HashSet<>();
    	Set<Point> bottomRight = new HashSet<>();
    	Set<Point> topLeft = new HashSet<>();
    	Set<Point> topRight = new HashSet<>();
    	Map<Point, Integer> points = new HashMap<>();
    	int totalSize=0;
    	
    	for(int[] rec:rectangles){
    		xmin=Math.min(xmin, rec[0]);
    		ymin=Math.min(ymin, rec[1]);
    		xmax=Math.max(xmax, rec[2]);
    		ymax=Math.max(ymax, rec[3]);
    		
    		Point bl=new Point(rec[0],rec[1]);
    		Point br=new Point(rec[2],rec[1]);
    		Point tl=new Point(rec[0],rec[3]);
    		Point tr=new Point(rec[2],rec[3]);
    		
    		if(bottomLeft.contains(bl))return false;
    		else{
    			bottomLeft.add(bl);
    			if(points.containsKey(bl)){
    				points.put(bl,points.get(bl)+1);
    			}else{
    				points.put(bl, 1);
    			}
    		}
    		if(bottomRight.contains(br))return false;
    		else{
    			bottomRight.add(br);
    			if(points.containsKey(br)){
    				points.put(br,points.get(br)+1);
    			}else{
    				points.put(br, 1);
    			}
    		}
    		if(topLeft.contains(tl))return false;
    		else{
    			topLeft.add(tl);
    			if(points.containsKey(tl)){
    				points.put(tl,points.get(tl)+1);
    			}else{
    				points.put(tl, 1);
    			}
    		}
    		if(topRight.contains(tr))return false;
    		else{
    			topRight.add(tr);
    			if(points.containsKey(tr)){
    				points.put(tr,points.get(tr)+1);
    			}else{
    				points.put(tr, 1);
    			}
    		}
    		totalSize+=(rec[3]-rec[1])*(rec[2]-rec[0]);
    	}
    	
    	Set<Point> maskCorners = new HashSet<>();
        maskCorners.add(new Point(xmin, ymin));
        maskCorners.add(new Point(xmin, ymax));
        maskCorners.add(new Point(xmax, ymin));
        maskCorners.add(new Point(xmax, ymax));
    	
        for (Map.Entry<Point, Integer> entry : points.entrySet()) {
        	if(entry.getValue()==3||entry.getValue()>4){
        		return false;
        	}
            if(entry.getValue()==1){
            	if(maskCorners.contains(entry.getKey()))
            		maskCorners.remove(entry.getKey());
            	else return false;
            }
        }
        
        if(!maskCorners.isEmpty()){
        	return false;
        }else if(totalSize!=(ymax-ymin)*(xmax-xmin)){
        	return false;
        }
        
    	return true;
    }
    
    public static void main(String [] args){
    	Solution s = new Solution();
    	int[][] rectangles={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
    	System.out.println(s.isRectangleCover(rectangles));
    }
}
    

