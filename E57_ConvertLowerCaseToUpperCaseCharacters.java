public class E57_ConvertLowerCaseToUpperCaseCharacters {
    private static void toUpperCase(char[] chars) {
        int bitMask = Integer.parseInt("1011111", 2);

        for (int i = 0; i < chars.length; i++) {
            chars[i] &= bitMask;
        }
    }

    public static void main(String[] args) {
        char[] chars = createChars();
        System.out.print("Initial:  ");
        printChars(chars);

        toUpperCase(chars);
        System.out.print("Shuffled: ");
        printChars(chars);
    }

    private static char[] createChars() {
        final int LETTERS_COUNT = 26;

        char[] chars = new char[LETTERS_COUNT * 2];
        chars[0] = 'A';
        chars[LETTERS_COUNT] = 'a';

        for (int i = 1; i < LETTERS_COUNT; i++) {
            chars[i] = (char) (chars[i - 1] + 1);
            chars[i + LETTERS_COUNT] = (char) (chars[i + LETTERS_COUNT - 1] + 1);
        }
        return chars;
    }

    private static void printChars(char[] chars) {
        System.out.print("[" + chars[0]);
        for (char i = 1; i < chars.length; i++) {
            System.out.print("," + chars[i]);
        }
        System.out.println("]");
    }
}
