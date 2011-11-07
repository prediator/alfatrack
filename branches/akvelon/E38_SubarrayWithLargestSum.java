public class E38_SubarrayWithLargestSum {
    public static int[] getSubArrayWithMaximumSum(int[] arr, int len) {
        int sum = 0;
        int[] subArr = new int[len];

        for (int i = 0; i < len; i++) {
            subArr[i] = arr[i];
            sum += arr[i];
        }

        int maxSum = sum;
        int firstElementOfMaxArray = 0;

        for (int i = len; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - len];
            if (sum > maxSum) {
                maxSum = sum;
                firstElementOfMaxArray = i - len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            subArr[i] = arr[i + firstElementOfMaxArray];
        }

        return subArr;
    }

    public static void main(String[] args) {
        int[] array = {31, -7, 20, -12, 6, 2, 7, 0, 5};
        int[] subArr = getSubArrayWithMaximumSum(array, 4);

        System.out.print("subArr = [" + subArr[0]);
        for (int i = 1; i < subArr.length; i++) {
            System.out.print("," + subArr[i]);
        }
        System.out.println("]");
    }
}
