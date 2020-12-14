package HackerRank;

import java.util.Scanner;

public class SumArraySimple {
    private static int getSum(int[] numbers) {
        
        int result = 0;
        for (int i=0; i< numbers.length; i++){
            result = result + numbers[i];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){

        int n = -1;
        do{
            n = scanner.nextInt();
        }while (n < 0);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++ ){
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        System.out.println( getSum(numbers));
        
    }
}
