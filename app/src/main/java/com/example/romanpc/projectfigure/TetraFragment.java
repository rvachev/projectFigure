package com.example.romanpc.projectfigure;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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

public class TetraFragment extends Fragment {

    Spinner spinner;
    Button getResult;
    EditText radius, height;
    TextView result, radius_or_square, textViewTetra;
    double volume = 0.0;
    int var;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tetra, container, false);

        spinner = (Spinner)view.findViewById(R.id.spinner_tetra);
        ArrayList<String> methods = new ArrayList<>();
        methods.add("Правильного тетраэдра");
        methods.add("Обычного тетраэдра");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, methods);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        getResult = (Button)view.findViewById(R.id.getResultTetra);
        radius = (EditText)view.findViewById(R.id.radiusTetra);
        height = (EditText)view.findViewById(R.id.heightTetra);
        result = (TextView)view.findViewById(R.id.resultTetra);
        radius_or_square = (TextView)view.findViewById(R.id.radius_or_square_tetra);
        textViewTetra = (TextView)view.findViewById(R.id.textViewTetra);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    radius_or_square.setText("Введите сторону тетраэдра");
                    radius.setHint("Сторона тетраэдра");
                    textViewTetra.setVisibility(View.GONE);
                    height.setVisibility(View.GONE);
                    radius.setText("");
                    height.setText("");
                    result.setText("Результат: ");
                    var = position;
                }else if(position == 1){
                    textViewTetra.setVisibility(View.VISIBLE);
                    height.setVisibility(View.VISIBLE);
                    radius_or_square.setText("Введите площадь основания");
                    radius.setHint("Площаль основания");
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

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (var == 0 && radius.getText().toString() != null && Double.parseDouble(radius.getText().toString()) > 0.0) {
                        volume = Math.pow(Double.parseDouble(radius.getText().toString()), 3) * Math.sqrt(2) / 12;
                        result.setText("Результат: " + String.format("%.2f", volume) + " куб.ед.");
                    } else if (var == 1 && radius.getText().toString() != null && Double.parseDouble(radius.getText().toString()) > 0.0 &&
                            height.getText().toString() != null && Double.parseDouble(height.getText().toString()) > 0.0) {
                        volume = Double.parseDouble(radius.getText().toString()) * Double.parseDouble(radius.getText().toString()) * Double.parseDouble(height.getText().toString()) / 3;
                        result.setText("Результат: " + String.format("%.2f", volume) + " куб.ед.");
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
