public class Recursive {
    /*
    *
    * An example input arrary {1,2,3,4,5,6,7,8,9,10}, called with k=2, should output 9753
    */

    private static int d = 0;
    private static void printEveryOther(final int[] ia, final int k) {
        if (ia.length == 0 || ia == null) {
            System.err.println("This array is empty");
        } else if (ia.length < k) {
            System.err.println("Cannot be smaller than K  " + ia.length);
        } else if (k < 0) {
            System.err.println("If K is < 0");
        } else if (ia.length - k < 2) {
            System.out.println("null");
        } else if (ia.length - (2 * (d + 1)) >= (k - d)) {
            System.out.print(ia[ia.length - (2 * (d + 1))]);
            d++;
            printEveryOther(ia, k + 1);
        }


}
    /*
    * recursively take in a string and place a * between adjacent letters that are the same
    * An example input String "hello" should return hel*lo.
    */private static String printStars(final String s) {

        if (s == null || s.length() <= 1) {
            return s;}

        if (s.charAt(1) == s.charAt(0)) {
            return s.charAt(0)+ "*" + printStars(s.substring(1));
        }

        else return s.charAt(0) + printStars(s.substring(1));


    }

    public static void main(String[] args) {
        printEveryOther(new int[]{1,2,3,4,5,6,7,8,9,10}, 2);
        System.out.println(printStars("Helllloooiiiuuuo"));


    }
}