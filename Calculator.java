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
/*
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operation to perform:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Square");
        System.out.println("7. Cube");
        System.out.println("8. Square Root");
        System.out.println("9. Cube Root");
        System.out.println("10. Power");
        System.out.println("11. Factorial");
        System.out.println("12. nCr");
        System.out.println("13. nPr");
        System.out.println("14. Custom Log");
        System.out.println("15. Reciprocal");
        System.out.println("16. Inverse");
        System.out.println("17. Nth Root");
        System.out.println("18. Exponential");
        System.out.println("19. Sin");
        System.out.println("20. Cos");
        System.out.println("21. Tan");
        System.out.println("22. Cot");
        System.out.println("23. Cosec");
        System.out.println("24. Sec");
        System.out.println("Enter your choice:");

        int choice = scanner.nextInt();
        double result = 0;

        switch (choice) {
            case 1:
                System.out.println("Enter two numbers:");
                double add1 = scanner.nextDouble();
                double add2 = scanner.nextDouble();
                result = Add(add1, add2);
                break;
            case 2:
                System.out.println("Enter two numbers:");
                double sub1 = scanner.nextDouble();
                double sub2 = scanner.nextDouble();
                result = Sub(sub1, sub2);
                break;
            case 3:
                System.out.println("Enter two numbers:");
                double mul1 = scanner.nextDouble();
                double mul2 = scanner.nextDouble();
                result = Multiplication(mul1, mul2);
                break;
            case 4:
                System.out.println("Enter two numbers:");
                double div1 = scanner.nextDouble();
                double div2 = scanner.nextDouble();
                result = Division(div1, div2);
                break;
            case 5:
                System.out.println("Enter two numbers:");
                double mod1 = scanner.nextDouble();
                double mod2 = scanner.nextDouble();
                result = modulo(mod1, mod2);
                break;
            case 6:
                System.out.println("Enter a number:");
                double squareNum = scanner.nextDouble();
                result = square(squareNum);
                break;
            case 7:
                System.out.println("Enter a number:");
                double cubeNum = scanner.nextDouble();
                result = cube(cubeNum);
                break;
            case 8:
                System.out.println("Enter a number:");
                double sqrtNum = scanner.nextDouble();
                result = squareRoot(sqrtNum);
                break;
            case 9:
                System.out.println("Enter a number:");
                double cbrtNum = scanner.nextDouble();
                result = cubeRoot(cbrtNum);
                break;
            case 10:
                System.out.println("Enter base and power:");
                double base = scanner.nextDouble();
                int power = scanner.nextInt();
                result = power(base, power);
                break;
            case 11:
                System.out.println("Enter a number:");
                int factNum = scanner.nextInt();
                result = factorial(factNum);
                break;
            case 12:
                System.out.println("Enter n and r:");
                int n = scanner.nextInt();
                int r = scanner.nextInt();
                result = calculateNCr(n, r);
                break;
            case 13:
                System.out.println("Enter n and r:");
                int nPrN = scanner.nextInt();
                int nPrR = scanner.nextInt();
                result = calculateNPr(nPrN, nPrR);
                break;
            case 14:
                System.out.println("Enter x and base:");
                double x = scanner.nextDouble();
                double logBase = scanner.nextDouble();
                result = customLog(x, logBase);
                break;
            case 15:
                System.out.println("Enter a number:");
                double recNum = scanner.nextDouble();
                result = reciprocal(recNum);
                break;
            case 16:
                System.out.println("Enter a number:");
                double invNum = scanner.nextDouble();
                result = inverse(invNum);
                break;
            case 17:
                System.out.println("Enter x and n:");
                double nthRootX = scanner.nextDouble();
                double nthRootN = scanner.nextDouble();
                result = nthRoot(nthRootX, nthRootN);
                break;
            case 18:
                System.out.println("Enter n:");
                int ethN = scanner.nextInt();
                result = eth(ethN);
                break;
            case 19:
                System.out.println("Enter angle in radians:");
                double sinAngle = scanner.nextDouble();
                result = sin(sinAngle);
                break;
            case 20:
                System.out.println("Enter angle in radians:");
                double cosAngle = scanner.nextDouble();
                result = cos(cosAngle);
                break;
            case 21:
                System.out.println("Enter angle in radians:");
                double tanAngle = scanner.nextDouble();
                result = tan(tanAngle);
                break;
            case 22:
                System.out.println("Enter angle in radians:");
                double cotAngle = scanner.nextDouble();
                result = cot(cotAngle);
                break;
            case 23:
                System.out.println("Enter angle in radians:");
                double cosecAngle = scanner.nextDouble();
                result = cosec(cosecAngle);
                break;
            case 24:
                System.out.println("Enter angle in radians:");
                double secAngle = scanner.nextDouble();
                result = sec(secAngle);
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}

