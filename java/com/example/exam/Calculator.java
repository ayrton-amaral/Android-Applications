package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonAddition, buttonSubtraction, buttonMultiplication, buttonDivision, buttonEqual,
            buttonPoint, buttonClear;

    TextView editTextOperation;

    private double num1 = Double.NaN, num2;
    private char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editTextOperation = findViewById(R.id.editTextOperation);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAddition = findViewById(R.id.addition);
        buttonSubtraction = findViewById(R.id.subtraction);
        buttonMultiplication = findViewById(R.id.multiplication);
        buttonDivision = findViewById(R.id.division);
        buttonEqual = findViewById(R.id.equal);
        buttonPoint = findViewById(R.id.btnPoint);
        buttonClear = findViewById(R.id.btnClear);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                editTextOperation.setText(editTextOperation.getText().toString() + button.getText().toString());
            }
        };

        View.OnClickListener decimalListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextOperation.getText().toString().contains(".")) {
                    editTextOperation.setText(editTextOperation.getText().toString() + ".");
                }
            }
        };

        View.OnClickListener operationListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (!Double.isNaN(num1) && !editTextOperation.getText().toString().isEmpty()) {
                    makeCalculation();
                }
                if (!editTextOperation.getText().toString().isEmpty()) {
                    num1 = Double.parseDouble(editTextOperation.getText().toString());
                }
                op = button.getText().toString().charAt(0);
                editTextOperation.setText("");
            }
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        buttonAddition.setOnClickListener(operationListener);
        buttonSubtraction.setOnClickListener(operationListener);
        buttonMultiplication.setOnClickListener(operationListener);
        buttonDivision.setOnClickListener(operationListener);
        buttonPoint.setOnClickListener(decimalListener);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Double.isNaN(num1) && !editTextOperation.getText().toString().isEmpty()) {
                    makeCalculation();
                    editTextOperation.setText(String.valueOf(num1));
                    num1 = Double.NaN;
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.NaN;
                num2 = Double.NaN;
                editTextOperation.setText("");
            }
        });
    }

    private void makeCalculation() {
        if (!Double.isNaN(num1) && !editTextOperation.getText().toString().isEmpty()) {
            num2 = Double.parseDouble(editTextOperation.getText().toString());
            switch (op) {
                case '+':
                    num1 += num2;
                    break;
                case '-':
                    num1 -= num2;
                    break;
                case '*':
                    num1 *= num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        editTextOperation.setText("Error");
                        num1 = Double.NaN;
                    } else {
                        num1 /= num2;
                    }
                    break;
            }
            
            op = '\0';
        }
    }
}