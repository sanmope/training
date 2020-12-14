package HackerRank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KmostFrequentElements {
    /*
        Given a non-empty array of integers, return the k most frequent elements.
        
        Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

        Example 2:
        Input: nums = [1], k = 1
        Output: [1]

        Note:
            You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
            Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
            It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
            You can return the answer in any order.

    */

    /*
        how to resolve problems

        - Define
        - Representation
        - Approach/Strategy
        - Algorithm
        - Experiment
        - and Repeat
    */

    /*
        1 and 2, in definition above
        3 - approach:
                1.create a frequency collection, to have the occurrence of each number.
                2.order collection in descending order
                3.iterate over collection k-1 times and create an array result[k]
                4.return result[k] 
    */


    private static void getKMostFrequent(int[] array,int k){

        int[] result = new int[k];

        Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < array.length; i++){
            int current = array[i];
            if(frequencyMap.containsKey(current)){
                frequencyMap.put(current,frequencyMap.get(current) + 1);
            } else{
                frequencyMap.put(current, 1);
            }
        }

        frequencyMap.entrySet().stream()
            .sorted(
                (k1,k2) -> -k1.getValue().compareTo(k2.getValue()))
            .forEach(
                m -> System.out.println(m.getValue() + " : " + m.getKey()));

        //int max_number = 0;
        //int max_frequency = -1;
        //
        //Iterator itr = frequencyMap.entrySet().iterator();
        //do {
        //    frequencyMap.containsValue(arg0) 
        //}while (itr.hasNext());



    }
    public static void main(String[] args){
        
        int[] array = new int[]{1,1,1,7,7,7,9,9,9,9,7,5,6,5};
        int k = 2;

        getKMostFrequent(array,k);

        String A = "hello";
        String B = "Java";
        A = A.substring(0,1).toUpperCase() + A.substring(1).toLowerCase();
        System.out.println(A.compareToIgnoreCase(B));
        System.out.println(B.compareToIgnoreCase("a"));
        



    }


    
}
