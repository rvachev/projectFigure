package com.example.romanpc.projectfigure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrapezeFragment extends Fragment {

    Spinner spinner;
    Button getResult;
    EditText firstParam, secondParam, thirdParam, foutrhParam;
    TextView result, radius_or_square, textViewTetra, textChoice, name, method, textChoice2;
    double volume = 0.0;
    int var, varForPerim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trapeze, container, false);

        spinner = (Spinner)view.findViewById(R.id.spinner_tetra);
        ArrayList<String> methods = new ArrayList<>();

        getResult = (Button)view.findViewById(R.id.getResultTetra);
        firstParam = (EditText)view.findViewById(R.id.radiusTetra);
        secondParam = (EditText)view.findViewById(R.id.heightTetra);
        thirdParam = (EditText)view.findViewById(R.id.thirdParams);
        result = (TextView)view.findViewById(R.id.resultTetra);
        radius_or_square = (TextView)view.findViewById(R.id.radius_or_square_tetra);
        textViewTetra = (TextView)view.findViewById(R.id.textViewTetra);
        textChoice = (TextView)view.findViewById(R.id.textChoice);
        textChoice2 = (TextView)view.findViewById(R.id.textChoice2);
        foutrhParam = (EditText)view.findViewById(R.id.fourthParams);
        name = (TextView) view.findViewById(R.id.nameOf);
        method = (TextView)view.findViewById(R.id.method);


        if(getActivity().getClass().equals(PerimeterActivity.class)){
            methods.add("Обычной трапеции");
            methods.add("Равнобедренной трапеции");
            name.setText("Периметр трапеции");
            method.setText("Вычислить периметр для");

            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            foutrhParam.setVisibility(View.VISIBLE);
                            textChoice2.setVisibility(View.VISIBLE);
                            textChoice.setText("Введите первую боковую сторону");
                            firstParam.setText("");
                            secondParam.setText("");
                            thirdParam.setText("");
                            foutrhParam.setText("");
                            thirdParam.setHint("Первая боковая сторона");
                            varForPerim = position;
                            break;
                        case 1:
                            foutrhParam.setVisibility(View.GONE);
                            textChoice2.setVisibility(View.GONE);
                            textChoice.setText("Введите боковую сторону");
                            firstParam.setText("");
                            secondParam.setText("");
                            thirdParam.setText("");
                            varForPerim = position;
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }else {
            methods.add("Оснований и высоты");
            methods.add("Диагоналей");
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            radius_or_square.setText("Введите первое основание");
                            firstParam.setHint("Первое основание");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Второе основание");
                            textViewTetra.setText("Введите второе основание");
                            textChoice.setText("Введите высоту");
                            thirdParam.setText("");
                            thirdParam.setHint("Высота");
                            result.setText("Результат: ");
                            var = position;
                            textChoice.setVisibility(View.VISIBLE);
                            thirdParam.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            radius_or_square.setText("Введите первую диагональ");
                            firstParam.setHint("Первая диагональ");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Вторая диагональ");
                            textViewTetra.setText("Введите вторую диагональ");
                            textChoice.setText("Введите угол между диагоналями");
                            thirdParam.setText("");
                            thirdParam.setHint("Угол");
                            result.setText("Результат: ");
                            var = position;
                            textChoice.setVisibility(View.VISIBLE);
                            thirdParam.setVisibility(View.VISIBLE);
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }



        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (firstParam.getText().toString() != null && Double.parseDouble(firstParam.getText().toString()) > 0.0 &&
                            secondParam.getText().toString() != null && Double.parseDouble(secondParam.getText().toString()) > 0.0 &&
                            thirdParam.getText().toString() != null && Double.parseDouble(thirdParam.getText().toString()) > 0.0) {
                        if(getActivity().getClass().equals(PerimeterActivity.class) && foutrhParam.getText().toString() != null && Double.parseDouble(foutrhParam.getText().toString()) > 0.0){
                            switch (varForPerim){
                                case 0:
                                    volume = Double.parseDouble(firstParam.getText().toString()) + Double.parseDouble(secondParam.getText().toString()) + Double.parseDouble(thirdParam.getText().toString()) + Double.parseDouble(foutrhParam.getText().toString());
                                    result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                                    break;
                                case 1:
                                    volume = Double.parseDouble(firstParam.getText().toString()) + Double.parseDouble(secondParam.getText().toString()) + 2 * Double.parseDouble(thirdParam.getText().toString());
                                    result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                                    break;
                            }
                        }else {
                            switch (var) {
                                case 0:
                                    volume = (Double.parseDouble(firstParam.getText().toString()) + Double.parseDouble(secondParam.getText().toString())) / 2 * Double.parseDouble(thirdParam.getText().toString());
                                    result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    break;
                                case 1:
                                    volume = (Double.parseDouble(firstParam.getText().toString()) * Double.parseDouble(secondParam.getText().toString())) / 2 * Math.sin(Math.toRadians(Double.parseDouble(thirdParam.getText().toString())));
                                    result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    break;
                                default:
                                    Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    }else{
                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
