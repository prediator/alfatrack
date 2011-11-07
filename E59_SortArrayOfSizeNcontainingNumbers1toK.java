public class E59_SortArrayOfSizeNcontainingNumbers1toK {
    public static void sort(int[] arr, int k) {
        int[] arrK = new int[k + 1];

        for (int i = 0; i < arr.length; i++) {
            arrK[arr[i]]++;
        }

        int i = 0;
        for (k = 0; k < arrK.length; k++) {
            for (int j = 0; j < arrK[k]; j++) {
                arr[i++] = k;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,7,2,3,8,7,2,3,0,1,2,3,5,4,8,9,0,4,3,5,4,6,7,8,1,3,1,0,2,9,3,4,6,4,0,0,6,7,5,2};
        printArray(arr);
        sort(arr, 9);
        printArray(arr);

        arr = new int[]{8,3,2,6,8};
        printArray(arr);
        sort(arr, 9);
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
