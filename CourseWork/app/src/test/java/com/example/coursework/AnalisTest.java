package com.example.coursework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnalisTest {
String[] str=new String[15];
double[][] mtxtest=new double[15][4];
double[][] mtxtestdiv=new double[3][4];
double[][] mtxtestB=new double[3][5];
double[][] mtxtestW=new double[4][4];
double[][] mtxtestInv=new double[4][4];
double[]mtxtestH=new double[3];
double[] testFind=new double[4];
int n=4;
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

        mtxtest=Analis.TestMatrix(str);
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

        mtxtestB[0][0]=-1064.1583808139007;
        mtxtestB[0][1]=-0.36886915060204917;
        mtxtestB[0][2]=2.2452852272391928;
        mtxtestB[0][3]=-53.979091048120566;
        mtxtestB[0][4]=2.136412898906033;
        mtxtestB[1][0]=-640.0415831735222;
        mtxtestB[1][1]=-0.18910576418427405;
        mtxtestB[1][2]=1.649758519222562;
        mtxtestB[1][3]=-38.00650327877008;
        mtxtestB[1][4]=1.555997196993932;
        mtxtestB[2][0]=-635.21784850461;
        mtxtestB[2][1]=0.1522640033728162;
        mtxtestB[2][2]=1.3585320311941316;
        mtxtestB[2][3]=-31.908443158680225;
        mtxtestB[2][4]=1.294979250941438;

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

        mtxtestH[0]=1150.2931346556834;
        mtxtestH[1]=1063.155245911235;
        mtxtestH[2]=990.6622670237064;

        testFind[0]=720.0;
        testFind[1]=660.0;
        testFind[2]=18.0;
        testFind[3]=922.0;
    }
    @Test
    public void matrixClassDis() {
        assertArrayEquals(mtxtestdiv,Analis.MatrixClassDis(str));
    }

    @Test
    public void matrixB() {
        assertArrayEquals(mtxtestB,Analis.MatrixB(mtxtestInv,mtxtestdiv));
    }

    @Test
    public void matrixW() {
        assertArrayEquals(mtxtestW,Analis.MatrixW(mtxtestdiv,mtxtest));
    }

    @Test
    public void inversion() {
        assertArrayEquals(mtxtestInv,Analis.inversion(mtxtestW,n));
    }

    @Test
    public void matrixH() {
        double[] h=Analis.MatrixH(mtxtestB,testFind);
        assertEquals(h[0],mtxtestH[0],0);
        assertEquals(h[1],mtxtestH[1],0);
        assertEquals(h[2],mtxtestH[2],0);
    }
}