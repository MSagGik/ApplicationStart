package com.msaggik.applicationstart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class ExampleFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    // создание интерфейса состояния чек-бокса ???
    public interface ExampleDialogListener {
        void onDialogPositiveClick(boolean status);
        void onDialogNegativeClick();
    }

    // создание полей чек-бокса и кнопки фрагмента
    private CheckBox checkBox;
    private Button button;
    // создание объекта интерфейса прослушивателя диалога
    private ExampleDialogListener exampleDialogListener;

    // метод ???
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            exampleDialogListener = (ExampleDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " должен реализовать ExampleDialogListener");
        }
    }

    // метод ???
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.fragment_example, null);
        builder.setView(view);

        // привязка чек-бокса
        checkBox = view.findViewById(R.id.checkBox);

        builder.setMessage("Открыт новый диалог")
                .setPositiveButton("ЗАПИСАТЬ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        exampleDialogListener.onDialogPositiveClick(checkBox.isChecked());
                    }
                }).setNegativeButton("ОТМЕНА", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        exampleDialogListener.onDialogNegativeClick();
                    }
                });
        return builder.create();
    }
}