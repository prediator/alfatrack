public class E41_PrintUnsignedLong {
    public static void printLong(long n, Puttable puttable) {
        int pow10 = (int) Math.round(Math.log10(n));
        long round = Math.round(Math.pow(10, pow10));

        for (; round > 0; round /= 10) {
            long toPut = n / round;
            puttable.putChar((char) (48 + toPut));
            n -= round * toPut;
        }
    }

    public interface Puttable {
        public void putChar(char c);
    }

    public static void main(String[] args) {
        printLong(1248965324098347561L, new Puttable() {
            public void putChar(char c) {
                System.out.print(c);
            }
        });
    }
}
