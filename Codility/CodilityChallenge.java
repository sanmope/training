package Codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CodilityChallenge {
    //is S smaller than 200000?
        //only letters? 
            //split string in only letters substring.            
            //count letters both upper and lower
            //if both cases bubbleSort alphabeticaly largest
            //return largest in uppercase 
    //}

    public static class Letter{
        boolean bothCases = false;
        boolean upperCase=false;
        boolean lowerCase=false;
        Character name;        

        public Letter(Character name){
            this.name=Character.toUpperCase(name);
            if (Character.isLowerCase(name)){
                upperCase = true;
            }else{
                lowerCase = true;
            }
        }

        public Character getName(){
            return Character.toUpperCase(this.name);
        }

        public boolean isBothCases(){
            return bothCases;
        }

        public boolean incrementOccurrence (Character name){
            if (Character.isLowerCase(name)){
                upperCase = true;
            }else{
                lowerCase = true;
            }
            if (lowerCase == true && upperCase == true){
                bothCases= true;
            }
            return bothCases;
        }

    } 


    public boolean isOnlyLetters(String S){
        if (S==null){
            return false;
        }

        for (int i=0; i < S.length();i++){
            if (Character.isLetter(S.charAt(i))){
                return false;
            }
        }

        return true;

    }

    public static String solution(String S) {
        int maxSize = 200000;

        if (S.length() > maxSize) {
            return "NO";
        } else if (S.isEmpty() || S.isEmpty()) {
            return "NO";
        }

        List<Letter> letters = new ArrayList<Letter>();

        for (int i = 0; i < S.length(); i++) {
            //if (Character.isLetter(S.charAt(i))) {
            //    return "NO";
            //} else {

                if (letters.size()==0){
                    letters.add(new Letter(S.charAt(i)));
                }
            
                for (Letter letter : letters) {
                    if (letter.getName() == Character.toUpperCase(S.charAt(i))) {
                        letter.incrementOccurrence(S.charAt(i));
                    } else {
                        letters.add(new Letter(S.charAt(i)));
                        break;
                    }
                }
            //}
        }

        List<Letter> sorted = letters.stream().filter(letter -> letter.isBothCases() == true)
                .sorted((l1, l2) -> l1.getName().compareTo(l2.getName())).collect(Collectors.toList());
        return sorted.get(0).getName().toString();
    }

    public static void main(String[] args) {

        String S = "AbcBadh";
        String S1 = "AbcAdh";
        String S2 = "WeTestcodErs";
        String S3 = "Codility";

        System.out.println(solution(S));
        System.out.println(solution(S1));
        System.out.println(solution(S2));
        System.out.println(solution(S3));

    }
}
