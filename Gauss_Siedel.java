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
public class Gauss_Siedel {

    
    
    
    public static void main(String[] args) {
        int n = 4;
        int m = 4;

        // Sistemdeki katsayıları ve sağ tarafı ayarlayın.
        double[][] A = new double[][]{
            {3, 2, 1, 0},
            {1, 4, 0, 3},
            {1, 0, 2, 1},
            {1, 1, 1, 5}
        };
        double[] b = new double[]{6, 8, 4, 8};

        // Gauss-Seidel yöntemini uygulayın.
        double[] x = gaussSeidel(A, b, n, m);

        // Çözümü yazdırın.
        for (double xi : x) {
            System.out.println(xi);
        }
    }
    
        private static double[] gaussSeidel(double[][] A, double[] b, int n, int m) {
        // Çözümü başlatın.
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }

        // İterasyonları başlatın.
        for (int i = 0; i < m; i++) {
            // Her bir değişkeni sırayla çözün.
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += A[j][k] * x[k];
                }
                x[j] = (b[j] - sum) / A[j][j];
            }
        }

        return x;
    }
    
}
