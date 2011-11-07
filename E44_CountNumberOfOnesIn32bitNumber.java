public class E44_CountNumberOfOnesIn32bitNumber {
    public static int countOnesLoop(int n) {
        int count = 0;
        for (; n > 0; n >>= 1) {
            count += n & 1;
        }
        return count;
    }

    public static int countOnesRecursive(int n) {
        int count = 0;
        for (; n > 0; count++) {
            n &= (n-1);
        }
        return count;
    }

    public static int countOnesFast(int n) {
        n = n - ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        return (((n + (n >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }

    public static void main(String[] args) {
        check("000100101001011"); // 6
        check("100000001001010000"); // 4
        check("0");
        check("1");
        check("00111111111111111111111111111111"); // 30
    }

    private static void check(String binaryString) {
        int n = Integer.parseInt(binaryString, 2);

        int loop = countOnesLoop(n);
        int recur = countOnesRecursive(n);
        int fast = countOnesFast(n);

        System.out.println(binaryString + ": " + loop + " | " + recur + " | " + fast);
    }
}
