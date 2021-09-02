import java.util.Scanner;

class SimpleCalculator {
    // Implement your methods here



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();

        subtractTwoNumbers(a,b);
        sumTwoNumbers(a,b);
        divideTwoNumbers(a,b);
        multiplyTwoNumbers(a,b);
    }


    public static void subtractTwoNumbers(long a, long b) {
        System.out.println(a - b);

    }


    public static void sumTwoNumbers(long a, long b) {
        System.out.println(a + b);

    }

    public static void divideTwoNumbers(long a, long b) {

        if (a == 0 || b == 0) {
            System.out.println("Division by 0!");
        } else {
            System.out.println(a / b);
        }
    }

    public static void multiplyTwoNumbers(long a, long b) {
        System.out.println(a * b);
    }
}