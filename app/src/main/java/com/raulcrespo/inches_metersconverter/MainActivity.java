package com.raulcrespo.inches_metersconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText lengthEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        lengthEditText = findViewById(R.id.edit_text_length);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lengthEditText.getText().toString().isEmpty()) {
                    showEmptyError();
                } else {
                    double result = convertToMeters();
                    displayResult(result);
                }
            }
        });
    }

    private void showEmptyError() {
        Toast.makeText(MainActivity.this, "Length field is empty. Please insert a number.", Toast.LENGTH_LONG).show();
    }

    private void displayResult(double result) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String fullResult = numberFormat.format(result) + " meter(s)";
        resultTextView.setText(fullResult);
    }

    private double convertToMeters() {
        return Double.parseDouble(lengthEditText.getText().toString()) * 0.0254;
    }

}