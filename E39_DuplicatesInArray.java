public class E39_DuplicatesInArray {
    public static boolean duplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int n = Math.abs(arr[i]);
            if (arr[n] < 0) {
                return true;
            }
            arr[n] = -arr[n];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 3, 5, 6, 7, 0, 1};
        System.out.println(duplicates(arr));
    }
}
