public class AccessLevel {
    public static void main(String[] args) {
        AccessLevel abc = new AccessLevel();
        int[] rights = {34,78,9,52,11,1};
        int minPermission = 49;
        String output = abc.canAccess(rights, minPermission);
        System.out.println(output);
    }

    public String canAccess(int[] rights, int minPermission) {
        String permission = "";
        for (int k = 0; k < rights.length; k += 1) {
            if (rights[k] >= minPermission) {
                permission += "A";
            }
            else {
                permission += "D";
            }
        }
        return permission;
 }
}
