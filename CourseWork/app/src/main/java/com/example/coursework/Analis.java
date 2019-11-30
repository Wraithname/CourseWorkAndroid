package com.example.coursework;

public class Analis {
    int count1=0,count2=0,count3=0;
    public double[][] TestMatrix(String[] str){
        String[] line;
        double[][] mtxtest=new double[15][4];
        for (int i = 0; i < 15; i++) {
            line = str[i].split(" ");
            if (Integer.parseInt(line[5]) == 1) {
                mtxtest[i][0] = Integer.parseInt(line[1]);
                mtxtest[i][1] = Integer.parseInt(line[2]);
                mtxtest[i][2] = Integer.parseInt(line[3]);
                mtxtest[i][3] = Integer.parseInt(line[4]);
            }
            if (Integer.parseInt(line[5]) == 2) {
                mtxtest[i][0] = Integer.parseInt(line[1]);
                mtxtest[i][1] = Integer.parseInt(line[2]);
                mtxtest[i][2] = Integer.parseInt(line[3]);
                mtxtest[i][3] = Integer.parseInt(line[4]);
            }
            if (Integer.parseInt(line[5]) == 3) {
                mtxtest[i][0] = Integer.parseInt(line[1]);
                mtxtest[i][1] = Integer.parseInt(line[2]);
                mtxtest[i][2] = Integer.parseInt(line[3]);
                mtxtest[i][3] = Integer.parseInt(line[4]);
            }
        }
        return mtxtest;
    }
    public double[][] MatrixClassDis(String[] str){
        double[][] mtx1={
                {0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        String[] line;
        for(int j=0;j<str.length;j++) {
            line = str[j].split(" ");
            if (Integer.parseInt(line[5]) == 1) {
                mtx1[0][0] += Integer.parseInt(line[1]);
                mtx1[0][1] += Integer.parseInt(line[2]);
                mtx1[0][2] += Integer.parseInt(line[3]);
                mtx1[0][3] += Integer.parseInt(line[4]);
                count1++;
            }
            if (Integer.parseInt(line[5]) == 2) {
                mtx1[1][0] += Integer.parseInt(line[1]);
                mtx1[1][1] += Integer.parseInt(line[2]);
                mtx1[1][2] += Integer.parseInt(line[3]);
                mtx1[1][3] += Integer.parseInt(line[4]);
                count2++;
            }
            if (Integer.parseInt(line[5]) == 3) {
                mtx1[2][0] += Integer.parseInt(line[1]);
                mtx1[2][1] += Integer.parseInt(line[2]);
                mtx1[2][2] += Integer.parseInt(line[3]);
                mtx1[2][3] += Integer.parseInt(line[4]);
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
    public double[][] MatrixB(double[][]a,double[][] mtx1){
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
    public double[][] MatrixW(double[][] mtx1,double[][] mtxtest){
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
    public double[] MatrixH(double[][]b,double[] find){
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
}
