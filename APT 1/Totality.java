public class Totality {
    public static void main(String[] args) {
        Totality abc = new Totality();
        int[] a = {1, 2, 3, 4, 5};
        String stype = "odd";
        int output = abc.sum(a, stype);
        System.out.println(output);
    }

    public int sum(int[] a, String stype) {
        int sum = 0;
        for (int k = 0; k < a.length; k += 1) {
            if (stype.equals("odd")) {
                if(k % 2 == 1) {
                    sum += a[k];
                }
            }
            else if (stype.equals("even")) {
                if(k % 2 == 0) {
                    sum += a[k];
                }
            }
            else if (stype.equals("all")) {
                sum += a[k];
            }
        }

        if (sum > 0) {
            return sum;
        }
        else {
            return 0;
        }
    }
}