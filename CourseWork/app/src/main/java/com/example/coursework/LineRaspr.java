package com.example.coursework;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class LineRaspr {
    /**
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - ковариационная матрица С1
     */
    public static double[][] MatrixC1(double[][] mtx1,double[][] mtxtest){
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
    public static double[][] MatrixC2(double[][] mtx1,double[][] mtxtest){
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
    public static double[][] MatrixC3(double[][] mtx1,double[][] mtxtest){
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
     * @param mtx1 - матрица средних значений классов
     * @param mtxtest - матрица из массива строк для выполнения операций
     * @return - матрица с детерминантами и их квадратным корнем
     */
    public static double[][]SquereDet(double[][] mtx1,double[][] mtxtest){
        double[][] c1=MatrixC1(mtx1,mtxtest);
        double[][] c2=MatrixC2(mtx1,mtxtest);
        double[][] c3=MatrixC3(mtx1,mtxtest);
        double[][] sq={{0,0},{0,0},{0,0}};
        sq[0][0]=MatrixActions.Determine(c1);
        sq[1][0]=MatrixActions.Determine(c2);
        sq[2][0]=MatrixActions.Determine(c3);
        sq[0][1]=Math.sqrt(sq[0][0]);
        sq[1][1]=Math.sqrt(sq[1][0]);
        sq[2][1]=Math.sqrt(sq[2][0]);
        return sq;
    }

    /**
     * @param str - массив строк с файла
     * @param find - матрица вводимых параметров
     * @return - матрица результатов плотности нормального распределения
     */
    public static double[][] Raspr(String[] str,double[] find){
        double[][] result=new double[3][2];
        //Матрица средних значений классов
        double[][] mtx1=MatrixActions.MatrixClassDis(str);//размерность 3*4
        //Нахождение матрицы с обучением
        double[][] mtxtest=MatrixActions.TestMatrix(str);//размерность 15*4
        double[][] sq=SquereDet(mtx1,mtxtest);
        double[][] inc1=MatrixActions.inversion(MatrixC1(mtx1,mtxtest),4);
        double[][] inc2=MatrixActions.inversion(MatrixC2(mtx1,mtxtest),4);
        double[][] inc3=MatrixActions.inversion(MatrixC3(mtx1,mtxtest),4);
        //----------------------Преобразование матриц------------------------------
        double[][] reversSr=MatrixActions.MatrixTranspose(mtx1);
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
    public static double step(double[][] inc1, double[][] reversFind, double[][] reversSr,int k){
        MatrixActions mtxact=new MatrixActions();
        double result=0;
        double[][] proper=new double[4][1];
        for(int i=0;i<4;i++){
            proper[i][0]=reversFind[i][0]-reversSr[i][k];
        }
        double[][] transportProper=mtxact.MatrixTranspose(proper);
        double[][] res1=mtxact.MultiplyMatrix(transportProper,inc1);
        for(int i=0;i<4;i++)
        {
            result+=proper[i][0]*res1[0][i];
        }
        result=-(result/2);
        return result;
    }

}