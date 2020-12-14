package HackerRank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class SherlokValidString {
    

    static String isValid(String s) {
        
        Map<Character,Integer> keyMap = new HashMap<Character,Integer>();
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();

        for(int i=0; i < s.length(); i++){
            if(keyMap.containsKey(s.charAt(i))){
                keyMap.put(s.charAt(i),keyMap.get(s.charAt(i))+1);
            }else{
                keyMap.put(s.charAt(i),1);
            }
        }

        for(int i=0; i < s.length(); i++){
            //frequency of each occurrence
            if(countMap.containsKey(keyMap.get(s.charAt(i)))){
                countMap.put(keyMap.get(s.charAt(i)),countMap.get(keyMap.get(s.charAt(i)))+1);
            }else{
                countMap.put(keyMap.get(s.charAt(i)),1);
            }
        }

        if(countMap.size() == 1){
            return "YES";
        }else if(countMap.size() == 2){
            Iterator<Integer> itrKey = countMap.keySet().iterator();
            Iterator<Integer> itrVal = countMap.values().iterator();
            int key1 = itrKey.next();
            int key2 = itrKey.next();
            int val1 = itrVal.next();
            int val2 = itrVal.next();

            //there is only one extra char and can be removed
            if ((key1 == 1 && val1 == 1) || (key2 == 1 && val2 == 1)){
                return "YES";
            }
             
            // [a,b,b,a,a,a,c]
            //there is a difference of 1 between frequencies and one char can be removed
            if ((key1 == key2 + 1) || (val1 == val2 + 1)){
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String s = scanner.nextLine();

        System.out.println(isValid(s));
    }
}
