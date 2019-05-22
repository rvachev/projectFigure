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


public class CilinFragment extends Fragment {

    Spinner spinner;
    Button getResult;
    EditText radius, height;
    TextView result, radius_or_square, name, method;
    double volume = 0.0;
    int var;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cilin, container, false);

        spinner = (Spinner)view.findViewById(R.id.spinner_cilin);
        ArrayList<String> methods = new ArrayList<>();
        methods.add("Площадь основания");
        methods.add("Радиус основания");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        getResult = (Button)view.findViewById(R.id.getResultCilin);
        radius = (EditText)view.findViewById(R.id.radiusCilin);
        height = (EditText)view.findViewById(R.id.heightCilin);
        result = (TextView)view.findViewById(R.id.resultCilin);
        radius_or_square = (TextView)view.findViewById(R.id.radius_or_square_cilin);
        name = (TextView)view.findViewById(R.id.nameOf);
        method = (TextView)view.findViewById(R.id.method);

        if(getActivity().getClass().equals(SquareActivity.class)){
            name.setText("Площадь поверхности цилиндра");
            spinner.setVisibility(View.GONE);
            method.setVisibility(View.GONE);
            radius_or_square.setText("Введите радиус основания:");
            radius.setHint("Радиус основания");
        }else {
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        radius_or_square.setText("Введите площадь основания");
                        radius.setHint("Площаль основания");
                        radius.setText("");
                        height.setText("");
                        result.setText("Результат: ");
                        var = position;
                    } else if (position == 1) {
                        radius_or_square.setText("Введите радиус основания");
                        radius.setHint("Радиус основания");
                        radius.setText("");
                        height.setText("");
                        result.setText("Результат: ");
                        var = position;
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
                    if (radius.getText().toString() != null && Double.parseDouble(radius.getText().toString()) > 0.0 &&
                            height.getText().toString() != null && Double.parseDouble(height.getText().toString()) > 0.0) {
                        if(getActivity().getClass().equals(SquareActivity.class)){
                            volume = 2 * Double.parseDouble(radius.getText().toString()) * (Double.parseDouble(radius.getText().toString()) + Double.parseDouble(height.getText().toString()));
                            result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 кв.ед.");
                        }else {
                            if (var == 0) {
                                volume = Double.parseDouble(radius.getText().toString()) * Double.parseDouble(height.getText().toString());
                                result.setText("Результат: " + String.format("%.2f", volume) + " куб.ед.");
                            } else if (var == 1) {
                                volume = Double.parseDouble(radius.getText().toString()) * Double.parseDouble(radius.getText().toString()) * Double.parseDouble(height.getText().toString());
                                result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 куб.ед.");
                            } else {
                                Toast.makeText(getActivity(), "Невозможно вычислить", Toast.LENGTH_SHORT).show();
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
