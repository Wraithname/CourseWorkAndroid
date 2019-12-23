package com.example.coursework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineRasprTest {
    String[] str=new String[15];
    double[][] mtxtest=new double[15][4];
    double[][] mtxtestdiv=new double[3][4];
    double[] testFind=new double[4];
    double[][] mtxtestC1=new double[4][4];
    double[][] mtxtestC2=new double[4][4];
    double[][] mtxtestC3=new double[4][4];
    double[][] mtxtestDet=new double[3][2];
    double det,stp;
    double[][] mtxtestC1inv=new double[4][4];
    double[][] mtxtestC2inv=new double[4][4];
    double[][] mtxtestC3inv=new double[4][4];
    int n=4;
    double[][] mtxtestMul1=new double[2][2];
    double[][] mtxtestMul2=new double[2][2];
    double[][] mtxtestMulRes=new double[2][2];
    double[][] reverstest=new double[2][2];
    double[][] reversFind=new double[4][1];
    double[][] reversSrtest=new double[4][3];
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

        reversSrtest=LineRaspr.MatrixTranspose(mtxtestdiv);

        testFind[0]=720.0;
        testFind[1]=660.0;
        testFind[2]=18.0;
        testFind[3]=922.0;

        for(int i=0;i<4;i++) {
            reversFind[i][0] = testFind[i];
        }
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

        mtxtestC2[0][0]=2230.0;
        mtxtestC2[0][1]=200.0;
        mtxtestC2[0][2]=-2.0;
        mtxtestC2[0][3]=1042.5;
        mtxtestC2[1][0]=200.0;
        mtxtestC2[1][1]=500.0;
        mtxtestC2[1][2]=95.00000000000001;
        mtxtestC2[1][3]=2175.0;
        mtxtestC2[2][0]=-2.0;
        mtxtestC2[2][1]=95.00000000000001;
        mtxtestC2[2][2]=18.799999999999997;
        mtxtestC2[2][3]=410.0;
        mtxtestC2[3][0]=1042.5;
        mtxtestC2[3][1]=2175.0;
        mtxtestC2[3][2]=410.0;
        mtxtestC2[3][3]=9580.5;

        mtxtestC3[0][0]=530.0;
        mtxtestC3[0][1]=450.0;
        mtxtestC3[0][2]=13.5;
        mtxtestC3[0][3]=-28.0;
        mtxtestC3[1][0]=450.0;
        mtxtestC3[1][1]=17400.0;
        mtxtestC3[1][2]=180.0;
        mtxtestC3[1][3]=-13190.0;
        mtxtestC3[2][0]=13.5;
        mtxtestC3[2][1]=180.0;
        mtxtestC3[2][2]=2.6999999999999997;
        mtxtestC3[2][3]=-107.85;
        mtxtestC3[3][0]=-28.0;
        mtxtestC3[3][1]=-13190.0;
        mtxtestC3[3][2]=-107.85;
        mtxtestC3[3][3]=10975.8;

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

        mtxtestC2inv[0][0]=0.0600237812129285;
        mtxtestC2inv[0][1]=-0.6347110582649076;
        mtxtestC2inv[0][2]=3.2033293698025296;
        mtxtestC2inv[0][3]=4.756242568403433E-4;
        mtxtestC2inv[1][0]=-0.6347110582649078;
        mtxtestC2inv[1][1]=7.01626064210286;
        mtxtestC2inv[1][2]=-34.33954815700647;
        mtxtestC2inv[1][3]=-0.054221165279463704;
        mtxtestC2inv[2][0]=3.2033293698025305;
        mtxtestC2inv[2][1]=-34.33954815700647;
        mtxtestC2inv[2][2]=172.46611177195211;
        mtxtestC2inv[2][3]=0.06658739595736823;
        mtxtestC2inv[3][0]=4.756242568403429E-4;
        mtxtestC2inv[3][1]=-0.05422116527946371;
        mtxtestC2inv[3][2]=0.06658739595736823;
        mtxtestC2inv[3][3]=0.009512485136741978;

        mtxtestC3inv[0][0]=0.003200000000003568;
        mtxtestC3inv[0][1]=-0.03528888888903947;
        mtxtestC3inv[0][2]=1.0583703703749734;
        mtxtestC3inv[0][3]=-0.032000000000135476;
        mtxtestC3inv[1][0]=-0.0352888888890395;
        mtxtestC3inv[1][1]=1.4867368998691852;
        mtxtestC3inv[1][2]=-45.39209510764729;
        mtxtestC3inv[1][3]=1.3405432098822772;
        mtxtestC3inv[2][0]=1.058370370374969;
        mtxtestC3inv[2][1]=-45.39209510764731;
        mtxtestC3inv[2][2]=1386.6454991676414;
        mtxtestC3inv[2][3]=-40.921152263549565;
        mtxtestC3inv[3][0]=-0.0320000000001358;
        mtxtestC3inv[3][1]=1.3405432098822772;
        mtxtestC3inv[3][2]=-40.92115226354955;
        mtxtestC3inv[3][3]=1.208888888894059;

        mtxtestDet[0][0]=12500.00000000001;
        mtxtestDet[0][1]=111.80339887498953;
        mtxtestDet[1][0]=657031.249998792;
        mtxtestDet[1][1]=810.5746418429286;
        mtxtestDet[2][0]=5125781.249978636;
        mtxtestDet[2][1]=2264.018827213819;

        det=12500.00000000001;

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

        stp=-325.45000000000005;
    }
    @Test
    public void matrixClassDis() {
        assertArrayEquals(mtxtestdiv,LineRaspr.MatrixClassDis(str));
    }

    @Test
    public void matrixC1() {
        assertArrayEquals(mtxtestC1,LineRaspr.MatrixC1(mtxtestdiv,mtxtest));
    }

    @Test
    public void matrixC2() {
        assertArrayEquals(mtxtestC2,LineRaspr.MatrixC2(mtxtestdiv,mtxtest));
    }

    @Test
    public void matrixC3() {
        assertArrayEquals(mtxtestC3,LineRaspr.MatrixC3(mtxtestdiv,mtxtest));
    }

    @Test
    public void determine() {
        assertEquals(det,LineRaspr.Determine(mtxtestC1),0);
    }

    @Test
    public void squereDet() {
        assertArrayEquals(mtxtestDet,LineRaspr.SquereDet(mtxtestdiv,mtxtest));
    }

    @Test
    public void inversion() {
        assertArrayEquals(mtxtestC1inv,LineRaspr.inversion(mtxtestC1,n));
    }

    @Test
    public void step() {
        assertEquals(stp,LineRaspr.step(mtxtestC1inv,reversFind,reversSrtest,0),0);
    }

    @Test
    public void multiplyMatrix() {
        assertArrayEquals(mtxtestMulRes,LineRaspr.MultiplyMatrix(mtxtestMul1,mtxtestMul2));
    }

    @Test
    public void matrixTranspose() {
        assertArrayEquals(reverstest,LineRaspr.MatrixTranspose(mtxtestMul1));
    }
}