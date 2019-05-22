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


public class EllipseFragment extends Fragment {

    EditText bigR, smallR;
    Button getResult;
    TextView result, name;
    double volume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ellipse, container, false);

        bigR = (EditText) view.findViewById(R.id.squarePira);
        smallR = (EditText) view.findViewById(R.id.heightPira);
        getResult = (Button) view.findViewById(R.id.getResultPira);
        result = (TextView) view.findViewById(R.id.resultPira);
        name = (TextView) view.findViewById(R.id.nameOf);

        if(getActivity().getClass().equals(PerimeterActivity.class)){
            name.setText("Длина эллипса");
        }

        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (bigR.getText().toString() != null && Double.parseDouble(bigR.getText().toString()) > 0.0 &&
                            smallR.getText().toString() != null && Double.parseDouble(smallR.getText().toString()) > 0.0) {
                        double a = Double.parseDouble(bigR.getText().toString());
                        double b = Double.parseDouble(smallR.getText().toString());
                        if(getActivity().getClass().equals(PerimeterActivity.class)){
                            volume = 2 * Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2))) / 2;
                            result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 ед.");
                        }else {
                            volume = a * b;
                            result.setText("Результат: " + String.format("%.2f", volume) + "\u03C0 кв.ед.");
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
