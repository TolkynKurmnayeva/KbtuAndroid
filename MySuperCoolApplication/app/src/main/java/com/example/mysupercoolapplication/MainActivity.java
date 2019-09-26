package com.example.mysupercoolapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    private EditText inputNumber;
    private Button buttonNumber1;
    private Button buttonNumber2;
    private Button buttonNumber3;
    private Button buttonNumber4;
    private Button buttonNumber5;
    private Button buttonNumber6;
    private Button buttonNumber7;
    private Button buttonNumber8;
    private Button buttonNumber9;
    private Button buttonNumber0;
    private Button buttonDot;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEquals;
    private Button buttonAC;
    private Button buttonDelete;
    private boolean actionclicked=false;
    private Button buttonPercent;
    private double number1;
    private double number2;
    private double result;
    private String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.numberInput);

        buttonNumber1 = findViewById(R.id.buttonNumber1);
        buttonNumber2 = findViewById(R.id.buttonNumber2);
        buttonNumber3 = findViewById(R.id.buttonNumber3);
        buttonNumber4 = findViewById(R.id.buttonNumber4);
        buttonNumber5 = findViewById(R.id.buttonNumber5);
        buttonNumber6 = findViewById(R.id.buttonNumber6);
        buttonNumber7 = findViewById(R.id.buttonNumber7);
        buttonNumber8 = findViewById(R.id.buttonNumber8);
        buttonNumber9 = findViewById(R.id.buttonNumber9);
        buttonNumber0 = findViewById(R.id.buttonNumber0);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonAC = findViewById(R.id.buttonAC);
        buttonDelete = findViewById(R.id.buttonDelete);

        setNumberInput(buttonNumber1);
        setNumberInput(buttonNumber2);
        setNumberInput(buttonNumber3);
        setNumberInput(buttonNumber4);
        setNumberInput(buttonNumber5);
        setNumberInput(buttonNumber6);
        setNumberInput(buttonNumber7);
        setNumberInput(buttonNumber8);
        setNumberInput(buttonNumber9);
        setNumberInput(buttonNumber0);
        setActionButton(buttonPlus);
        setActionButton(buttonMinus);
        setActionButton(buttonMultiply);
        setActionButton(buttonDivide);

        buttonEquals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                if (!inputNumber.getText().toString().equals(""))
                    number2=Double.parseDouble(inputNumber.getText().toString());
                if (action.equals("+")){
                    result=number1+number2;
                }
                if (action.equals("-")){
                    result=number1-number2;
                }
                if (action.equals("*")){
                    result=number1*number2;
                }
                if (action.equals("/")){
                    result=number1/number2;
                    if (number2==0) {
                        action = "";
                        number1 = 0;
                        number2 = 0;
                        result = 0;
                    }
                }

                number1 = 0;
                number2 = 0;
                inputNumber.setText((new Double(result)).toString());
                if((new Double(result)).intValue()==result){
                    inputNumber.setText((new Integer((new Double(result)).intValue())).toString());

                }
                actionclicked=false;
            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                inputNumber.setText("");
                action="";
                number1=0;
                number2=0;
                result=0;
                actionclicked=false;
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                if (!inputNumber.getText().toString().equals("")){
                    if (number1==0 && result!=0) {
//                        inputNumber.setText("");
                        action="";
                        number1=0;
                        number2=0;
                        result=0;
                    }
                    else
                        inputNumber.getText().delete(inputNumber.getText().length()-1,inputNumber.getText().length());}
                actionclicked=false;
            }

        });
        buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                if (inputNumber.getText().toString().equals(""))
                    inputNumber.setText("0.");
                else {
                    boolean contains=false;
                    for (int i = 0; i < inputNumber.length(); i++) {
                        if (inputNumber.getText().charAt(i) == '.')
                            contains = true;
                    }
                    if (!contains){
                        inputNumber.append(".");
                    }
                }
                actionclicked=false;

            }
        });

    }

    public void setNumberInput (final Button numberButton){
        numberButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                if (number1==0 && result!=0) {
                    inputNumber.setText("");
                    number1=result;

                }
                inputNumber.append(numberButton.getText());
                actionclicked=false;
            }
        });
    }

    public void setActionButton (final Button actionButton){
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!actionclicked) {
                    if (number1 != 0) {
                        if (!inputNumber.getText().toString().equals(""))
                            number2 = Double.parseDouble(inputNumber.getText().toString());
                        if (action.equals("+")) {
                            result = number1 + number2;
                        }
                        if (action.equals("-")) {
                            result = number1 - number2;
                        }
                        if (action.equals("*")) {
                            result = number1 * number2;
                        }
                        if (action.equals("/")) {
                            result = number1 / number2;
                        }
                        inputNumber.setText((new Double(result)).toString());
                        if ((new Double(result)).intValue() == result) {
                            inputNumber.setText((new Integer((new Double(result)).intValue())).toString());

                        }
                        number1 = 0;
                        number2 = 0;
                    } else {
                        number1 = Double.parseDouble(inputNumber.getText().toString());
                        inputNumber.setText("");
                    }
                }
                actionclicked=true;
                action=actionButton.getText().toString();

            }
        });
    }




}
