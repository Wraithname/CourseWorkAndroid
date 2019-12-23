package com.example.coursework;

public class MatrixActions {
    /**
     * Счетчики для расчета средних значений по классам
     */
    static int count1=0,count2=0,count3=0;

    /**
     * @param str - массив строк с файла
     * @return - матрица из массива строк для выполнения операций
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
     * @param str - массив строк из файла
     * @return - массив средних значений для каждого класса
     */
    public static double[][] MatrixClassDis(String[] str){
        double[][] mtx1={
                {0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        String[] line;
        for(int j=0;j<str.length;j++) {
            line = str[j].split(" ");
            if (Integer.parseInt(line[4]) == 1) {
                mtx1[0][0] += Integer.parseInt(line[0]);
                mtx1[0][1] += Integer.parseInt(line[1]);
                mtx1[0][2] += Integer.parseInt(line[2]);
                mtx1[0][3] += Integer.parseInt(line[3]);
                count1++;
            }
            if (Integer.parseInt(line[4]) == 2) {
                mtx1[1][0] += Integer.parseInt(line[0]);
                mtx1[1][1] += Integer.parseInt(line[1]);
                mtx1[1][2] += Integer.parseInt(line[2]);
                mtx1[1][3] += Integer.parseInt(line[3]);
                count2++;
            }
            if (Integer.parseInt(line[4]) == 3) {
                mtx1[2][0] += Integer.parseInt(line[0]);
                mtx1[2][1] += Integer.parseInt(line[1]);
                mtx1[2][2] += Integer.parseInt(line[2]);
                mtx1[2][3] += Integer.parseInt(line[3]);
                count3++;
            }
        }
        mtx1[0][0] = mtx1[0][0]/count1;
        mtx1[0][1] = mtx1[0][1]/count1;
        mtx1[0][2] = mtx1[0][2]/count1;
        mtx1[0][3] = mtx1[0][3]/count1;
        mtx1[1][0] = mtx1[1][0]/count2;
        mtx1[1][1] = mtx1[1][1]/count2;
        mtx1[1][2] = mtx1[1][2]/count2;
        mtx1[1][3] = mtx1[1][3]/count2;
        mtx1[2][0] = mtx1[2][0]/count3;
        mtx1[2][1] = mtx1[2][1]/count3;
        mtx1[2][2] = mtx1[2][2]/count3;
        mtx1[2][3] = mtx1[2][3]/count3;

        return mtx1;
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
    /**
     * @param a - матрица для транспонирования
     * @return - транспонированная матрица
     */
    public static double[][] MatrixTranspose(double[][] a){
        double[][] transpose=new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }
    /**
     * @param C - матрица для расчета определителя
     * @return - детерминант матрицы
     */
    public static double Determine(double[][]C)
    {
        double[][]Covar=C;
        double EPS=1E-9;
        double det=1;
        double[][] b = new double[1][];
        for (int i=0; i<4; ++i)
        {
            //присваиваем k номер строки
            int k = i;
            //идем по строке от i+1 до конца
            for (int j=i+1; j<4; ++j)
                //проверяем
                if (Math.abs(Covar[j] [i]) > Math.abs(Covar[k][i]))
                    //если равенство выполняется то k присваиваем j
                    k = j;
            //если равенство выполняется то определитель приравниваем 0 и выходим из программы
            if (Math.abs(Covar[k] [i]) < EPS)
            {
                det = 0;
                break;
            }
            //меняем местами a[i] и a[k]
            b[0] = Covar[i];
            Covar[i] = Covar[k];
            Covar[k] = b[0];
            //если i не равно k
            if (i != k)
                //то меняем знак определителя
                det = -det;
            //умножаем det на элемент a[i][i]
            det *= Covar[i][i];
            //идем по строке от i+1 до конца
            for (int j=i+1; j<4; ++j)
                //каждый элемент делим на a[i][i]
                Covar[i][j] /= Covar[i][i];
            //идем по столбцам
            for (int j=0; j<4; ++j)
                //проверяем
                if ((j != i)&&(Math.abs(Covar[j][i]) > EPS))
                    //если да, то идем по k от i+1
                    for (k = i+1; k < 4; ++k)
                        Covar[j][k] -= Covar[i][k] * Covar[j][i];
        }
        return det;
    }
}
