public class E43_ReverseOrderOfWords {
    public static void reverseOrderOfWords(char[] chars) {
        reverse(chars, 0, chars.length);

        int from = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, from, i);
                from = i + 1;
            }
        }
    }

    public static void reverse(char[] chars, int from, int to) {
        for (int i = from, j = to - 1; i < j ; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }

    public static void main(String[] args) {
        char[] chars = "a possible optimized way to remove things from the symbol table".toCharArray();
        print(chars);

        reverseOrderOfWords(chars);
        print(chars);
    }

    private static void print(char[] chars) {
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
    }
}
