package com.example.coursework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixActionsTest {
    String[] str=new String[15];
    double[][] mtxtest=new double[15][4];
    double[][] mtxtestdiv=new double[3][4];
    double[][] mtxtestW=new double[4][4];
    double[][] mtxtestInv=new double[4][4];
    double[][] mtxtestMul1=new double[2][2];
    double[][] mtxtestMul2=new double[2][2];
    double[][] mtxtestMulRes=new double[2][2];
    double[]mtxtestH=new double[3];
    double[] testFind=new double[4];
    double det;
    double[][] mtxtestC1inv=new double[4][4];
    double[][] mtxtestC1=new double[4][4];
    int n=4;
    double[][] reverstest=new double[2][2];
    @Before
    public void init() {
        str[0]="740 570 15 919 1";
        str[1]="740 570 16 907 1";
        str[2]="740 580 15 920 1";
        str[3]="720 570 17 914 1";
        str[4]="720 570 15 918 1";
        str[5]="600 600 15 597 2";
        str[6]="600 650 25 812 2";
        str[7]="700 650 23 821 2";
        str[8]="590 650 25 827 2";
        str[9]="590 650 25 798 2";
        str[10]="790 530 15 686 3";
        str[11]="800 610 18 698 3";
        str[12]="830 610 18 701 3";
        str[13]="830 350 15 886 3";
        str[14]="780 350 15 886 3";

        mtxtest=MatrixActions.TestMatrix(str);

        mtxtestC1[0][0]=120.0;
        mtxtestC1[0][1]=20.0;
        mtxtestC1[0][2]=-4.0;
        mtxtestC1[0][3]=-4.0;
        mtxtestC1[1][0]=20.0;
        mtxtestC1[1][1]=20.0;
        mtxtestC1[1][2]=-1.5;
        mtxtestC1[1][3]=11.0;
        mtxtestC1[2][0]=-4.0;
        mtxtestC1[2][1]=-1.5;
        mtxtestC1[2][2]=0.8;
        mtxtestC1[2][3]=-2.9499999999999997;
        mtxtestC1[3][0]=-4.0;
        mtxtestC1[3][1]=11.0;
        mtxtestC1[3][2]=-2.9499999999999997;
        mtxtestC1[3][3]=28.3;

        mtxtestdiv[0][0]=732;
        mtxtestdiv[0][1]=572;
        mtxtestdiv[0][2]=15.6;
        mtxtestdiv[0][3]=915.6;
        mtxtestdiv[1][0]=616;
        mtxtestdiv[1][1]=640;
        mtxtestdiv[1][2]=22.6;
        mtxtestdiv[1][3]=771;
        mtxtestdiv[2][0]=806;
        mtxtestdiv[2][1]=490;
        mtxtestdiv[2][2]=16.2;
        mtxtestdiv[2][3]=771.4;

        mtxtestW[0][0]=11520;
        mtxtestW[0][1]=2680;
        mtxtestW[0][2]=30;
        mtxtestW[0][3]=4042;
        mtxtestW[1][0]=2680;
        mtxtestW[1][1]=71680;
        mtxtestW[1][2]=1094;
        mtxtestW[1][3]=-44016;
        mtxtestW[2][0]=30;
        mtxtestW[2][1]=1094;
        mtxtestW[2][2]=89.2;
        mtxtestW[2][3]=1196.8;
        mtxtestW[3][0]=4042;
        mtxtestW[3][1]=-44016;
        mtxtestW[3][2]=1196.8;
        mtxtestW[3][3]=82338.4;

        mtxtestInv[0][0]=1.5535563520082402E-4;
        mtxtestInv[0][1]=-1.3678171096706792E-4;
        mtxtestInv[0][2]=0.0033649194229905368;
        mtxtestInv[0][3]=-1.2965599079947226E-4;
        mtxtestInv[1][0]=-1.367817109670679E-4;
        mtxtestInv[1][1]=2.7949755833086117E-4;
        mtxtestInv[1][2]=-0.006803480979927515;
        mtxtestInv[1][3]=2.5501639866693215E-4;
        mtxtestInv[2][0]=0.003364919422990537;
        mtxtestInv[2][1]=-0.006803480979927516;
        mtxtestInv[2][2]=0.17955006036871865;
        mtxtestInv[2][3]=-0.006411935808438102;
        mtxtestInv[3][0]=-1.2965599079947226E-4;
        mtxtestInv[3][1]=2.5501639866693215E-4;
        mtxtestInv[3][2]=-0.006411935808438102;
        mtxtestInv[3][3]=2.480334339029405E-4;

        testFind[0]=720.0;
        testFind[1]=660.0;
        testFind[2]=18.0;
        testFind[3]=922.0;

        mtxtestMul1[0][0]=1;
        mtxtestMul1[0][1]=2;
        mtxtestMul1[1][0]=3;
        mtxtestMul1[1][1]=4;

        mtxtestMul2[0][0]=1;
        mtxtestMul2[0][1]=2;
        mtxtestMul2[1][0]=3;
        mtxtestMul2[1][1]=4;

        mtxtestMulRes[0][0]=7;
        mtxtestMulRes[0][1]=10;
        mtxtestMulRes[1][0]=15;
        mtxtestMulRes[1][1]=22;

        reverstest[0][0]=1;
        reverstest[0][1]=3;
        reverstest[1][0]=2;
        reverstest[1][1]=4;

        mtxtestC1inv[0][0]=0.017249999999999995;
        mtxtestC1inv[0][1]=-0.02049999999999999;
        mtxtestC1inv[0][2]=0.13999999999999993;
        mtxtestC1inv[0][3]=0.024999999999999984;
        mtxtestC1inv[1][0]=-0.02049999999999999;
        mtxtestC1inv[1][1]=0.08899999999999998;
        mtxtestC1inv[1][2]=-0.11999999999999988;
        mtxtestC1inv[1][3]=-0.049999999999999975;
        mtxtestC1inv[2][0]=0.1399999999999999;
        mtxtestC1inv[2][1]=-0.11999999999999988;
        mtxtestC1inv[2][2]=3.1999999999999984;
        mtxtestC1inv[2][3]=0.39999999999999974;
        mtxtestC1inv[3][0]=0.024999999999999984;
        mtxtestC1inv[3][1]=-0.04999999999999998;
        mtxtestC1inv[3][2]=0.39999999999999974;
        mtxtestC1inv[3][3]=0.09999999999999996;

        det=12500.00000000001;
    }
    @Test
    public void testMatrix() {
    }

    @Test
    public void matrixClassDis() {
        assertArrayEquals(mtxtestdiv,MatrixActions.MatrixClassDis(str));
    }

    @Test
    public void inversion() {
        assertArrayEquals(mtxtestInv,MatrixActions.inversion(mtxtestW,n));
    }

    @Test
    public void multiplyMatrix() {
        assertArrayEquals(mtxtestMulRes,MatrixActions.MultiplyMatrix(mtxtestMul1,mtxtestMul2));
    }

    @Test
    public void matrixTranspose() {
        assertArrayEquals(reverstest,MatrixActions.MatrixTranspose(mtxtestMul1));
    }

    @Test
    public void determine() {
        assertEquals(det,MatrixActions.Determine(mtxtestC1),0);
    }
}