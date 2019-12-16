package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    static final private int CHOOSE=0;
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
                Intent intent=new Intent(this,Learning.class);
                startActivityForResult(intent,CHOOSE);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE) {
            if (resultCode == RESULT_OK) {
                String result=data.getStringExtra(Learning.ANSW);
                Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
                toast.show();
            }
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
        String[] str=readFile();
        Analis analis=new Analis();
        String a=analis.Analisis(str,find);
        LineRaspr lineRaspr=new LineRaspr();
        String b=lineRaspr.Raspr(str,find);
        Regression regress=new Regression();
        String c=regress.regre(str,find);
        if(Integer.getInteger(a)==Integer.getInteger(b)&&Integer.getInteger(a)==Integer.getInteger(c))
            result.setText(a);
    }
}