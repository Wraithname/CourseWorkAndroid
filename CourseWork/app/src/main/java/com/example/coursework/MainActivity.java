package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "CourseLog";
    final String FILENAME = "file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuactivity, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void writeFile(String[] testnumbers) {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
            // пишем данные
            for(int i=0;i<testnumbers.length;i++)
            bw.write(testnumbers[i]);
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] readFile(){
        String[] str=new String[15];
        try {
            // открываем поток для чтения
            Scanner in = new Scanner(new InputStreamReader(
                    openFileInput(FILENAME)));
            int i=0;
            // читаем содержимое
            while (in.hasNextLine()) {
                str[i]=in.nextLine();
                Log.d(LOG_TAG, str[i]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d(LOG_TAG,"Файл прочитан");
        return str;
    }

    public void startCalculation(View view) {
        TextView first_column= (TextView)findViewById(R.id.textView12);
        TextView second_column= (TextView)findViewById(R.id.textView9);
        TextView third_column= (TextView)findViewById(R.id.textView10);
        TextView forth_column= (TextView)findViewById(R.id.textView8);
        TextView fives_column= (TextView)findViewById(R.id.textView11);
        TextView result=(TextView)findViewById(R.id.textView7);
        double[] find=new double[4];
        find[0]=Double.parseDouble(second_column.getText().toString());
        find[1]=Double.parseDouble(third_column.getText().toString());
        find[2]=Double.parseDouble(forth_column.getText().toString());
        find[3]=Double.parseDouble(fives_column.getText().toString());
        //Запись начальных данных в файл
        String[] str=new String[15];
        str[0]="об1 740 570 15 919 1";
        str[1]="об2 740 570 16 907 1";
        str[2]="об3 740 580 15 920 1";
        str[3]="об4 720 570 17 914 1";
        str[4]="об5 720 570 15 918 1";
        str[5]="об6 600 600 15 597 2";
        str[6]="об7 600 650 25 812 2";
        str[7]="об8 700 650 23 821 2";
        str[8]="об9 590 650 25 827 2";
        str[9]="об10 590 650 25 798 2";
        str[10]="об11 790 530 15 686 3";
        str[11]="об12 800 610 18 698 3";
        str[12]="об13 830 610 18 701 3";
        str[13]="об14 830 350 15 886 3";
        str[14]="об15 780 350 15 886 3";
        Analis analis=new Analis();
        //---------------------Расчет начальных данных-------------------------------
        //Матрица средних значений классов
        double[][] mtx1=analis.MatrixClassDis(str);//размерность 3*4
        //Нахождение матрицы с обучением
        double[][] mtxtest=analis.TestMatrix(str);//размерность 15*4
        String a=analis.Analisis(str,find);
        //---------------------------------------------------------------------------
        LineRaspr lineRaspr=new LineRaspr();
        String b=lineRaspr.Raspr(mtx1,mtxtest,find);
        if(a==b)
            result.setText(a);
    }
}
