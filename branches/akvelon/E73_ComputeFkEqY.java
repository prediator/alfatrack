/**
 * A mistake in statement of a problem is found.
 * The correct statement of a problem is the following:
 * Let f(k) = y where k is the y-th number in the increasing sequence of non-negative
 * integers with the same number of ones in its binary representation as k,             <<-- y changed to k
 * e.g. f(0) = 1, f(1) = 1, f(2) = 2, f(3) = 1, f(4) = 3, f(5) = 2, f(6) = 3 and so on.
 * Given k >= 0, compute f(k).
 */
public class E73_ComputeFkEqY {
    public static int f(int k) {
        int y = 1;
        int ones = countOnes(k);
        while (--k > 0) {
            if (ones == countOnes(k)) {
                y++;
            }
        }
        return y;
    }

    public static int countOnes(int n) {
        n = n - ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        return (((n + (n >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }

    public static void main(String[] args) {
        for (int k = 0; k < 20; k++) {
            System.out.println("f(" + k + ") = " + f(k));
        }
    }
}
