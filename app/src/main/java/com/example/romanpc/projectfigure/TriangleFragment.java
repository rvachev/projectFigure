package com.example.romanpc.projectfigure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.TooltipCompat;
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

public class TriangleFragment extends Fragment {

    Spinner spinner;
    Button getResult;
    EditText firstParam, secondParam, thirdParam;
    TextView result, radius_or_square, textViewTetra, textChoice, name, method, secondText;
    double volume = 0.0;
    int var, varForPerim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triangle, container, false);

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
        name = (TextView)view.findViewById(R.id.nameOf);
        method = (TextView)view.findViewById(R.id.method);

        if(getActivity().getClass().equals(PerimeterActivity.class)){
            methods.add("Обычного треугольника");
            methods.add("Равнобедренного треугольника");
            methods.add("Правильного треугольника");
            name.setText("Периметр треугольника");
            method.setText("Вычислить периметр для");

            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            textViewTetra.setText("Введите вторую сторону");
                            secondParam.setHint("Вторая сторона");
                            textChoice.setText("Введите третью сторону");
                            firstParam.setText("");
                            secondParam.setText("");
                            thirdParam.setText("");
                            thirdParam.setHint("Третья сторона");
                            textChoice.setVisibility(View.VISIBLE);
                            thirdParam.setVisibility(View.VISIBLE);
                            textViewTetra.setVisibility(View.VISIBLE);
                            secondParam.setVisibility(View.VISIBLE);
                            varForPerim = position;
                            break;
                        case 1:
                            textViewTetra.setText("Введите боковую сторону");
                            firstParam.setText("");
                            secondParam.setText("");
                            thirdParam.setText("");
                            secondParam.setHint("Боковая сторона");
                            textChoice.setVisibility(View.GONE);
                            thirdParam.setVisibility(View.GONE);
                            textViewTetra.setVisibility(View.VISIBLE);
                            secondParam.setVisibility(View.VISIBLE);
                            varForPerim = position;
                            break;
                        case 2:
                            radius_or_square.setText("Введите сторону");
                            firstParam.setHint("Сторона");
                            firstParam.setText("");
                            secondParam.setText("");
                            thirdParam.setText("");
                            textChoice.setVisibility(View.GONE);
                            thirdParam.setVisibility(View.GONE);
                            textViewTetra.setVisibility(View.GONE);
                            secondParam.setVisibility(View.GONE);
                            varForPerim = position;
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }else {
            methods.add("С синусом угла и сторонами");
            methods.add("С высотой");
            methods.add("Со всеми сторонами");
            methods.add("Для прямоугольного тр-ка");
            methods.add("Для правильного тр-ка");
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            radius_or_square.setText("Введите первую сторону");
                            firstParam.setHint("Первая сторона");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Вторая сторона");
                            textViewTetra.setText("Введите вторую сторону");
                            textChoice.setText("Введите угол между сторонами");
                            thirdParam.setText("");
                            thirdParam.setHint("Угол");
                            result.setText("Результат: ");
                            var = position;
                            textChoice.setVisibility(View.VISIBLE);
                            thirdParam.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            radius_or_square.setText("Введите высоту");
                            firstParam.setHint("Высота");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Сторона");
                            textViewTetra.setText("Введите сторону");
                            textChoice.setVisibility(View.GONE);
                            thirdParam.setVisibility(View.GONE);
                            result.setText("Результат: ");
                            var = position;
                            break;
                        case 2:
                            radius_or_square.setText("Введите первую сторону");
                            firstParam.setHint("Первая сторона");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Вторая сторона");
                            textViewTetra.setText("Введите вторую сторону");
                            textChoice.setText("Введите третью сторону");
                            thirdParam.setText("");
                            thirdParam.setHint("Третья сторона");
                            result.setText("Результат: ");
                            var = position;
                            textChoice.setVisibility(View.VISIBLE);
                            thirdParam.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            radius_or_square.setText("Введите первый катет");
                            firstParam.setHint("Первый катет");
                            firstParam.setText("");
                            secondParam.setText("");
                            secondParam.setHint("Второй катет");
                            textViewTetra.setText("Введите второй катет");
                            textChoice.setVisibility(View.GONE);
                            thirdParam.setVisibility(View.GONE);
                            result.setText("Результат: ");
                            var = position;
                            break;
                        case 4:
                            radius_or_square.setText("Введите сторону");
                            firstParam.setHint("Сторону");
                            firstParam.setText("");
                            secondParam.setVisibility(View.GONE);
                            textViewTetra.setVisibility(View.GONE);
                            textChoice.setVisibility(View.GONE);
                            thirdParam.setVisibility(View.GONE);
                            result.setText("Результат: ");
                            var = position;
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
                    if (firstParam.getText().toString() != null && Double.parseDouble(firstParam.getText().toString()) > 0.0) {
                        double a = Double.parseDouble(firstParam.getText().toString()), b = 0.0 ,c = 0.0, p = 0.0;
                        try {
                            b = Double.parseDouble(secondParam.getText().toString());
                            c = Double.parseDouble(thirdParam.getText().toString());
                            p = (a + b + c) / 2;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        if(getActivity().getClass().equals(PerimeterActivity.class)){
                            switch (varForPerim){
                                case 0:
                                    if(secondParam.getText().toString() != null && b > 0.0 && thirdParam.getText().toString() != null) {
                                        if(c > 0.0 && a + b > c && a + c > b && b + c > a) {
                                            volume = a + b + c;
                                            result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                                        }else{
                                            Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    break;
                                case 1:
                                    if(secondParam.getText().toString() != null && b > 0.0) {
                                        if(2 * b > a) {
                                            volume = Double.parseDouble(firstParam.getText().toString()) + 2 * Double.parseDouble(secondParam.getText().toString());
                                            result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                                        }else{
                                            Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    break;
                                case 2:
                                    volume = 3 * Double.parseDouble(firstParam.getText().toString());
                                    result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                                    break;
                            }
                        }else {
                            switch (var) {
                                case 0:
                                    if(secondParam.getText().toString() != null && b > 0.0 && thirdParam.getText().toString() != null && c > 0.0) {
                                        volume = a * b * Math.sin(Math.toRadians(Double.parseDouble(thirdParam.getText().toString()))) / 2;
                                        result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    }else{
                                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 1:
                                    if(secondParam.getText().toString() != null && b > 0.0) {
                                        volume = a * b / 2;
                                        result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    }else{
                                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 2:
                                    if(secondParam.getText().toString() != null && b > 0.0 && thirdParam.getText().toString() != null && c > 0.0) {
                                        if (a + b > c && a + c > b && b + c > a) {
                                            volume = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                                            result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                        } else {
                                            Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    break;
                                case 3:
                                    if(secondParam.getText().toString() != null && b > 0.0) {
                                        volume = a * b / 2;
                                        result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    }else{
                                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 4:
                                    volume = (Math.pow(a, 2) * Math.sqrt(3)) / 4;
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
