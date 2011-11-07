import java.util.Arrays;
import java.util.Random;

public class E62_RandForArrayOfIntegersOfSizeN {
    public static int[] randomPermutation(int[] arr) {
        Random random = new Random();
        int n = arr.length;
        
        int j = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            while ((j = random.nextInt(n)) > i) {
                swap(arr, j, i);
            }
        }
        
        return arr;
    }

    public static void swap(int[] arr, int j, int i) {
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        printArray(arr);
        
        arr = randomPermutation(Arrays.copyOf(arr, arr.length));
        printArray(arr);
        arr = randomPermutation(Arrays.copyOf(arr, arr.length));
        printArray(arr);
        arr = randomPermutation(Arrays.copyOf(arr, arr.length));
        printArray(arr);
        arr = randomPermutation(Arrays.copyOf(arr, arr.length));
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
