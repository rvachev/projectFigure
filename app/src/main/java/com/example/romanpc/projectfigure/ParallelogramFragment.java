package com.example.romanpc.projectfigure;

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

public class ParallelogramFragment extends Fragment {

    Spinner spinner;
    Button getResult;
    EditText firstParam, secondParam, thirdParam;
    TextView result, radius_or_square, textViewTetra, textChoice, name, method;
    double volume = 0.0;
    int var;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parallelogram, container, false);

        spinner = (Spinner)view.findViewById(R.id.spinner_tetra);
        ArrayList<String> methods = new ArrayList<>();
        methods.add("Синуса угла и сторон");
        methods.add("Высоты");
        methods.add("Диагоналей");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

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

        if(getActivity().getClass().equals(PerimeterActivity.class)){
            name.setText("Периметр параллелограмма");
            spinner.setVisibility(View.GONE);
            method.setVisibility(View.GONE);
            textChoice.setVisibility(View.GONE);
            thirdParam.setVisibility(View.GONE);
            radius_or_square.setText("Введите первую сторону");
            firstParam.setHint("Первая сторона");
            firstParam.setText("");
            secondParam.setText("");
            secondParam.setHint("Вторая сторона");
            textViewTetra.setText("Введите вторую сторону");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (firstParam.getText().toString() != null && Double.parseDouble(firstParam.getText().toString()) > 0.0 &&
                            secondParam.getText().toString() != null && Double.parseDouble(secondParam.getText().toString()) > 0.0) {
                        if(getActivity().getClass().equals(PerimeterActivity.class)){
                            volume = 2 * (Double.parseDouble(firstParam.getText().toString()) + Double.parseDouble(secondParam.getText().toString()));
                            result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                        }else {
                            switch (var) {
                                case 0:
                                    if (thirdParam.getText().toString() != null && Double.parseDouble(thirdParam.getText().toString()) > 0.0 && Double.parseDouble(thirdParam.getText().toString()) < 180.0) {
                                        volume = Double.parseDouble(firstParam.getText().toString()) * Double.parseDouble(secondParam.getText().toString()) * Math.sin(Math.toRadians(Double.parseDouble(thirdParam.getText().toString())));
                                        result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    } else {
                                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 1:
                                    volume = Double.parseDouble(firstParam.getText().toString()) * Double.parseDouble(secondParam.getText().toString());
                                    result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    break;
                                case 2:
                                    if (thirdParam.getText().toString() != null && Double.parseDouble(thirdParam.getText().toString()) > 0.0 && Double.parseDouble(thirdParam.getText().toString()) < 180.0) {
                                        volume = Double.parseDouble(firstParam.getText().toString()) * Double.parseDouble(secondParam.getText().toString()) * Math.sin(Math.toRadians(Double.parseDouble(thirdParam.getText().toString()))) / 2;
                                        result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                                    } else {
                                        Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
                                    }
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
