package com.revolutiontech.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

public class CalcActivity extends Activity {

    TextView resultsView;

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);
        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);

        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);
        ImageButton subtractBtn = (ImageButton) findViewById(R.id.subtractBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);

        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        resultsView = (TextView) findViewById(R.id.resultsText);

        resultsView.setText("");

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNumber = "";
                leftValueStr = "";
                rightValueStr = "";
                currentOperation = null;
                result = 0;
                resultsView.setText("0");
            }
        });
    }

    void processOperation(Operation operation) {
        if (currentOperation == null) {
            leftValueStr = runningNumber;
            runningNumber = "";
        } else {
            if (runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                resultsView.setText(leftValueStr);
            }
        }
        currentOperation = operation;
    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);
    }
}
