public class E54_PrintOut2dArrayInSpiralOrder {
    public static void printSpiral(int[][] arr) {
        printSpiral(arr, 0, arr.length - 1, 0, arr[0].length - 1);
        System.out.println();
    }

    public static void printSpiral(int[][] arr, int i1, int i2, int j1, int j2) {
        if (i1 <= i2 && j1 <= j2 ) {
            int i = i1, j = j1;

            for (; i < i2; i++) {
                System.out.print(arr[i][j]);
            }
            for (; j < j2; j++) {
                System.out.print(arr[i][j]);
            }

            if (i1 < i2 && j1 < j2 ) {
                for (; i > i1; i--) {
                    System.out.print(arr[i][j]);
                }
                for (; j > j1; j--) {
                    System.out.print(arr[i][j]);
                }
            }
            printSpiral(arr, i1 + 1, i2 - 1, j1 + 1, j2 - 1);
        }
    }

    public static void main(String[] args) {
        printSpiral(new int[][]{
                {1, 12, 11, 10, 9},
                {2, 13, 14, 15, 8},
                {3, 4, 5, 6, 7}
        });
        printSpiral(new int[][]{
                {1, 8},
                {2, 7},
                {3, 6},
                {4, 5}
        });
    }
}
