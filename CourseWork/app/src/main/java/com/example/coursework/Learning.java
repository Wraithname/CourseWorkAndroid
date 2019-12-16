package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Learning extends AppCompatActivity {
    final String FILENAME = "file";
    final String LOG_TAG = "CourseLog";
    EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20;
    EditText txt21,txt22,txt23,txt24,txt25,txt26,txt27,txt28,txt29,txt30,txt31,txt32,txt33,txt34,txt35,txt36,txt37,txt38,txt39,txt40;
    EditText txt41,txt42,txt43,txt44,txt45,txt46,txt47,txt48,txt49,txt50,txt51,txt52,txt53,txt54,txt55,txt56,txt57,txt58,txt59,txt60;
    public final static String ANSW = "com.example.coursework.ANSW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        txt1=(EditText)findViewById(R.id.editText11);
        txt2=(EditText)findViewById(R.id.editText12);
        txt3=(EditText)findViewById(R.id.editText13);
        txt4=(EditText)findViewById(R.id.editText14);
        txt5=(EditText)findViewById(R.id.editText7);
        txt6=(EditText)findViewById(R.id.editText8);
        txt7=(EditText)findViewById(R.id.editText9);
        txt8=(EditText)findViewById(R.id.editText10);
        txt9=(EditText)findViewById(R.id.editText15);
        txt10=(EditText)findViewById(R.id.editText16);
        txt11=(EditText)findViewById(R.id.editText17);
        txt12=(EditText)findViewById(R.id.editText18);
        txt13=(EditText)findViewById(R.id.editText19);
        txt14=(EditText)findViewById(R.id.editText20);
        txt15=(EditText)findViewById(R.id.editText21);
        txt16=(EditText)findViewById(R.id.editText22);
        txt17=(EditText)findViewById(R.id.editText23);
        txt18=(EditText)findViewById(R.id.editText24);
        txt19=(EditText)findViewById(R.id.editText25);
        txt20=(EditText)findViewById(R.id.editText26);
        txt21=(EditText)findViewById(R.id.editText111);
        txt22=(EditText)findViewById(R.id.editText112);
        txt23=(EditText)findViewById(R.id.editText113);
        txt24=(EditText)findViewById(R.id.editText114);
        txt25=(EditText)findViewById(R.id.editText117);
        txt26=(EditText)findViewById(R.id.editText118);
        txt27=(EditText)findViewById(R.id.editText119);
        txt28=(EditText)findViewById(R.id.editText110);
        txt29=(EditText)findViewById(R.id.editText115);
        txt30=(EditText)findViewById(R.id.editText116);
        txt31=(EditText)findViewById(R.id.editText117);
        txt32=(EditText)findViewById(R.id.editText118);
        txt33=(EditText)findViewById(R.id.editText119);
        txt34=(EditText)findViewById(R.id.editText120);
        txt35=(EditText)findViewById(R.id.editText121);
        txt36=(EditText)findViewById(R.id.editText122);
        txt37=(EditText)findViewById(R.id.editText123);
        txt38=(EditText)findViewById(R.id.editText124);
        txt39=(EditText)findViewById(R.id.editText125);
        txt40=(EditText)findViewById(R.id.editText126);
        txt41=(EditText)findViewById(R.id.editText211);
        txt42=(EditText)findViewById(R.id.editText212);
        txt43=(EditText)findViewById(R.id.editText213);
        txt44=(EditText)findViewById(R.id.editText214);
        txt45=(EditText)findViewById(R.id.editText227);
        txt46=(EditText)findViewById(R.id.editText228);
        txt47=(EditText)findViewById(R.id.editText229);
        txt48=(EditText)findViewById(R.id.editText210);
        txt49=(EditText)findViewById(R.id.editText215);
        txt50=(EditText)findViewById(R.id.editText216);
        txt51=(EditText)findViewById(R.id.editText217);
        txt52=(EditText)findViewById(R.id.editText218);
        txt53=(EditText)findViewById(R.id.editText219);
        txt54=(EditText)findViewById(R.id.editText220);
        txt55=(EditText)findViewById(R.id.editText221);
        txt56=(EditText)findViewById(R.id.editText222);
        txt57=(EditText)findViewById(R.id.editText223);
        txt58=(EditText)findViewById(R.id.editText224);
        txt59=(EditText)findViewById(R.id.editText225);
        txt60=(EditText)findViewById(R.id.editText226);
        setContentView(R.layout.activity_learning);
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
    public void onClick(View view) {
        Intent answerIntent=new Intent();
        answerIntent.putExtra(ANSW, "Таблица добавлена успешно");
        String[] tabNum=new String[15];
            tabNum[0]=txt1.getText().toString()+" "+txt2.getText().toString()+" "+txt3.getText().toString()+" "+txt4.getText().toString()+" 1";
            tabNum[1]=txt5.getText().toString()+" "+txt6.getText().toString()+" "+txt7.getText().toString()+" "+txt8.getText().toString()+" 1";
            tabNum[2]=txt9.getText().toString()+" "+txt10.getText().toString()+" "+txt11.getText().toString()+" "+txt12.getText().toString()+" 1";
            tabNum[3]=txt13.getText().toString()+" "+txt14.getText().toString()+" "+txt15.getText().toString()+" "+txt16.getText().toString()+" 1";
            tabNum[4]=txt17.getText().toString()+" "+txt18.getText().toString()+" "+txt19.getText().toString()+" "+txt20.getText().toString()+" 1";
            tabNum[5]=txt21.getText().toString()+" "+txt22.getText().toString()+" "+txt23.getText().toString()+" "+txt24.getText().toString()+" 2";
            tabNum[6]=txt25.getText().toString()+" "+txt26.getText().toString()+" "+txt27.getText().toString()+" "+txt28.getText().toString()+" 2";
            tabNum[7]=txt29.getText().toString()+" "+txt30.getText().toString()+" "+txt31.getText().toString()+" "+txt32.getText().toString()+" 2";
            tabNum[8]=txt33.getText().toString()+" "+txt34.getText().toString()+" "+txt35.getText().toString()+" "+txt36.getText().toString()+" 2";
            tabNum[9]=txt37.getText().toString()+" "+txt38.getText().toString()+" "+txt39.getText().toString()+" "+txt40.getText().toString()+" 2";
            tabNum[9]=txt41.getText().toString()+" "+txt42.getText().toString()+" "+txt43.getText().toString()+" "+txt44.getText().toString()+" 3";
            tabNum[9]=txt45.getText().toString()+" "+txt46.getText().toString()+" "+txt47.getText().toString()+" "+txt48.getText().toString()+" 3";
            tabNum[9]=txt49.getText().toString()+" "+txt50.getText().toString()+" "+txt51.getText().toString()+" "+txt52.getText().toString()+" 3";
            tabNum[9]=txt53.getText().toString()+" "+txt54.getText().toString()+" "+txt55.getText().toString()+" "+txt56.getText().toString()+" 3";
            tabNum[9]=txt57.getText().toString()+" "+txt58.getText().toString()+" "+txt59.getText().toString()+" "+txt60.getText().toString()+" 3";
            writeFile(tabNum);
        setResult(RESULT_OK,answerIntent);
        finish();
    }
}
