import java.util.*;

public class Encryption {
    public static void main(String[] args) {
        Encryption abc = new Encryption();
        String message = "hello";
        String output = abc.encrypt(message);
        System.out.println(output);
    }

    public String encrypt(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] wordChar = message.toCharArray();
        char[] alphabetChar = alphabet.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        int j=0;
        for (int i=0; i<wordChar.length; i++) {
            if (!map.containsKey(wordChar[i])) {
                map.put(wordChar[i], alphabetChar[j]);
                j++;
            }
        }

        ArrayList<Character> cipher = new ArrayList<>();
        for (int k=0; k<wordChar.length; k++) {
            cipher.add(map.get(wordChar[k]));
        }

        String cipherString = new String();
        for (char s : cipher) {
            cipherString = cipherString + s;
        }
        return cipherString;
    }
}