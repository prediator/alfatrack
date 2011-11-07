import java.util.Arrays;

public class E60_CompressArrayByRemovingDuplicates {
    public static int[] compress(int[] arr) {
        boolean[] was = new boolean[10];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!was[arr[i]]) {
                arr[pos++] = arr[i];
            }
            was[arr[i]] = true;
        }
        return Arrays.copyOf(arr, pos);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,5,7,8,9,6,5,7,5,3,0,1,2,4,3,7,6,5,8,9,4,5,6,0};
        printArray(arr);
        
        arr = compress(arr);
        printArray(arr);
    }
    
    public static void printArray(int[] arr) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("," + arr[i]);
        }
        System.out.println();
    }
}
