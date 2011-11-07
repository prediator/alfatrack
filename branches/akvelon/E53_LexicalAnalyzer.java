import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E53_LexicalAnalyzer {
    public static List<Token> analyze(char[] chars) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (j < chars.length && !isSign(chars[j])) {
                j++;
            }
            if (i < j) {
                tokens.add(new Variable(Arrays.copyOfRange(chars, i, j)));
            }
            if (j < chars.length) {
                tokens.add(new Sign(chars[j]));
                i = ++j;
            }

        }
        return tokens;
    }

    public static boolean isSign(char aChar) {
        return aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/' || aChar == '=';
    }

    public static abstract class Token {
    }

    public static class Variable extends Token {
        private char[] content;

        public Variable(char[] content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return new String(content);
        }
    }

    public static class Sign extends Token {
        private char content;

        public Sign(char content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return new String(new char[]{content});
        }
    }

    public static void main(String[] args) {
        System.out.println(analyze("a*b".toCharArray()));
        System.out.println(analyze("a1-b2*cc2=d".toCharArray()));
    }
}
