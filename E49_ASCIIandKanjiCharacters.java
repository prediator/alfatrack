import java.util.Arrays;

public class E49_ASCIIandKanjiCharacters {
    public static byte[] backspace(byte[] bytes, int pos) {
        int i = pos - 2;
        while (i > -1 && isFirstBit1(bytes[i])) {
            i--;
        }
        i++;
        
        int removeFrom = 0;
        int removeLen = 0;
        
        while (i < pos) {
            removeFrom = i;
            removeLen = isFirstBit1(bytes[i]) ? 2 : 1;
            i += removeLen;
        }
        
        return removeBytes(bytes, removeFrom, removeLen);
    }

    public static boolean isFirstBit1(byte b) {
        return (b & 0x80) == 0x80;
    }
    
    public static byte[] removeBytes(byte[] bytes, int removeFrom, int removeLen) {
        byte[] resultBytes = new byte[bytes.length - removeLen];
        
        if (removeFrom > 0) {
            System.arraycopy(bytes, 0, resultBytes, 0, removeFrom);
        }
        int secondFrom = removeFrom + removeLen;
        if (secondFrom < bytes.length) {
            System.arraycopy(bytes, secondFrom, resultBytes, removeFrom, bytes.length - secondFrom);
        }
        return resultBytes;
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[] {
                (byte) 0xFF, //1
                (byte) 0x8A, //1
                (byte) 0x36, //0
                (byte) 0xB3, //1
                (byte) 0x0D, //0
                (byte) 0x54, //0
        };
        printArray(bytes);
        
        printArray(backspace(bytes, 2));
        printArray(backspace(bytes, 3));
        printArray(backspace(bytes, 5));
    }

    public static void printArray(byte[] bytes) {
        System.out.print(toString(bytes[0]));
        for (int i = 1; i < bytes.length; i++) {
            System.out.print("," + toString(bytes[i]));
        }
        System.out.println();
    }
    
    private static String toString(byte b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0x80; i > 0; i /= 2) {
            builder.append((b & i) == 0 ? '0' : '1');
        }
        return builder.toString();
    }
}
