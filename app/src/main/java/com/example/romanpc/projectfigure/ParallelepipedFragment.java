package com.example.romanpc.projectfigure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParallelepipedFragment extends Fragment {

    EditText length, width, height;
    Button getResult;
    TextView result, name;
    double volume, a, b, h;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_parallelepiped, container, false);

        length = (EditText) view.findViewById(R.id.squarePara);
        width = (EditText) view.findViewById(R.id.widthPara);
        height = (EditText) view.findViewById(R.id.heightPara);
        getResult = (Button) view.findViewById(R.id.getResultPara);
        result = (TextView) view.findViewById(R.id.resultPara);
        name = (TextView)view.findViewById(R.id.nameOf);



        if(getActivity().getClass().equals(SquareActivity.class)){
            name.setText("Площадь поверхности \nпараллелепипеда");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (length.getText().toString() != null && Double.parseDouble(length.getText().toString()) > 0.0 &&
                            height.getText().toString() != null && Double.parseDouble(height.getText().toString()) > 0.0 &&
                            width.getText().toString() != null && Double.parseDouble(width.getText().toString()) > 0.0) {
                        a = Double.parseDouble(length.getText().toString());
                        b = Double.parseDouble(height.getText().toString());
                        h = Double.parseDouble(width.getText().toString());
                        if(getActivity().getClass().equals(SquareActivity.class)){
                            volume = 2 * (a * b + a * h + b * h);
                            result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                        }else{
                            volume = a * b * h;
                            result.setText("Результат: " + String.format("%.2f", volume) + " куб.ед.");
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
