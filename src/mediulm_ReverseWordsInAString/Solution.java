package mediulm_ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static String reverseWords(String s) {
        //separate words by spaces
        //store them in strings? then reverse the order?
        //put in arraylist then reverse
        //how to operate multi-spaces
        // if(s==null){
        //     return null;
        // }
        // if(s.equals("")){
        //     return "";
        // }
        // //ArrayList<String> words = new ArrayList<>();
        // ArrayList<Integer> indice = new ArrayList<>();
        // boolean space=false;
        // String result="";
        
        
        // if(s.charAt(0)!=' '){
        //     indice.add(0);
        // }else{
        //     space=true;
        // }
        
        // for(int i=0; i<s.length(); i++){
        //     if(s.charAt(i)==' '&&space==false){
        //         indice.add(i-1);                //a word's end
        //         space=true;
        //         continue;
        //     }
        //     if(s.charAt(i)!=' '&&space==true){
        //         indice.add(i);                  //a word's start
        //         space=false;
        //     }
        //     if(s.charAt(i)!=' '&&i==s.length()-1){
        //         indice.add(i);
        //     }
        // }

        // if(indice.size()<1){
            
        //     return "";
        // }
 
        // for(int i =indice.size()-2;i>0;i-=2){
        //     result+=s.substring(indice.get(i), indice.get(i+1)+1)+" ";
        // }
        // result+=s.substring(indice.get(0), indice.get(1)+1);
        // return result;
        
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}