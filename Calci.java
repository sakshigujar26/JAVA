import java.util.Scanner;

class Calci {
    public static double Add(double num1, double num2) {
        return num1 + num2;      //add
    }

    public static double Sub(double num1, double num2) {
        return num1 - num2;    //sub
    }

    public static double Multiplication(double num1, double num2) {
        return num1 * num2;   //multi
    }

    public static double Division(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;    // division
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

   

    public static double modulo(double num1, double num2) {
        if (num2 != 0) {
            return num1 % num2;     //modulo
        } else {
            return -1;
        }
    }

    public static double square(double num1) {
        return num1 * num1;    //square
    }

    public static double cube(double num1) {
        return num1 * num1 * num1;      //cube
    }

   public static double squareRoot(double num1) {
        if (num1 >= 0) {
            return Math.sqrt(num1);        // sq.root
        } else {
            throw new IllegalArgumentException("Square root of a negative number is not defined");
        }
    }

    public static double cubeRoot(double num1) {
        return Math.cbrt(num1);        //cuberoot
    }

    public static double power(double x, int n) {
        return Math.pow(x, n);     //power
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;     //factorial
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long calculateNCr(int n, int r) {
        long numerator = 1;        //ncr
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
        long denominator = 1;    //npr

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
        return Math.log(x) / Math.log(base);         //log
    }

    public static double reciprocal(double n) {
        return 1.0 / n;       //reciprocal
    }

    public static double inverse(double n) {
        return 1.0 / n;     //inverse
    }

    public static double nthRoot(double x, double n) {
        return Math.pow(x, 1.0 / n);     //nthroot
    }

    public static double eth(int n) {
        return Math.exp(n);        //ethroot
    }

    public static double sin(double angle) {
        return Math.sin(angle);      //sin
    }

    public static double cos(double angle) {
        return Math.cos(angle);    //cos
    }

    public static double tan(double angle) {
        return Math.tan(angle);     //tan
    }

    public static double cot(double angle) {
        return 1.0 / Math.tan(angle);    //cot
    }

    public static double cosec(double angle) {
        return 1.0 / Math.sin(angle);    //cosec
    }

    public static double sec(double angle) {
        return 1.0 / Math.cos(angle);     //sec
    }
public static int convertDecimalToHexadecimal(int decimal) {
        int hexadecimal = 0;        //DectoHex
        int i = 1;

        while (decimal != 0) {
            int remainder = decimal % 16;
            hexadecimal += remainder * i;
            decimal /= 16;
            i *= 10;
        }

        return hexadecimal;
    }

    public static int convertDecimalToBinary(int decimal) {
        int binary = 0;
        int i = 1;                                        //DecToBin

        while (decimal != 0) {
            int remainder = decimal % 2;
            binary += remainder * i;
            decimal /= 2;
            i *= 10;
        }
        return binary;
    }
    public static int convertBinaryToDecimal(int binary) {
    int decimal = 0;
    int power = 0;                                        //BinToDeci
    while (binary != 0) {
        int digit = binary % 10;
        decimal += digit * Math.pow(2, power);
        binary /= 10;
        power++;
    }
    return decimal;
}

public static String convertBinaryToHexadecimal(int binary) {
    int decimal = convertBinaryToDecimal(binary);       //BinToHex
    return Integer.toHexString(decimal);
}
  public static int convertOctalToDecimal(int octal) {
    int decimal = 0;                       //OctToDec
    int power = 0;
    while (octal != 0) {
        int digit = octal % 10;
        decimal += digit * Math.pow(8, power);
        octal /= 10;
        power++;
    }
    return decimal;
}
}
public static double mean(double[] values) {
        double sum = 0;
        for (double value : values) {              //mean
            sum += value;
        }
        return sum / values.length;
    }

    public static double median(double[] values) {
        Arrays.sort(values);               //median
        if (values.length % 2 == 0) {
            return (values[values.length / 2 - 1] + values[values.length / 2]) / 2.0;
        } else {
            return values[values.length / 2];
        }
    }

    public static double variance(double[] values) {
        double mean = mean(values);        //variance
        double sumSquaredDiff = 0;
        for (double value : values) {
            sumSquaredDiff += (value - mean) * (value - mean);
        }
        return sumSquaredDiff / values.length;
    }
public static double standardDeviation(double[] values) {
        return Math.sqrt(variance(values));   //stddevi
    }
public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];         //matrix+
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];        //matrix-
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {                 //matrx*
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }


