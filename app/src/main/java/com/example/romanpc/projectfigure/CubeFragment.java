package com.example.romanpc.projectfigure;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class CubeFragment extends Fragment {

    Button getResult;
    EditText lenght;
    TextView result, name;
    double volume;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cube, container, false);

        getResult = (Button)view.findViewById(R.id.getResultCube);
        lenght = (EditText)view.findViewById(R.id.radiusCube);
        result = (TextView)view.findViewById(R.id.resultCube);
        name = (TextView)view.findViewById(R.id.nameOf);

        if(getActivity().getClass().equals(SquareActivity.class)){
            name.setText("Площадь поверхности куба");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (lenght.getText().toString() != null && Double.parseDouble(lenght.getText().toString()) > 0.0) {
                        if(getActivity().getClass().equals(SquareActivity.class)){
                            volume = 6 * Double.parseDouble(lenght.getText().toString()) * Double.parseDouble(lenght.getText().toString());
                            result.setText("Результат: " + String.format("%.2f", volume) + " кв.ед.");
                        }else {
                            volume = Math.pow(Double.parseDouble(lenght.getText().toString()), 3);
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
