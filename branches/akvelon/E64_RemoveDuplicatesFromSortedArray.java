import java.util.Arrays;

public class E64_RemoveDuplicatesFromSortedArray {
    public static int[] removeDuplicates(int[] arr) {
        int pos = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[pos++] = arr[i];
            }
        }
        return Arrays.copyOf(arr, pos);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,1,1,1,1,1,2,2,2,2,3,4,4,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,7,7,7,7,7,9,9,9,9};
        printArray(arr);
        
        arr = removeDuplicates(arr);
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
