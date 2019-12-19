package com.example.coursework;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class LineRaspr {
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
     * @param str - массив строк с файла
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
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - ковариационная матрица С1
     */
    private double[][] MatrixC1(double[][] mtx1,double[][] mtxtest){
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

    /**
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - ковариационная матрица С2
     */
    private double[][] MatrixC2(double[][] mtx1,double[][] mtxtest){
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

    /**
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - ковариационная матрица С3
     */
    private double[][] MatrixC3(double[][] mtx1,double[][] mtxtest){
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

    /**
     * @param C - матрица для расчета определителя
     * @return - детерминант матрицы
     */
    private double Determine(double[][]C)
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

    /**
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - матрица с детерминантами и их квадратным корнем
     */
    private double[][]SquereDet(double[][] mtx1,double[][] mtxtest){
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
     * @param str - массив строк с файла
     * @param find - матрица вводимых параметров
     * @return - матрица результатов плотности нормального распределения
     */
    public double[][] Raspr(String[] str,double[] find){
        double[][] result=new double[3][2];
        //Матрица средних значений классов
        double[][] mtx1=MatrixClassDis(str);//размерность 3*4
        //Нахождение матрицы с обучением
        double[][] mtxtest=TestMatrix(str);//размерность 15*4
        double[][] sq=SquereDet(mtx1,mtxtest);
        double[][] inc1=inversion(MatrixC1(mtx1,mtxtest),4);
        double[][] inc2=inversion(MatrixC2(mtx1,mtxtest),4);
        double[][] inc3=inversion(MatrixC3(mtx1,mtxtest),4);
        //----------------------Преобразование матриц------------------------------
        double[][] reversSr=MatrixTranspose(mtx1);
        double[][] reversFind=new double[4][1];
        for(int i=0;i<4;i++) {
            reversFind[i][0] = find[i];
        }
        double stp1=step(inc1,reversFind,reversSr,0);
        double stp2=step(inc2,reversFind,reversSr,1);
        double stp3=step(inc3,reversFind,reversSr,2);
        double res1,res2,res3;
        res1=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[0][1]).setScale(2, RoundingMode.UP).doubleValue();
        res2=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[1][1]).setScale(2, RoundingMode.UP).doubleValue();
        res3=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[2][1]).setScale(2, RoundingMode.UP).doubleValue();
        //-----------------Расчет плотности------------------------------------
        result[0][0]=res1;
        result[1][0]=res2;
        result[2][0]=res3;
        result[0][1]=stp1;
        result[1][1]=stp2;
        result[2][1]=stp3;
        return result;
    }

    /**
     * @param inc1 - инверсированная ковариационная матрица
     * @param reversFind - инверсированный массив вводимых параметров
     * @param reversSr - инверсированный массив средних значений классов
     * @param k - номер класса
     * @return - степень экспоненты
     */
    //----------------------Расчет степени------------------------------------
    private double step(double[][] inc1, double[][] reversFind, double[][] reversSr,int k){
        double result=0;
        double[][] proper=new double[4][1];
        for(int i=0;i<4;i++){
            proper[i][0]=reversFind[i][0]-reversSr[i][k];
        }
        double[][] transportProper=MatrixTranspose(proper);
        double[][] res1=MultiplyMatrix(transportProper,inc1);
        for(int i=0;i<4;i++)
        {
            result+=proper[i][0]*res1[0][i];
        }
        result=-(result/2);
        return result;
    }

    /**
     * @param a - матрица 1 множитель
     * @param b - матрица 2 множитель
     * @return - матрица произведения a на b
     */
    private double[][] MultiplyMatrix(double[][] a,double[][] b){
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
    private double[][] MatrixTranspose(double[][] a){
        double[][] transpose=new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }
}