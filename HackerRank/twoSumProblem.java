package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class twoSumProblem {
    
    private static void getTwoNumSum(int[] nums, int target) {

        Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        List<int[]> result =  new ArrayList<int[]>();

        //look for the complement of the sum (target -num[i] == num in map) 
        //if found add pair to list
        //if not add the number to map
        for (int i = 0; i < nums.length; i++){
            int complement = target -nums[i];

            if ( numsMap.containsKey(complement)){
                int[] pair =new int[]{nums[i],complement}; 
                result.add(pair);
            }else {
                numsMap.put(nums[i],i);
            }
        }

        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));    
        }
    }

    private static void getTwoNumSumWindowApproach(int[] nums, int target) {
        List<int[]> result =  new ArrayList<int[]>();

        //for the two windows approach, we need to sort the array and compare both ends,
        //if the sum of them is less than target then it means that left end is too small
        //then we increase one possition in the left, otherwise we decrement right

        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] == target){
                int[] pair = new int[]{nums[right],nums[left]};
                result.add(pair);
                left++;
            }else if (nums[left] + nums[right] < target){
                left++;
            }else {
                right--;
            }
        }

        //print result
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));    
        }
    }


    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        int n = keyboard.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++){
            nums[i] = keyboard.nextInt();         
        }

        int target = keyboard.nextInt();

        keyboard.close();
        
        getTwoNumSum(nums,target);

        getTwoNumSumWindowApproach(nums,target);

    }

}
