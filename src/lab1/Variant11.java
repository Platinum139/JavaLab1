package lab1;

public class Variant11 {

    /*
    A, B = numbers, not zero
    find an addition, a subtraction, a multiplication and a division of |A| and |B|
     */
    public double[] beginTask(double a, double b) {

        assert (a != 0) && (b != 0) : "Arguments  should not be equal 0 ";
        return new double[]{Math.abs(a) + Math.abs(b), Math.abs(a) - Math.abs(b),
            Math.abs(a) * Math.abs(b), Math.abs(a) / Math.abs(b)};
    }

    /*
    find the sum and the multiplication of digits
     */
    public int[] integerTask(int k) {
        int[] d = new int[2];
        d[0] = 0;
        d[1] = 1;
        for (int i = 0; i < 3; i++) {
            int tmp = k - (k / 10 * 10);
            k /= 10;
            d[0] += tmp;
            d[1] *= tmp;
        }
        return d;
    }

    /*
    a, b - integer numbers
    check if a and b are two even, or two odd
     */
    public boolean booleanTask(int a, int b) {
        return ((a % 2 == 0 && b % 2 == 0)
                || (a % 2 != 0 && b % 2 != 0));
    }

    /*
    A, B - integers
    if A = B, set A and B equal zero
    else set A and B equal the biggest number
     */
    public int[] ifTask(int a, int b) {
        int[] res = new int[2];
        res[0] = res[1] = (a == b) ? 0 : (a > b) ? a : b;
//        if (a == b) {
//            res[0] = res[1] = 0;
//        } else if (a > b) {
//            res[0] = res[1] = a;
//        } else {
//            res[0] = res[1] = b;
//        }
        return res;
    }

    /*
    'N', 'W', 'E', ’S' - directions
     2 - turn 180
     1 - turn left
    -1 - turn right
    Arguments: C - direction, k1, k2 - integers
    return a direction after doing instructons
     */
    public char switchTask(char c, int k1, int k2) {

        int k[] = new int[]{k1, k2};
        char res = c;
        for (int i = 0; i < k.length; i++) {
            switch (k[i]) {
                case 2:
                    switch (res) {
                        case 'N':
                            res = 'S';
                            break;
                        case 'S':
                            res = 'N';
                            break;
                        case 'W':
                            res = 'E';
                            break;
                        case 'E':
                            res = 'W';
                            break;
                    }
                    break;
                case 1:
                    switch (res) {
                        case 'N':
                            res = 'W';
                            break;
                        case 'S':
                            res = 'E';
                            break;
                        case 'W':
                            res = 'S';
                            break;
                        case 'E':
                            res = 'N';
                            break;
                    }
                    break;
                case -1:
                    switch (res) {
                        case 'N':
                            res = 'E';
                            break;
                        case 'S':
                            res = 'W';
                            break;
                        case 'W':
                            res = 'N';
                            break;
                        case 'E':
                            res = 'S';
                            break;
                    }
                    break;
            }
        }
        return res;
    }

    /*
    k - integer, n > 0
    find a sum 
    n^2 + (n+1)^2 + ... + (2n)^2
     */
    public int forTask(int n) {
        assert (n > 0) : "n > 0";
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += (n + i) * (n + i);
        }
        return sum;
    }

    /*
    n - integer, n > 1
    find the lowest integer k, that 1 + 2 + ... + k >= n
    and find sum
     */
    public int[] whileTask(int n) {
        assert (n > 1) : "n > 1";
        int sum = 0;
        int k = 1;
        while (sum < n) {
            sum += k++;
        }
        return new int[]{--k, sum};
    }

    /*
    arr - array
    n - size of array
    find minimum of elements with even numbers (A2, A4, A6, ...)
     */
    public int arrayTask(int arr[]) {

        int min = arr[1];
        for (int i = 1; i < arr.length - 1; i += 2) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /*
    matrix M * N
    N, M - even number
    exchange the upper left and the lower right quarters of matrix
     */
    public int[][] matrixTask(int[][] matrix) {

        assert (matrix.length % 2 == 0) : "count of rows should be even";
        for (int i = 0; i < matrix.length; i++) {
            assert (matrix[i].length % 2 == 0) : "count of columns should be even";
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i + matrix.length / 2][j + matrix[i].length / 2];
                matrix[i + matrix.length / 2][j + matrix[i].length / 2] = tmp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("Variant 11");
    }
}
