package com.example.coursework;

public class Analis {
    /**
     * Счетчики для расчета средних значений по классам
     */
    int count1=0,count2=0,count3=0;

    /**
     * @param str - массив строк с файла
     * @return - матрица из массива строк для выполнения операций
     */
    private double[][] TestMatrix(String[] str){
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
    private double[][] MatrixClassDis(String[] str){
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
     * @param a - инверсированная матрица W
     * @param mtx1 - матрица средних значений классов
     * @return - матрица B
     */
    private double[][] MatrixB(double[][]a,double[][] mtx1){
        double[][]b={
                {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}
        };
        double temp=0;
        for(int k=0;k<3;k++) {
            for (int i = 1; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    temp += a[i-1][j] * mtx1[k][j];
                }
                b[k][i] = 12 * temp;
                temp = 0;
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int j = 1; j < 5; j++) {
                temp += b[k][j] * mtx1[k][j-1];
            }
            b[k][0] += -(temp/2);
            temp = 0;
        }
        return b;
    }

    /**
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - матрица W
     */
    private double[][] MatrixW(double[][] mtx1,double[][] mtxtest){
        double[][]w={
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        double temp=0;
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {

                for (int k = 0; k < 3; k++) {
                    if (k == 0) {
                        for (int m = 0; m < 5; m++) {
                            temp += (mtxtest[m][i] - mtx1[k][i]) * (mtxtest[m][j] - mtx1[k][j]);
                        }
                    }
                    if (k == 1) {
                        for (int m = 5; m < 10; m++) {
                            temp += (mtxtest[m][i] - mtx1[k][i]) * (mtxtest[m][j] - mtx1[k][j]);
                        }
                    }
                    if (k == 2) {
                        for (int m = 10; m < 15; m++) {

                            temp += (mtxtest[m][i] - mtx1[k][i]) * (mtxtest[m][j] - mtx1[k][j]);
                        }
                    }
                }
                w[i][j]=temp;
                temp=0;
            }
        }
        return w;
    }

    /**
     * @param A - матрица для инверсирования
     * @param N - размерность матрицы
     * @return - инверсированная матрица
     */
    private double[][] inversion(double [][]A, int N)
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
     * @param b - матрица B
     * @param find - матрица вводимых параметров
     * @return - матрица H
     */
    private double[] MatrixH(double[][]b,double[] find){
        double[]h={0,0,0};
        double temp=0;
        for (int k = 0; k < 3; k++) {
            for (int j = 1; j < 5; j++) {
                temp+=b[k][j]*find[j-1];
            }
            h[k]+=b[k][0]+temp;
            temp=0;
        }
        return h;
    }

    /**
     * @param str - массив строк с файла
     * @param find - матрица вводимых параметров
     * @return - результат анализа Фишера
     */
    public double[] Analisis(String[] str,double[] find)
    {
        double[][] mtx1=MatrixClassDis(str);//размерность 3*4
        //Нахождение матрицы с обучением
        double[][] mtxtest=TestMatrix(str);//размерность 15*4
        //Расчет матрицы W
        double[][]w=MatrixW(mtx1,mtxtest);
        //Расчет обратной матрицы А
        double[][]a=inversion(w,4);
        //Расчет обратной матрицы B
        double[][]b=MatrixB(a,mtx1);
        //---------------------------------------------------------------------------
        double[]h=MatrixH(b,find);
        //--------------------------------------------------------------------------
        return h;
    }
}