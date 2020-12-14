package HackerRank;

public class Strings {
    
    public static void main(String[] args){

        String numbers = "124";

        Integer lpm2 = Integer.getInteger(numbers);
        Integer lpm = new Integer(numbers);
        Integer s = Integer.valueOf(Character.toString(numbers.charAt(0)));
        Integer decode =  Integer.decode(numbers);

        System.out.println("char: " + numbers.charAt(0) + " number at: " + s + " decode: " + decode + " lpm: " + lpm + " lpm2: " + lpm2);
        System.out.println("leadingZeros: " + Integer.numberOfLeadingZeros(111111112));
        System.out.println("leadingZeros: " + Integer.numberOfTrailingZeros(000001111111));
        System.out.println("parseint: " + Integer.parseInt("1234"));
    }
}
