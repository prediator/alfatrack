public class E52_DiffOfS1andS2strings {
    /**
     * lets assume that chars store 1 byte only, like in C. So we can use 256 boolean
     */
    public static Result deleteChars(String s1, String s2) {
        boolean[] boolArr256len = gatherBoolArr256len(s1);
        
        char[] newS2Chars = new char[s2.length()];
        char[] deletedChars = new char[s2.length()];
        int newS2Len = 0;
        int deletedLen = 0;
        
        for (int i = 0; i < s2.length(); i++) {
            char s2Char = s2.charAt(i);
            
            if (boolArr256len[s2Char]) {
                deletedChars[deletedLen++] = s2Char;
            } else {
                newS2Chars[newS2Len++] = s2Char;
            }
        }
        
        Result result = new Result();
        result.s2afterDeletion = new String(newS2Chars, 0, newS2Len);
        result.deletedCharsFromS2 = new String(deletedChars, 0, deletedLen);
        return result;
    }
    
    private static boolean[] gatherBoolArr256len(String s1) {
        boolean[] s1b = new boolean[256];
        for (int i = 0; i < s1.length(); i++) {
            s1b[s1.charAt(i)] = true;
        }
        return s1b;
    }

    public static void main(String[] args) {
        String s1 = "dfgh";
        String s2 = "dfkjshdglg";
        System.out.println("before deletion: " + s2);
        System.out.println("chars to delete: " + s1);
        
        Result result = deleteChars(s1, s2);
        System.out.println("after deletion: " + result.s2afterDeletion);
        System.out.println("deleted chars: " + result.deletedCharsFromS2);
    }
    
    public static class Result {
        String s2afterDeletion;
        String deletedCharsFromS2;
    }
}
