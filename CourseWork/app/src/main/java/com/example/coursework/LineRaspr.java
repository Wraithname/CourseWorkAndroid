package com.example.coursework;

public class LineRaspr {
    public double[][] MatrixC1(double[][] mtx1,double[][] mtxtest){
        double[][]c={
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                        for (int m = 0; m < 5; m++) {
                            c[i][j]+= ((mtxtest[m][i] - mtx1[0][i]) * (mtxtest[m][j] - mtx1[0][j]))/4;
                        }
                }
            }
        return c;
    }
    public double[][] MatrixC2(double[][] mtx1,double[][] mtxtest){
        double[][]c={
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                for (int m = 5; m < 10; m++) {
                    c[i][j]+= ((mtxtest[m][i] - mtx1[1][i]) * (mtxtest[m][j] - mtx1[1][j]))/4;
                }
            }
        }
        return c;
    }
    public double[][] MatrixC3(double[][] mtx1,double[][] mtxtest){
        double[][]c={
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                for (int m = 10; m < 15; m++) {
                    c[i][j]+= ((mtxtest[m][i] - mtx1[2][i]) * (mtxtest[m][j] - mtx1[2][j]))/4;
                }
            }
        }
        return c;
    }
    public double Determine(double[][]C)
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
    public double[][]SquereDet(double[][] mtx1,double[][] mtxtest){
        double[][] c1=MatrixC1(mtx1,mtxtest);
        double[][] c2=MatrixC2(mtx1,mtxtest);
        double[][] c3=MatrixC3(mtx1,mtxtest);
        double[][] sq={{0,0},{0,0},{0,0}};
        sq[0][0]=Determine(c1);
        sq[1][0]=Determine(c2);
        sq[2][0]=Determine(c3);
        sq[0][1]=Math.sqrt(sq[0][0]);
        sq[1][1]=Math.sqrt(sq[1][0]);
        sq[2][1]=Math.sqrt(sq[2][0]);
        return sq;
    }
    public double[][] inversion(double [][]A, int N)
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
}
