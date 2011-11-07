public class E61_ComputeSumOfIntegersArray {
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; sum+=arr[i++]);
        return sum;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,5,7,8,9,6,5,7,5,3,0,1,2,4,3,7,6,5,8,9,4,5,6,0};
        
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("+" + arr[i]);
        }
        System.out.println("=" + sum(arr));
    }
}
