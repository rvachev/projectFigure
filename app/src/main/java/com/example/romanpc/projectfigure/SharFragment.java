package com.example.romanpc.projectfigure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SharFragment extends Fragment {

    Button getResult;
    EditText radius;
    TextView result, name;
    double volume = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        getResult = (Button)view.findViewById(R.id.getResultShar);
        radius = (EditText)view.findViewById(R.id.radiusShar);
        result = (TextView)view.findViewById(R.id.resultShar);
        name = (TextView)view.findViewById(R.id.nameOf);

        if(getActivity().getClass().equals(SquareActivity.class)){
            name.setText("Площадь поверхности шара");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            if (radius.getText().toString() != null && Double.parseDouble(radius.getText().toString()) > 0.0) {
                                if(getActivity().getClass().equals(SquareActivity.class)) {
                                    volume = 4 * Math.pow(Double.parseDouble(radius.getText().toString()), 2);
                                    result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 кв.ед.");
                                }else{
                                    volume = 4 * Double.parseDouble(radius.getText().toString()) / 3;
                                    result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 куб.ед.");
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
