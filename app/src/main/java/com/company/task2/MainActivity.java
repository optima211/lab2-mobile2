package com.company.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button SendBT;
    RadioButton RB_B, RB_C;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendBT = findViewById(R.id.BtSendCA);
        RB_B = findViewById(R.id.RBClassB);
        RB_C = findViewById(R.id.RBBClassC);
        editText = findViewById(R.id.ETClassA);

        SendBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RB_B.isChecked()) {
                    Intent intentB = new Intent(MainActivity.this, B.class);
                    startActivityForResult(intentB, 1);
                }

                if (RB_C.isChecked()) {
                    Intent intentC = new Intent(MainActivity.this, C.class);
                    startActivityForResult(intentC, 2);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;} // если намерение не возвратилось, то выходим
        String str = data.getStringExtra("MyString");//Извлекаем переданную строку MyString

        String name = null;
        if (requestCode == 1) name = "A";
        if (requestCode == 2) name = "B";

        editText.setText(editText.getText() + "Класс "+ name +" вернул строку: " + str + "\n");//Выводим строку на экран
    }
}