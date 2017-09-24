package lab1;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Variant11NGTest {

    public static double EPS = 0.0000001;

    ///////////////////////////////////////////
    @Test(dataProvider = "beginProvider")
    public void beginTest(double a, double b, double[] res) {
        double[] r = new Variant11().beginTask(a, b);
        for (int i = 0; i < r.length; i++) {
            assertEquals(r[i], res[i], EPS);
        }
    }

    @DataProvider
    public Object[][] beginProvider() {
        return new Object[][]{{6, 3, new double[]{9, 3, 18, 2}},
        {-6, 3, new double[]{9, 3, 18, 2}},
        {-6, -3, new double[]{9, 3, 18, 2}}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeBeginTest() {
        new Variant11().beginTask(8, 0);
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "integerProvider")
    public void integerTest(int k, int[] res) {
        int[] r = new Variant11().integerTask(k);
        for (int i = 0; i < r.length; i++) {
            assertEquals(r[i], res[i]);
        }
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{100, new int[]{1, 0}},
        {111, new int[]{3, 1}},
        {123, new int[]{6, 6}}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int a, int b, boolean f) {
        assertEquals(new Variant11().booleanTask(a, b), f);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{2, 4, true}, {3, 7, true}, {2, 3, false}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "ifProvider")
    public void ifTest(int a, int b, int[] res) {
        int[] r = new Variant11().ifTask(a, b);
        for (int i = 0; i < r.length; i++) {
            assertEquals(r[i], res[i]);
        }
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{{2, 2, new int[]{0, 0}},
        {3, 7, new int[]{7, 7}},
        {-5, 0, new int[]{0, 0}}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "switchProvider")
    public void switchTest(char c, int k1, int k2, char res) {
        assertEquals(new Variant11().switchTask(c, k1, k2), res);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{{'N', 2, 2, 'N'},
        {'N', 1, 1, 'S'},
        {'N', -1, 2, 'W'}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "forProvider")
    public void forTest(int n, int res) {
        assertEquals(new Variant11().forTask(n), res);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{1, 5},
        {2, 29}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, int[] res) {
        int[] r = new Variant11().whileTask(n);
        for (int i = 0; i < r.length; i++) {
            assertEquals(r[i], res[i]);
        }
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{2, new int[]{2, 3}},
        {10, new int[]{4, 10}},
        {6, new int[] {3, 6}},
        {5, new int[] {3, 6}}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeWhileTest() {
        new Variant11().whileTask(0);
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] arr, int res) {
        assertEquals(new Variant11().arrayTask(arr), res);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{{new int[]{2, 3, 1, 1, 4, 5}, 1},
        {new int[]{4, 10, 2}, 10},
        {new int[]{2, 4}, 4}};
    }

    ///////////////////////////////////////////
    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int[][] input, int[][] output) {
        int[][] r = new Variant11().matrixTask(input);
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                assertEquals(r[i][j], output[i][j]);
            }
        }
    }

    @DataProvider
    public Object[][] matrixProvider() {
        return new Object[][]{{new int[][]{{1, 1, 2, 2}, {3, 3, 4, 4}, {5, 5, 6, 6}, {7, 7, 8, 8}},
        new int[][]{{6, 6, 2, 2}, {8, 8, 4, 4}, {5, 5, 1, 1}, {7, 7, 3, 3}}}};
    }

    ///////////////////////////////////////////
}
