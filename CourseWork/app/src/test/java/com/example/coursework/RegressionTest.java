package com.example.coursework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegressionTest {
    String[] str=new String[15];
    double[][] mtxtestO=new double[4][4];
    double[][] mtxtestU=new double[4][1];
    double[][] mtxtestX=new double[4][1];
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

        mtxtestO[0][0]=7836100.0;
        mtxtestO[0][1]=6042100.0;
        mtxtestO[0][2]=192020.0;
        mtxtestO[0][3]=8838560.0;
        mtxtestO[1][0]=6042100.0;
        mtxtestO[1][1]=4956100.0;
        mtxtestO[1][2]=157720.0;
        mtxtestO[1][3]=6931730.0;
        mtxtestO[2][0]=192020.0;
        mtxtestO[2][1]=157720.0;
        mtxtestO[2][2]=5172.0;
        mtxtestO[2][3]=222220.0;
        mtxtestO[3][0]=8838560.0;
        mtxtestO[3][1]=6931730.0;
        mtxtestO[3][2]=222220.0;
        mtxtestO[3][3]=1.022145E7;

        mtxtestU[0][0]=21910.0;
        mtxtestU[1][0]=16610.0;
        mtxtestU[2][0]=547.0;
        mtxtestU[3][0]=23859.0;

        mtxtestX[0][0]=0.008012137704866529;
        mtxtestX[1][0]=-0.005070068324573467;
        mtxtestX[2][0]=0.19062891096949852;
        mtxtestX[3][0]=-0.005300028050900019;
    }

    @Test
    public void matrixO() {
        assertArrayEquals(mtxtestO,Regression.MatrixO(str));
    }

    @Test
    public void matrixU() {
        assertArrayEquals(mtxtestU,Regression.MatrixU(str));
    }

    @Test
    public void matrixX() {
        assertArrayEquals(mtxtestX,Regression.MatrixX(str));
    }
}