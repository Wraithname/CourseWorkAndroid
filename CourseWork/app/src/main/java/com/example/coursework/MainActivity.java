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
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    /**
     * код ответа
     */
    static final private int CHOOSE=0;
    /**
     * Тэг логов
     */
    final String LOG_TAG = "CourseLog";
    /**
     * Название файла
     */
    final String FILENAME = "file";

    /**
     * @param savedInstanceState - сохраненнные данные для отрисовки
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param menu - интерфейс меню
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuactivity, menu);
        return true;
    }

    /**
     *
     * @param item - элементы меню
     * @return - возвращает true - если элемент был выбран
     */
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

    /**
     *
     * @param requestCode - код ответа с выбранного интерфейса
     * @param resultCode - код результата с выбранного интерфейса
     * @param data - данные с выбранного интерфейса
     */
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

    /**
     *
     * @return - возвращает массим строк с параметрами классов
     */
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

    /**
     * @param view - интерфейс пользователя
     */
    public void startCalculation(View view) {
        TextView second_column= (TextView)findViewById(R.id.textView9);
        TextView third_column= (TextView)findViewById(R.id.textView10);
        TextView forth_column= (TextView)findViewById(R.id.textView8);
        TextView fives_column= (TextView)findViewById(R.id.textView11);
        TextView result=(TextView)findViewById(R.id.textView7);
        double[] find=new double[4];
        if(second_column.getText().length()!=0&&third_column.getText().length()!=0&&forth_column.getText().length()!=0&&fives_column.getText().length()!=0) {
            find[0] = Double.parseDouble(second_column.getText().toString());
            find[1] = Double.parseDouble(third_column.getText().toString());
            find[2] = Double.parseDouble(forth_column.getText().toString());
            find[3] = Double.parseDouble(fives_column.getText().toString());
            TextView result11 = (TextView) findViewById(R.id.textView16);
            TextView result12 = (TextView) findViewById(R.id.textView17);
            TextView result13 = (TextView) findViewById(R.id.textView18);
            TextView result21 = (TextView) findViewById(R.id.textView20);
            TextView result22 = (TextView) findViewById(R.id.textView25);
            TextView result23 = (TextView) findViewById(R.id.textView29);
            TextView result211 = (TextView) findViewById(R.id.textView22);
            TextView result222 = (TextView) findViewById(R.id.textView27);
            TextView result233 = (TextView) findViewById(R.id.textView31);
            TextView result3 = (TextView) findViewById(R.id.textView34);
            //Запись начальных данных в файл
            String[] str = readFile();
            String a = "";
            Analis analis = new Analis();
            double[] h = analis.Analisis(str, find);
            result11.setText(String.valueOf(h[0]));
            result12.setText(String.valueOf(h[1]));
            result13.setText(String.valueOf(h[2]));
            if (h[0] > h[1] && h[0] > h[2]) {
                a = "1";
                result11.setTextColor(this.getResources().getColor(R.color.colorRed));
            } else if (h[1] > h[0] && h[1] > h[2]) {
                a = "2";
                result12.setTextColor(this.getResources().getColor(R.color.colorRed));
            } else if (h[2] > h[1] & h[2] > h[0]) {
                a = "3";
                result13.setTextColor(this.getResources().getColor(R.color.colorRed));
            }
            LineRaspr lineRaspr = new LineRaspr();
            String b = "";
            double[][] k = lineRaspr.Raspr(str, find);
            result21.setText(String.valueOf(k[0][0]));
            result22.setText(String.valueOf(k[1][0]));
            result23.setText(String.valueOf(k[2][0]));
            result211.setText(String.valueOf(k[0][1]));
            result222.setText(String.valueOf(k[1][1]));
            result233.setText(String.valueOf(k[2][1]));
            if ((k[0][0] < k[1][0] && k[0][0] < k[2][0]) || (k[0][1] > k[1][1] && k[0][1] > k[2][1])) {
                b = "1";
                result21.setTextColor(this.getResources().getColor(R.color.colorRed));
                result211.setTextColor(this.getResources().getColor(R.color.colorRed));
            }
            if ((k[1][0] < k[0][0] && k[1][0] < k[2][0]) || (k[1][1] > k[0][1] && k[1][1] > k[2][1])) {
                b = "2";
                result22.setTextColor(this.getResources().getColor(R.color.colorRed));
                result222.setTextColor(this.getResources().getColor(R.color.colorRed));
            }
            if ((k[2][0] < k[1][0] && k[2][0] < k[0][0]) || (k[2][1] > k[1][1] && k[2][1] > k[0][1])) {
                b = "3";
                result23.setTextColor(this.getResources().getColor(R.color.colorRed));
                result233.setTextColor(this.getResources().getColor(R.color.colorRed));
            }
            Regression regress = new Regression();
            String j = "";
            double r = regress.Regre(str, find);
            double c=Math.ceil(r);
            String res="";
            res+=String.valueOf(r);
            if (c ==1) {
                j = "1";
                res+=" (1 Класс)";
                result3.setText(res);
            }
            if (c == 2) {
                j = "2";
                res+=" (2 Класс)";
                result3.setText(res);
            }
            if (c == 3) {
                j = "3";
                res+=" (3 Класс)";
                result3.setText(res);
            }
            if (Integer.getInteger(a) == Integer.getInteger(b) && Integer.getInteger(a) == Integer.getInteger(j))
                result.setText(a);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "Заполните все характеристики объекта", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}