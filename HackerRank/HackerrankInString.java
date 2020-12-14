package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.print.event.PrintJobListener;

public class HackerrankInString {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        Character[] hackerRanck = {'H','A','C','K','E','R','R','A','N','K'};
        int j=0;
        for (int i=0; i < s.length()-1;i++){
            if(hackerRanck[j] == Character.toUpperCase(s.charAt(i))){
                j++;
            }
            if (j == hackerRanck.length -1){
                return "YES";
            }
        }
        return "NO";
               

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            if (s.length()>10000){
                return;
            }
            System.out.println(hackerrankInString(s));

        }

        scanner.close();
    }
}
