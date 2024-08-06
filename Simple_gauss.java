/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_siedel;

/**
 *
 * @author özcan
 */



public class Simple_gauss {

    public static void main(String[] args) {
        // Örnek bir matris ve sabitler
        double[][] matrix = {
            {10, -1, 2, 0},
            {-1, 11, -1, 3},
            {2, -1, 10, -1},
            {0, 3, -1, 8}
        };

        double[] constants = {6, 25, -11, 15};

        double[] result = gaussSeidel(matrix, constants);

        // Sonuçları ekrana yazdırma
        System.out.println("Gauss-Seidel Yöntemi İle Çözüm:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("x" + (i + 1) + " = " + result[i]);
        }
    }

    // Gauss-Seidel yöntemi
    public static double[] gaussSeidel(double[][] matrix, double[] constants) {
        int n = matrix.length;
        double[] solution = new double[n];

        for (int k = 0; k < 25; k++) {
            for (int i = 0; i < n; i++) {
                double sum = constants[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * solution[j];
                    }
                }
                solution[i] = sum / matrix[i][i];
            }
        }

        return solution;
    }
}