package com.example.coursework;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

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
    public String Raspr(double[][] mtx1,double[][] mtxtest,double[] find){
        String result="";
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
        double res1,res2,res3,exp1,exp2,exp3,r1,r2,r3;
        res1=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[0][1]).setScale(2, RoundingMode.UP).doubleValue();
        res2=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[1][1]).setScale(2, RoundingMode.UP).doubleValue();
        res3=new BigDecimal(1/((2*Math.PI)*(2*Math.PI))*sq[2][1]).setScale(2, RoundingMode.UP).doubleValue();
        exp1=new BigDecimal(Math.pow(Math.E,stp1)).setScale(2, RoundingMode.UP).doubleValue();
        exp2=new BigDecimal(Math.pow(Math.E,stp2)).setScale(2, RoundingMode.UP).doubleValue();
        exp3=new BigDecimal(Math.pow(Math.E,stp3)).setScale(2, RoundingMode.UP).doubleValue();
        //-----------------Расчет плотности------------------------------------
        r1=res1*exp1;
        r2=res2*exp2;
        r3=res3*exp3;
        if(r1>r2&&r1>r3)
            result="1";
        if(r2>r1&&r2>r3)
            result="2";
        if(r3>r1&&r3>r2)
            result="3";
        return result;
    }
    //----------------------Расчет степени------------------------------------
    public double step(double[][] inc1, double[][] reversFind, double[][] reversSr,int k){
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
    public double[][] MultiplyMatrix(double[][] a,double[][] b){
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
    public double[][] MatrixTranspose(double[][] a){
        double[][] transpose=new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }
}
