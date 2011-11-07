public class E70_ReverseBitsOfUnsignedIntegers {
    private static int reverseBits(int i) {
        i = i >> 16 | (0x0000FFFF & i) << 16;
        i = (0xFF00FF00 & i) >> 8 | (0x00FF00FF & i) << 8;
        i = (0xF0F0F0F0 & i) >> 4 | (0x0F0F0F0F & i) << 4;
        i = (0xCCCCCCCC & i) >> 2 | (0x33333333 & i) << 2;
        i = (0xAAAAAAAA & i) >> 1 | (0x55555555 & i) << 1;
        return i;
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("01111010111010100010110000111011", 2);
        System.out.println(Integer.toBinaryString(i));

        i = reverseBits(i);
        System.out.println(Integer.toBinaryString(i));
    }
}
