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

public class PiraFragment extends Fragment {

    EditText square, height;
    Button getResult;
    TextView result;
    double volume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pira, container, false);

        square = (EditText) view.findViewById(R.id.squarePira);
        height = (EditText) view.findViewById(R.id.heightPira);
        getResult = (Button) view.findViewById(R.id.getResultPira);
        result = (TextView) view.findViewById(R.id.resultPira);

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (square.getText().toString() != null && Double.parseDouble(square.getText().toString()) > 0.0 &&
                            height.getText().toString() != null && Double.parseDouble(height.getText().toString()) > 0.0) {
                        volume = Double.parseDouble(square.getText().toString()) * Double.parseDouble(height.getText().toString()) / 3;
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
