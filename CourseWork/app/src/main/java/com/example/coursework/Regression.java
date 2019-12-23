package com.example.coursework;

public class Regression {
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
        double[][] a=MatrixActions.TestMatrix(str);
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
        double[][] a=MatrixActions.TestMatrix(str);
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
        double[][] inO=MatrixActions.inversion(o,4);
        x=MatrixActions.MultiplyMatrix(inO,u);
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
}