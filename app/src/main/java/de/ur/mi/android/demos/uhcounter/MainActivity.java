package de.ur.mi.android.demos.uhcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterOutput;
    private int uhCounterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        resetCounterValue();
    }

    private void initUI() {
        Button increaseCounterButton = findViewById(R.id.increaseCounterButton);
        Button decreaseCounterButton = findViewById(R.id.decreaseCounterButton);
        Button resetCounterButton = findViewById(R.id.resetCounterButton);
        counterOutput = findViewById(R.id.counterOutput);
        increaseCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseCounterValue();
            }
        });
        decreaseCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseCounterValue();
            }
        });
        resetCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounterValue();
            }
        });
    }

    private void increaseCounterValue() {
        uhCounterValue++;
        updateCounterView();
    }

    private void decreaseCounterValue() {
        if(uhCounterValue > 0) {
            uhCounterValue--;
            updateCounterView();
        }
    }

    private void resetCounterValue() {
        uhCounterValue = 0;
        updateCounterView();
    }

    private void updateCounterView() {
        counterOutput.setText(String.valueOf(uhCounterValue));
    }
}