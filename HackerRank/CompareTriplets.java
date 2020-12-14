package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CompareTriplets {
    

    private static List<Integer> getWinnerArray(int[] alice, int[] bob) {
        
        //int[] result = new int[]{0,0};
        List<Integer> result = new ArrayList<>();

        result.add(0);
        result.add(0);
        
        for (int i = 0; i < 3; i++){
            if (alice[i] > bob[i]){
                result.set(0,result.get(0) + 1);
            }else if (alice[i] < bob[i]){
                result.set(1,result.get(1) + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
            System.out.println("first 3 elements for Alice, following 3 fo Bob:");

            Scanner keyboard = new Scanner(System.in);

            int[] alice = new int[3];
            int[] bob = new int[3];

            for (int i=0; i < 3; i++){
                alice[i] = keyboard.nextInt();
            }
            for (int i=0; i < 3; i++){
                bob[i] = keyboard.nextInt();
            }

            System.out.println("array result:");
            List<Integer> result = getWinnerArray(alice, bob);

            result.stream().forEach(s -> System.out.println(s));

            keyboard.close();

            for (int i=0; i < 6; i++){
                
                System.out.print("* " + (int) Math.pow(2,i));
            }
    }


}
