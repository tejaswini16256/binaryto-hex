package com.example.binarytohex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button convertButton;
    private TextView binaryTextView, hexTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        convertButton = findViewById(R.id.convertButton);
        binaryTextView = findViewById(R.id.binaryTextView);
        hexTextView = findViewById(R.id.hexTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNumber = numberEditText.getText().toString();

                if (!TextUtils.isEmpty(inputNumber)) {
                    try {
                        int decimalNumber = Integer.parseInt(inputNumber);
                        String binaryNumber = Integer.toBinaryString(decimalNumber);
                        String hexNumber = Integer.toHexString(decimalNumber);

                        binaryTextView.setText("Binary: " + binaryNumber);
                        hexTextView.setText("Hexadecimal: " + hexNumber);
                    } catch (NumberFormatException e) {
                        binaryTextView.setText("Invalid input");
                        hexTextView.setText("");
                    }
                } else {
                    binaryTextView.setText("Enter a number");
                    hexTextView.setText("");
                }
            }
        });
    }
}


