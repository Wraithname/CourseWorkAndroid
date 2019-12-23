package com.example.coursework;

public class Analis {
    /**
     * @param a - инверсированная матрица W
     * @param mtx1 - матрица средних значений классов
     * @return - матрица B
     */
    public static double[][] MatrixB(double[][]a,double[][] mtx1){
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
    public static double[][] MatrixW(double[][] mtx1,double[][] mtxtest){
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
     * @param b - матрица B
     * @param find - матрица вводимых параметров
     * @return - матрица H
     */
    public static double[] MatrixH(double[][]b,double[] find){
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
    public static double[] Analisis(String[] str,double[] find)
    {
        double[][] mtx1=MatrixActions.MatrixClassDis(str);//размерность 3*4
        //Нахождение матрицы с обучением
        double[][] mtxtest=MatrixActions.TestMatrix(str);//размерность 15*4
        //Расчет матрицы W
        double[][]w=MatrixW(mtx1,mtxtest);
        //Расчет обратной матрицы А
        double[][]a=MatrixActions.inversion(w,4);
        //Расчет обратной матрицы B
        double[][]b=MatrixB(a,mtx1);
        //---------------------------------------------------------------------------
        double[]h=MatrixH(b,find);
        //--------------------------------------------------------------------------
        return h;
    }
}