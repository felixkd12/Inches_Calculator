package com.welovecrazyquotes.inchescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultTextView;
    private String inchesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        calculateActionButton();

    }

    private double convertsToMeters() {

        inchesText = inchesEditText.getText().toString();
        double inches = Double.parseDouble(inchesText);

        return inches * 0.0254;
    }

    private void findViews() {

        inchesEditText = findViewById(R.id.inches_edit_text);
        calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_text_view);

    }

    private void calculateActionButton() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inchesText = inchesEditText.getText().toString();
                String warning = "Field Inches cannot be empty";

                if (inchesText.isEmpty()){
                    Toast.makeText(MainActivity.this, warning, Toast.LENGTH_SHORT).show();
                } else {

                    double inches = convertsToMeters();
                    convertsToMeters();
                    displayResult(inches);
                }

            }
        });
    }

    private void displayResult(double inches){

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String inchesConverted = myDecimalFormatter.format(inches);

        resultTextView.setText(inchesConverted);

    }


}