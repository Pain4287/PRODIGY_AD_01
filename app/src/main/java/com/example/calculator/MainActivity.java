package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double operand1, operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.EditText);
        int[] UIbuttons = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4
                , R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.buttonDecimal};

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                currentInput += button.getText().toString();
                display.setText(currentInput);
            }

        };
        for (int id : UIbuttons) {
            findViewById(id).setOnClickListener(numberListener);
        }
        int[] Buttonid = {R.id.buttonDivide, R.id.buttonMultiply,R.id.buttonSubtract,R.id.buttonAdd
        };

        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (!currentInput.isEmpty()) {
                    operator = button.getText().toString();
                    operand1 = Double.parseDouble(currentInput);
                    currentInput = "";
                    display.setText("");

                }
            }
        };
        for (int id :Buttonid){
            findViewById(id).setOnClickListener(operatorListener);
        }

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                 operand2 = Double.parseDouble(currentInput);
                 double result = 0.0;
                 switch(operator){
                     case "+":
                         result =operand1+operand2;
                         break;
                     case "-":
                         result = operand1-operand2;
                         break;
                     case "*":
                         result = operand1*operand2;
                         break;
                     case "/":
                         if(operand2==0){
                         result = operand1/operand2;}
                         else{
                             display.setText("Error");
                             return;
                         }
                         break;
                 }
                 display.setText(String.valueOf(result));
                 currentInput = String.valueOf(result);
                }
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             currentInput ="";
             operator ="";
             operand1 = operand2 =0.0;
             display.setText("");
            }
        });
    }
}