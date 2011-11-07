public class E72_SetHighestSignificantBitToZero {
    public static int setMsbToZero(int n) {
        int i = n;
        i |= (n >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return n & (i >> 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(Integer.toBinaryString(i) + " -> " + Integer.toBinaryString(setMsbToZero(i)));
        }
    }
}
