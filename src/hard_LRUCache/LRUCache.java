package hard_LRUCache;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    
    private static class Node{
        private int key;
        private int frequency;
        
        private Node(int key,int frequency){
            this.key=key;
            this.frequency=frequency;
        }
    }
    
    private HashMap<Integer, Integer> map;
    private ArrayList<Node> keysArray;
    private int capacity;
    //private int count;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        keysArray = new ArrayList<>();
        this.capacity=capacity;
        //count=0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            updateFrequency(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.replace(key,value);
            updateFrequency(key);
            return;
        }
        if(keysArray.size()<capacity){
            map.put(key,value);
            keysArray.add(0,new Node(key,1));
        }else{
            map.remove(keysArray.get(0).key);
            map.put(key,value);
            keysArray.remove(0);
            keysArray.add(0,new Node(key,1));
        }
    }
    
    private void updateFrequency(int key){
        int i=0;
        for(i=0;i<keysArray.size();i++){
            if(keysArray.get(i).key==key){
                keysArray.get(i).frequency++;
                break;
            }
        }
        for(i=i+1;i<keysArray.size();i++){
            if(keysArray.get(i-1).frequency>keysArray.get(i).frequency){
                Node n = keysArray.get(i-1);
                keysArray.remove(i-1);
                keysArray.add(i,n);
            }
        }
    }
}