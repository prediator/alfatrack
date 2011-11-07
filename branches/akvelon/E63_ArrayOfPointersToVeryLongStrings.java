
public class E63_ArrayOfPointersToVeryLongStrings {
    public static Result findPointers(String[] strings) {
        Result result = new Result();
        
        int largestLen = strings[0].length();
        int smallestLen = largestLen;
        
        for (int i = 1; i < strings.length; i++) {
            int len = strings[i].length();
            
            if (len > largestLen) {
                result.largestPosition = i;
            } else if (len < smallestLen) {
                result.smallestPosition = i;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(findPointers(createArray()));
    }
    
    public static class Result {
        int largestPosition;
        int smallestPosition;
        
        @Override
        public String toString() {
            return "largestPosition = " + largestPosition + ", smallestPosition = " + smallestPosition;
        }
    }
    
    public static String[] createArray() {
        return new String[] {
                "a",
                "b",
                "cc",
                "d",
                "",
                "e",
                "f"
        };
    }
}
