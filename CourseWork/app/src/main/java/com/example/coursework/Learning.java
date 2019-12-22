package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Learning extends AppCompatActivity {
    /**
     * Название файла
     */
    final String FILENAME = "file";
    /**
     * Тэг логов
     */
    final String LOG_TAG = "CourseLog";
    /**
     * Переменная для ответа в другую активность
     */
    public final static String ANSW = "com.example.coursework.ANSW";

    /**
     * @param savedInstanceState - сохраненнные данные для отрисовки
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        setContentView(R.layout.activity_learning);
    }

    /**
     * @param testnumbers - массив строк для записи в файл
     */
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

    /**
     * @param view - интерфейс пользователя
     */
    public void onClick(View view) {
        boolean flag1=true,flag2=true,flag3=true;
        TextView txt1=(TextView)findViewById(R.id.editText11);
        TextView txt2=(TextView)findViewById(R.id.editText12);
        TextView txt3=(TextView)findViewById(R.id.editText13);
        TextView txt4=(TextView)findViewById(R.id.editText14);
        TextView txt5=(TextView)findViewById(R.id.editText7);
        TextView txt6=(TextView)findViewById(R.id.editText8);
        TextView txt7=(TextView)findViewById(R.id.editText9);
        TextView txt8=(TextView)findViewById(R.id.editText10);
        TextView txt9=(TextView)findViewById(R.id.editText15);
        TextView txt10=(TextView)findViewById(R.id.editText16);
        TextView txt11=(TextView)findViewById(R.id.editText17);
        TextView txt12=(TextView)findViewById(R.id.editText18);
        TextView txt13=(TextView)findViewById(R.id.editText19);
        TextView txt14=(TextView)findViewById(R.id.editText20);
        TextView txt15=(TextView)findViewById(R.id.editText21);

        TextView txt16=(TextView)findViewById(R.id.editText22);
        TextView txt17=(TextView)findViewById(R.id.editText23);
        TextView txt18=(TextView)findViewById(R.id.editText24);
        TextView txt19=(TextView)findViewById(R.id.editText25);
        TextView txt20=(TextView)findViewById(R.id.editText26);
        TextView txt21=(TextView)findViewById(R.id.editText111);
        TextView txt22=(TextView)findViewById(R.id.editText112);
        TextView txt23=(TextView)findViewById(R.id.editText113);
        TextView txt24=(TextView)findViewById(R.id.editText114);
        TextView txt25=(TextView)findViewById(R.id.editText117);
        TextView txt26=(TextView)findViewById(R.id.editText118);
        TextView txt27=(TextView)findViewById(R.id.editText119);
        TextView txt28=(TextView)findViewById(R.id.editText110);
        TextView txt29=(TextView)findViewById(R.id.editText115);
        TextView txt30=(TextView)findViewById(R.id.editText116);

        TextView txt31=(TextView)findViewById(R.id.editText127);
        TextView txt32=(TextView)findViewById(R.id.editText128);
        TextView txt33=(TextView)findViewById(R.id.editText129);
        TextView txt34=(TextView)findViewById(R.id.editText120);
        TextView txt35=(TextView)findViewById(R.id.editText121);
        TextView txt36=(TextView)findViewById(R.id.editText122);
        TextView txt37=(TextView)findViewById(R.id.editText123);
        TextView txt38=(TextView)findViewById(R.id.editText124);
        TextView txt39=(TextView)findViewById(R.id.editText125);
        TextView txt40=(TextView)findViewById(R.id.editText126);
        TextView txt41=(TextView)findViewById(R.id.editText211);
        TextView txt42=(TextView)findViewById(R.id.editText212);
        TextView txt43=(TextView)findViewById(R.id.editText213);
        TextView txt44=(TextView)findViewById(R.id.editText214);
        TextView txt45=(TextView)findViewById(R.id.editText227);

        TextView txt46=(TextView)findViewById(R.id.editText228);
        TextView txt47=(TextView)findViewById(R.id.editText229);
        TextView txt48=(TextView)findViewById(R.id.editText210);
        TextView txt49=(TextView)findViewById(R.id.editText215);
        TextView txt50=(TextView)findViewById(R.id.editText216);
        TextView txt51=(TextView)findViewById(R.id.editText217);
        TextView txt52=(TextView)findViewById(R.id.editText218);
        TextView txt53=(TextView)findViewById(R.id.editText219);
        TextView txt54=(TextView)findViewById(R.id.editText220);
        TextView txt55=(TextView)findViewById(R.id.editText221);
        TextView txt56=(TextView)findViewById(R.id.editText222);
        TextView txt57=(TextView)findViewById(R.id.editText223);
        TextView txt58=(TextView)findViewById(R.id.editText224);
        TextView txt59=(TextView)findViewById(R.id.editText225);
        TextView txt60=(TextView)findViewById(R.id.editText226);
        String[] tabNum=new String[15];
            if(txt1.getText().length()!=0&&txt2.getText().length()!=0&&txt3.getText().length()!=0&&txt4.getText().length()!=0&&txt5.getText().length()!=0&&txt6.getText().length()!=0&&txt7.getText().length()!=0&&txt8.getText().length()!=0&&txt9.getText().length()!=0&&txt10.getText().length()!=0&&txt11.getText().length()!=0
                    &&txt12.getText().length()!=0&&txt13.getText().length()!=0&&txt14.getText().length()!=0&&txt15.getText().length()!=0&&txt16.getText().length()!=0&&txt17.getText().length()!=0&&txt18.getText().length()!=0&&txt19.getText().length()!=0
                    &&txt20.getText().length()!=0) {
                tabNum[0] = txt1.getText().toString() + " " + txt2.getText().toString() + " " + txt3.getText().toString() + " " + txt4.getText().toString() + " 1\n";
                tabNum[1] = txt5.getText().toString() + " " + txt6.getText().toString() + " " + txt7.getText().toString() + " " + txt8.getText().toString() + " 1\n";
                tabNum[2] = txt9.getText().toString() + " " + txt10.getText().toString() + " " + txt11.getText().toString() + " " + txt12.getText().toString() + " 1\n";
                tabNum[3] = txt13.getText().toString() + " " + txt14.getText().toString() + " " + txt15.getText().toString() + " " + txt16.getText().toString() + " 1\n";
                tabNum[4] = txt17.getText().toString() + " " + txt18.getText().toString() + " " + txt19.getText().toString() + " " + txt20.getText().toString() + " 1\n";
            }
            else{
                flag1=false;
            }
            if(txt21.getText().length()!=0&&txt22.getText().length()!=0&&txt23.getText().length()!=0&&txt24.getText().length()!=0&&txt25.getText().length()!=0&&txt26.getText().length()!=0&&txt27.getText().length()!=0&&txt28.getText().length()!=0&&txt29.getText().length()!=0&&txt30.getText().length()!=0
                    &&txt31.getText().length()!=0&&txt32.getText().length()!=0&&txt33.getText().length()!=0&&txt34.getText().length()!=0&&txt35.getText().length()!=0&&txt36.getText().length()!=0&&txt37.getText().length()!=0&&txt38.getText().length()!=0
                    &&txt39.getText().length()!=0&&txt40.getText().length()!=0) {
                tabNum[5] = txt21.getText().toString() + " " + txt22.getText().toString() + " " + txt23.getText().toString() + " " + txt24.getText().toString() + " 2\n";
                tabNum[6] = txt25.getText().toString() + " " + txt26.getText().toString() + " " + txt27.getText().toString() + " " + txt28.getText().toString() + " 2\n";
                tabNum[7] = txt29.getText().toString() + " " + txt30.getText().toString() + " " + txt31.getText().toString() + " " + txt32.getText().toString() + " 2\n";
                tabNum[8] = txt33.getText().toString() + " " + txt34.getText().toString() + " " + txt35.getText().toString() + " " + txt36.getText().toString() + " 2\n";
                tabNum[9] = txt37.getText().toString() + " " + txt38.getText().toString() + " " + txt39.getText().toString() + " " + txt40.getText().toString() + " 2\n";
            }
            else{
                flag2=false;
            }
            if(txt41.getText().length()!=0&&txt42.getText().length()!=0&&txt43.getText().length()!=0&&txt44.getText().length()!=0&&txt45.getText().length()!=0&&txt46.getText().length()!=0&&txt47.getText().length()!=0&&txt48.getText().length()!=0&&txt49.getText().length()!=0
                    &&txt50.getText().length()!=0&&txt51.getText().length()!=0&&txt52.getText().length()!=0&&txt53.getText().length()!=0&&txt54.getText().length()!=0&&txt55.getText().length()!=0&&txt56.getText().length()!=0&&txt57.getText().length()!=0
                    &&txt58.getText().length()!=0&&txt59.getText().length()!=0&&txt60.getText().length()!=0) {
                tabNum[10] = txt41.getText().toString() + " " + txt42.getText().toString() + " " + txt43.getText().toString() + " " + txt44.getText().toString() + " 3\n";
                tabNum[11] = txt45.getText().toString() + " " + txt46.getText().toString() + " " + txt47.getText().toString() + " " + txt48.getText().toString() + " 3\n";
                tabNum[12] = txt49.getText().toString() + " " + txt50.getText().toString() + " " + txt51.getText().toString() + " " + txt52.getText().toString() + " 3\n";
                tabNum[13] = txt53.getText().toString() + " " + txt54.getText().toString() + " " + txt55.getText().toString() + " " + txt56.getText().toString() + " 3\n";
                tabNum[14] = txt57.getText().toString() + " " + txt58.getText().toString() + " " + txt59.getText().toString() + " " + txt60.getText().toString() + " 3";
            }
            else{
                flag3=false;
            }
            if(flag1&&flag2&&flag3) {
                writeFile(tabNum);
                Intent answerIntent = new Intent();
                answerIntent.putExtra(ANSW, "Таблица добавлена успешно");
                setResult(RESULT_OK, answerIntent);
                finish();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "Заполните все поля классов", Toast.LENGTH_SHORT);
                toast.show();
            }
    }
}
