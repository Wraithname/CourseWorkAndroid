package com.example.coursework;

public class Regression {
    /**
     * @param str - массив строк с файла
     * @return- матрица из массива строк для выполнения операций
     */
    public static double[][] TestMatrix(String[] str){
        String[] line;
        double[][] mtxtest=new double[15][4];
        for (int i = 0; i < 15; i++) {
            line = str[i].split(" ");
            if (Integer.parseInt(line[4]) == 1) {
                mtxtest[i][0] = Integer.parseInt(line[0]);
                mtxtest[i][1] = Integer.parseInt(line[1]);
                mtxtest[i][2] = Integer.parseInt(line[2]);
                mtxtest[i][3] = Integer.parseInt(line[3]);
            }
            if (Integer.parseInt(line[4]) == 2) {
                mtxtest[i][0] = Integer.parseInt(line[0]);
                mtxtest[i][1] = Integer.parseInt(line[1]);
                mtxtest[i][2] = Integer.parseInt(line[2]);
                mtxtest[i][3] = Integer.parseInt(line[3]);
            }
            if (Integer.parseInt(line[4]) == 3) {
                mtxtest[i][0] = Integer.parseInt(line[0]);
                mtxtest[i][1] = Integer.parseInt(line[1]);
                mtxtest[i][2] = Integer.parseInt(line[2]);
                mtxtest[i][3] = Integer.parseInt(line[3]);
            }
        }
        return mtxtest;
    }

    /**
     * @param str - массив строк с файла
     * @return - матрица B
     */
    public static double[][] MatrixB(String[] str){
        String[] line;
        double[][] mtxtest=new double[15][1];
        for (int i = 0; i < 15; i++) {
            line = str[i].split(" ");
            if (Integer.parseInt(line[4]) == 1) {
                mtxtest[i][0] = Integer.parseInt(line[4]);
            }
            if (Integer.parseInt(line[4]) == 2) {
                mtxtest[i][0] = Integer.parseInt(line[4]);
            }
            if (Integer.parseInt(line[4]) == 3) {
                mtxtest[i][0] = Integer.parseInt(line[4]);
            }
        }
        return mtxtest;
    }

    /**
     * @param str - массив строк с файла
     * @return - матрица О
     */
    public static double[][] MatrixO(String[] str){
        double[][] o=new double[4][4];
        double[][] a=TestMatrix(str);
        int tmp=0;
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                for(int i=0;i<15;i++){
                  tmp+=a[i][j]*a[i][k];
                }
                o[j][k]=tmp;
                tmp=0;
            }
        }
        return o;
    }

    /**
     * @param str - массив строк с файла
     * @return - матрица U
     */
    public static double[][] MatrixU(String[] str){
        double[][] u=new double[4][1];
        double[][] a=TestMatrix(str);
        double[][] b=MatrixB(str);
        int tmp=0;
        for(int k=0;k<4;k++){
            for(int i=0;i<15;i++){
                tmp+=b[i][0]*a[i][k];
            }
            u[k][0]=tmp;
            tmp=0;
        }
        return u;
    }

    /**
     * @param str - массив строк с файла
     * @return - матрица X
     */
    public static double[][] MatrixX(String[] str){
        double[][] x;
        double[][] o=MatrixO(str);
        double[][]u =MatrixU(str);
        double[][] inO=inversion(o,4);
        x=MultiplyMatrix(inO,u);
        return x;
    }

    /**
     * @param str - массив строк с файла
     * @param find - матрица вводимых параметров
     * @return - результат линейной регрессии
     */
    public static double Regre(String[] str,double[] find){
        double[][]x=MatrixX(str);
        double b=x[0][0]*find[0]+x[1][0]*find[1]+x[2][0]*find[2]+x[3][0]*find[3];
        return b;
    }

    /**
     * @param A - матрица для инверсирования
     * @param N - размерность матрицы
     * @return - инверсированная матрица
     */
    public static double[][] inversion(double [][]A, int N)
    {
        double temp;
        double [][] E = new double [N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                E[i][j] = 0f;

                if (i == j)
                    E[i][j] = 1f;
            }
        for (int k = 0; k < N; k++)
        {
            temp = A[k][k];
            for (int j = 0; j < N; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }
            for (int i = k + 1; i < N; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int k = N - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = E[i][j];
        return E;
    }

    /**
     * @param a - матрица 1 множитель
     * @param b - матрица 2 множитель
     * @return - матрица произведения a на b
     */
    public static double[][] MultiplyMatrix(double[][] a,double[][] b){
        int m = a.length;
        int n = a[0].length;
        int k = b.length;
        int l = b[0].length;
        if (n != k){
            return null;
        }
        double[][] result=new double[m][l];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<l; j++)
            {
                result[i][j] = 0;
                for (int s=0; s<n; s++)
                {
                    result[i][j] += a[i][s] * b[s][j];
                }
            }
        }
        return  result;
    }
}