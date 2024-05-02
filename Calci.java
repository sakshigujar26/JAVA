import java.util.Scanner;

class Calci {
    public static double Add(double num1, double num2) {
        return num1 + num2;
    }

    public static double Sub(double num1, double num2) {
        return num1 - num2;
    }

    public static double Multiplication(double num1, double num2) {
        return num1 * num2;
    }

    public static double Division(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return -1;
        }
    }

    public static double modulo(double num1, double num2) {
        if (num2 != 0) {
            return num1 % num2;
        } else {
            return -1;
        }
    }

    public static double square(double num1) {
        return num1 * num1;
    }

    public static double cube(double num1) {
        return num1 * num1 * num1;
    }

    public static double squareRoot(double num1) {
        if (num1 >= 0) {
            return Math.sqrt(num1);
        } else {
            return -1;
        }
    }

    public static double cubeRoot(double num1) {
        return Math.cbrt(num1);
    }

    public static double power(double x, int n) {
        return Math.pow(x, n);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long calculateNCr(int n, int r) {
        long numerator = 1;
        long denominator = 1;

        // Calculate numerator (n!)
        for (int i = 1; i <= n; i++) {
            numerator *= i;
        }

        // Calculate denominator (r!)
        for (int i = 1; i <= r; i++) {
            denominator *= i;
        }

        // Calculate denominator ((n-r)!)
        for (int i = 1; i <= n - r; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }

    public static long calculateNPr(int n, int r) {
        long numerator = 1;
        long denominator = 1;

        // Calculate numerator (n!)
        for (int i = 1; i <= n; i++) {
            numerator *= i;
        }

        // Calculate denominator ((n-r)!)
        for (int i = 1; i <= n - r; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }

    public static double customLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }

    public static double reciprocal(double n) {
        return 1.0 / n;
    }

    public static double inverse(double n) {
        return 1.0 / n;
    }

    public static double nthRoot(double x, double n) {
        return Math.pow(x, 1.0 / n);
    }

    public static double eth(int n) {
        return Math.exp(n);
    }

    public static double sin(double angle) {
        return Math.sin(angle);
    }

    public static double cos(double angle) {
        return Math.cos(angle);
    }

    public static double tan(double angle) {
        return Math.tan(angle);
    }

    public static double cot(double angle) {
        return 1.0 / Math.tan(angle);
    }

    public static double cosec(double angle) {
        return 1.0 / Math.sin(angle);
    }

    public static double sec(double angle) {
        return 1.0 / Math.cos(angle);
    }
// integration
