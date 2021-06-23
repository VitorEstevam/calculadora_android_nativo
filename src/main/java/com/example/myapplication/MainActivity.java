package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    List<String> operations = new ArrayList<>(Arrays.asList("somar", "subtrair", "dividir", "multiplicar"));
    Button btRun;
    Spinner spinner;
    String operation;
    EditText n1, n2;
    TextView resultTextView;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, operations );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
        operation = operations.get(0);
        //button
        btRun = (Button) findViewById(R.id.button);
        btRun.setOnClickListener(this);
        //numbers
        n1 = (EditText) findViewById(R.id.editTextN1);
        n2 = (EditText) findViewById(R.id.editTextN2);
        n1.setInputType(InputType.TYPE_CLASS_NUMBER);
        n2.setInputType(InputType.TYPE_CLASS_NUMBER);
        //result
        resultTextView = (TextView) findViewById(R.id.textViewResult);
    }

    @Override
    public void onClick(View view) {
        if(view == btRun){
            int v1 = Integer.parseInt(n1.getText().toString());
            int v2 = Integer.parseInt(n2.getText().toString());
            switch (operation){
                case "somar":
                    result = v1 + v2;
                    break;
                case "subtrair":
                    result = v1 - v2;
                    break;
                case "dividir":
                    result = v1 / v2;
                    break;
                case "multiplicar":
                    result = v1 * v2;
                    break;
            }

        resultTextView.setText(String.valueOf(result));
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        operation = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}