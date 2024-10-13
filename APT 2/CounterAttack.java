public class CounterAttack {
    public static void main(String[] args) {
        CounterAttack abc = new CounterAttack();
        String str = "a a a b b c";
        String[] words = {"d", "c", "b", "a"};
        int[] output = abc.analyze(str, words);
        System.out.println(output);
    }
    
    public int[] analyze(String str, String[] words) {
        String[] set = str.split(" ");

        int wordTimes = 0;
        int[] numberSet = new int[words.length];
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<set.length; j++) {
                if (words[i].equals(set[j])) {
                    wordTimes++;
                }
            }
            numberSet[i] = wordTimes;
            wordTimes = 0;
        }
        return numberSet;
    }
}