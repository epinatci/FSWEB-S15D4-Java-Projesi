import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("Don't nod"));

        System.out.println("***********************************");

        System.out.println(checkForPalindromeFIFO("abccba"));
        System.out.println(checkForPalindromeFIFO("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeFIFO("I did, did I?"));
        System.out.println(checkForPalindromeFIFO("hello"));
        System.out.println(checkForPalindromeFIFO("Racecar"));
        System.out.println(checkForPalindromeFIFO("Don't nod"));

        System.out.println("***********************************");

        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(50));
        System.out.println(convertDecimalToBinary(44));
    }

    public static boolean checkForPalindrome(String text) {
        //h,e,l,l,o
        //o,l,l,e,h

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctuationString = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for (int i = 0 ; i<lowerCase.length() ; i++){
            char c = lowerCase.charAt(i);
            if( c >= 'a' && c <= 'z'){
                noPunctuationString.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()){
            reversed.append(stack.pop());

        }
        return noPunctuationString.toString().equals(reversed.toString());
    }

    public static boolean checkForPalindromeFIFO(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);
        for (int i = 0 ; i<lowerCase.length() ; i++){
            char c = lowerCase.charAt(i);
            if( c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int num){
        //13sayısı nasıl binarye cevrılır

        //13 % 2 = 1   6 % 2 = 0   3 % 2 = 1    1 % 2 = 1
        //13 / 2 = 6   6 / 2 = 3   3 / 2 = 1    1 / 2 = 0
        //üst satırı tersinden yazarım 1101 dir yanıt
        //1101 =1*2^3  +  1*2^2  +  0  + 1*2^0

        final int base =2 ;
        Stack digits = new Stack<>();

        while (num > 0){
            digits.push(num % base);
            num = num/2;
        }
        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        return bits;
    }
}