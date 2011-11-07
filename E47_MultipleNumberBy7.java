public class E47_MultipleNumberBy7 {
    public static int multiplyBy7(int x) {
        return x = (x << 3) - x;
    }
    
    public static void main(String[] args) {
        test(0);
        test(1);
        test(7);
        test(1000);
        test(12345);
        test(33333333);
    }

    public static void test(int x) {
        System.out.println(x + " * 7 = " + multiplyBy7(x));
    }
}
