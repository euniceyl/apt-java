import java.util.ArrayList;

public class TxMsg {

    public static void main(String[] args) {
        TxMsg abc = new TxMsg();
        String original = "text message";
        String output = abc.getMessage(original);
        System.out.println(output);
    }
    
    public String getMessage(String original) {
        String[] data = original.split(" ");
        String[] ret = new String[data.length];

        for (int k=0; k<data.length; k++) {
            ret[k] = convert(data[k]);
        }
        return String.join(" ", ret);
    }

    public String convert(String word) {
        char[] character = word.toCharArray();
        ArrayList<Character> set = new ArrayList<>();
        ArrayList<Character> vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        boolean hasConsonant = false;
        for (int i=0; i<character.length; i++) {
            if (!vowel.contains(character[i])) {
                hasConsonant = true;
            }
        }
        if (hasConsonant == false) {
            return word;
        }

        for (int i=0; i<character.length-1; i++) {
            if ((!vowel.contains(character[i])) && (!vowel.contains(character[i+1]))){
                character[i+1] = '\0';
            }
        }

        for (int i=0; i<character.length; i++) {
            if (vowel.contains(character[i])) {
                character[i] = '\0';
            }
        }

        String convertedWord = "";
        for (int k=0; k<character.length; k++) {
            if (character[k] != '\0') {
                convertedWord = convertedWord + character[k];
            }
        }
        return convertedWord;
    }
}