public class E42_NumberIsPowerOf2 {
    public static boolean isPowOf2(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1040; i++) {
            if (isPowOf2(i)) {
                System.out.println("i = " + i);
            }
        }
    }
}
