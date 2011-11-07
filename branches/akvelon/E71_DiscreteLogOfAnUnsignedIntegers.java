public class E71_DiscreteLogOfAnUnsignedIntegers {
    public static int log(int x) {
        int i = x;
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        i = (0xAAAAAAAA & i) >> 1 + (0x55555555 & i);
        i = (0xCCCCCCCC & i) >> 2 + (0x33333333 & i);
        i = (0xF0F0F0F0 & i) >> 4 + (0x0F0F0F0F & i);
        i = (0xFF00FF00 & i) >> 8 + (0x00FF00FF & i);
        i = (i >> 16) + (0x0000ffff & i);
        return i;
    }

    public static void main(String[] args) {
        for (int x = 0; x < 30; x++) {
            System.out.println("log(" + x + ") = " + log(x));
        }
    }
}
