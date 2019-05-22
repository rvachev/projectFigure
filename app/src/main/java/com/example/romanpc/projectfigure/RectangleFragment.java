package com.example.romanpc.projectfigure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RectangleFragment extends Fragment {

    EditText firstParam, secondParam;
    Button getResult;
    TextView result, name;
    double volume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rectangle, container, false);

        firstParam = (EditText) view.findViewById(R.id.squarePira);
        secondParam = (EditText) view.findViewById(R.id.heightPira);
        getResult = (Button) view.findViewById(R.id.getResultPira);
        result = (TextView) view.findViewById(R.id.resultPira);
        name = (TextView) view.findViewById(R.id.nameOf);

        if(getActivity().getClass().equals(PerimeterActivity.class)){
            name.setText("Периметр прямоугольника");
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
                            volume = Double.parseDouble(firstParam.getText().toString()) * Double.parseDouble(secondParam.getText().toString());
                            result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
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
