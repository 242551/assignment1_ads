import java.util.Scanner;

// Решения задач на рекурсию и массивы
public class TaskSolutions {

    // Task 1: Minimum of array
    public static int findMin(int[] arr) {
        int min = arr[0];  // инициализируем первым элементом как минимальный
        for (int i = 1; i < arr.length; i++) {  // проходим по массиву
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min; // Time Complexity: O(n)
    }

    // Task 2: Average of array
    public static double findAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) { // суммируем все элементы
            sum += num;
        }
        return (double) sum / arr.length; // Time Complexity: O(n)
    }

    // Task 3: Check if number is prime
    public static boolean isPrime(int n, int divisor) {
        if (n <= 1) return false; // 0 и 1 не простые
        if (divisor == 1) return true; // если делителей не нашли — простое
        if (n % divisor == 0) return false; // найден делитель — составное
        return isPrime(n, divisor - 1); // рекурсивно уменьшаем делитель
    }

    // Task 4: Factorial
    public static long factorial(int n) {
        if (n <= 1) return 1; // базовый случай
        return n * factorial(n - 1); // рекурсивный вызов
    }

    // Task 5: Fibonacci
    public static int fibonacci(int n) {
        if (n == 0) return 0; // базовый случай
        if (n == 1) return 1; // базовый случай
        return fibonacci(n - 1) + fibonacci(n - 2); // рекурсия
    }

    // Task 6: Power a^n
    public static long power(int a, int n) {
        if (n == 0) return 1; // любое число в степени 0 = 1
        return a * power(a, n - 1); // рекурсивное умножение
    }

    // Task 7: Reverse array
    public static void printReverse(int[] arr, int index) {
        if (index < 0) return; // базовый случай
        System.out.print(arr[index] + " ");
        printReverse(arr, index - 1); // двигаемся назад по массиву
    }

    // Task 8: Check if all characters are digits
    public static boolean isAllDigits(String s, int index) {
        if (index == s.length()) return true; // дошли до конца — все цифры
        if (!Character.isDigit(s.charAt(index))) return false; // если хотя бы 1 не цифра
        return isAllDigits(s, index + 1); // проверяем следующий символ
    }

    // Task 9: Binomial coefficient C(n, k)
    public static int binomialCoeff(int n, int k) {
        if (k == 0 || k == n) return 1; // базовые случаи
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k); // рекурсивная формула
    }

    // Task 10: GCD (Наибольший общий делитель)
    public static int gcd(int a, int b) {
        if (b == 0) return a; // базовый случай
        return gcd(b, a % b); // Евклидов алгоритмf
    }

    // Точка входа в программу
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1
        System.out.print("Task 1: Enter array size: ");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];
        System.out.println("Enter elements:");
        for (int i = 0; i < n1; i++) array1[i] = scanner.nextInt();
        System.out.println("Min = " + findMin(array1));

        // Task 2
        System.out.print("Task 2: Enter array size: ");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];
        System.out.println("Enter elements:");
        for (int i = 0; i < n2; i++) array2[i] = scanner.nextInt();
        System.out.println("Average = " + findAverage(array2));

        // Task 3
        System.out.print("Task 3: Enter a number to check prime: ");
        int num3 = scanner.nextInt();
        System.out.println("Is prime? " + (isPrime(num3, num3 - 1) ? "Composite" : "No"));

        // Task 4
        System.out.print("Task 4: Enter a number to calculate factorial: ");
        int num4 = scanner.nextInt();
        System.out.println(num4 + "! = " + factorial(num4));

        // Task 5
        System.out.print("Task 5: Enter index for Fibonacci: ");
        int num5 = scanner.nextInt();
        System.out.println("Fibonacci(" + num5 + ") = " + fibonacci(num5));

        // Task 6
        System.out.print("Task 6: Enter base a: ");
        int base = scanner.nextInt();
        System.out.print("Enter exponent n: ");
        int exponent = scanner.nextInt();
        System.out.println(base + "^" + exponent + " = " + power(base, exponent));

        // Task 7
        System.out.print("Task 7: Enter array size: ");
        int n7 = scanner.nextInt();
        int[] array7 = new int[n7];
        System.out.println("Enter elements:");
        for (int i = 0; i < n7; i++) array7[i] = scanner.nextInt();
        System.out.print("Reverse: ");
        printReverse(array7, n7 - 1);
        System.out.println();

        // Task 8
        System.out.print("Task 8: Enter a string to check digits: ");
        String inputString = scanner.next();
        System.out.println("Is all digits? " + (isAllDigits(inputString, 0) ? "Yes" : "No"));

        // Task 9
        System.out.print("Task 9: Enter n for C(n, k): ");
        int n9 = scanner.nextInt();
        System.out.print("Enter k: ");
        int k9 = scanner.nextInt();
        System.out.println("C(" + n9 + "," + k9 + ") = " + binomialCoeff(n9, k9));

        // Task 10
        System.out.print("Task 10: Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.println("GCD(" + a + "," + b + ") = " + gcd(a, b));
    }
}



