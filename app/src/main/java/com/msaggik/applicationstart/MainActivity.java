package com.msaggik.applicationstart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleFragment.ExampleDialogListener {

    // задние полей кнопки и текствью основновного активити
    private Button btn_activity;
    private TextView textOut;
    // создание объекта фрагмента
    private ExampleFragment exampleFragment = new ExampleFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка кнопки активити
        btn_activity = findViewById(R.id.button);
        // привязка окна вывода состояния чек-бокса в активити
        textOut = findViewById(R.id.textOut);

        //setExampleFragment(exampleFragment); // метод замены фрейма на фрагмент

        // обработка нажатия кнопки активити
        btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setExampleFragment(exampleFragment);
                DialogFragment newFragment = new ExampleFragment();
                newFragment.show(getSupportFragmentManager(), "Тег диалога");
            }
        });
    }

   /*// дополнительный метод отображения фрагментов
    private void setExampleFragment(Fragment fragment) {
        // перенос фрагмента ???
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment); // замена фрейма на фрагмент
        ft.addToBackStack(null); // не дублирование фрагмента для оптимизации памяти
        ft.commit(); // сохранение фрагмента
    } */

    @Override
    public void onDialogPositiveClick(boolean status) {
        if(status == true) {
            textOut.setText("Чек-бокс включён");
        } else if (status == false) {
            textOut.setText("Чек-бокс выключен");
        }
    }

    @Override
    public void onDialogNegativeClick() {
        textOut.setText("");
    }
}