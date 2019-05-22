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

public class SquareFigureFragment extends Fragment {

    Button getResult;
    EditText param;
    TextView result, name;
    double volume = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square_figure, container, false);

        getResult = (Button)view.findViewById(R.id.getResultShar);
        param = (EditText)view.findViewById(R.id.radiusShar);
        result = (TextView)view.findViewById(R.id.resultShar);
        name = (TextView)view.findViewById(R.id.nameOf);

        if(getActivity().getClass().equals(PerimeterActivity.class)){
            name.setText("Периметр квадрата");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (param.getText().toString() != null && Double.parseDouble(param.getText().toString()) > 0.0) {
                        if(getActivity().getClass().equals(PerimeterActivity.class)){
                            volume = 4 * Double.parseDouble(param.getText().toString());
                            result.setText("Результат: " + String.format("%.2f", volume) + " ед.");
                        }else {
                            volume = Math.pow(Double.parseDouble(param.getText().toString()), 2);
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
