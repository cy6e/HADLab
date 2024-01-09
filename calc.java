<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:background="@color/white">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="CALCULATOR"
        android:textSize="30dp"
        android:textColor="@color/black"
        android:gravity="center"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="0"
        android:textSize="30dp"
        android:textColor="@color/black"
        android:id="@+id/res"
        android:gravity="end"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginBottom="20dp">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="9"
            android:id="@+id/nine"
            android:layout_weight="0.25"
            android:textSize="20dp"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="8"
            android:id="@+id/eight"
            android:textSize="20dp"
            android:layout_weight="0.25"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20dp"
            android:text="7"
            android:id="@+id/seven"
            android:layout_weight="0.25"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="C"
            android:textSize="20dp"
            android:id="@+id/clear"
            android:layout_weight="0.25"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginBottom="20dp">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="6"
            android:textSize="20dp"
            android:id="@+id/six"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="5"
            android:textSize="20dp"
            android:id="@+id/five"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="4"
            android:textSize="20dp"
            android:id="@+id/four"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="+"
            android:textSize="20dp"
            android:id="@+id/add"
            android:layout_weight="0.25"
            />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginBottom="20dp">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="3"
            android:textSize="20dp"
            android:id="@+id/three"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="2"
            android:textSize="20dp"
            android:id="@+id/two"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="1"
            android:textSize="20dp"
            android:id="@+id/one"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="-"
            android:textSize="20dp"
            android:id="@+id/sub"
            android:layout_weight="0.25" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginBottom="20dp">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="0.25"
            android:text="/"
            android:textSize="20dp"
            android:id="@+id/div" />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0"
            android:textSize="20dp"
            android:id="@+id/zero"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="*"
            android:textSize="20dp"
            android:id="@+id/mul"
            android:layout_weight="0.25"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="="
            android:textSize="20dp"
            android:id="@+id/equals"
            android:layout_weight="0.25"
            />
    </LinearLayout>
</LinearLayout>





package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine;
    Button add, sub, div, mul, clear, equals;
    EditText res;
    String operatorPressed = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.res); //EditText
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        clear = findViewById(R.id.clear);
        sub = findViewById(R.id.sub);
        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        equals = findViewById(R.id.equals);
//
//        one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
// operators
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equals.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double finalResult = 0.0;
//
        if (view.getId() == R.id.one) {
            res.append("1");
        } else if (view.getId() == R.id.two) {
            res.append("2");
        } else if (view.getId() == R.id.three) {
            res.append("3");
        } else if (view.getId() == R.id.four) {
            res.append("4");
        } else if (view.getId() == R.id.five) {
            res.append("5");
        } else if (view.getId() == R.id.six) {
            res.append("6");
        } else if (view.getId() == R.id.seven) {
            res.append("7");
        } else if (view.getId() == R.id.eight) {
            res.append("8");
        } else if (view.getId() == R.id.nine) {
            res.append("9");
        } else if (view.getId() == R.id.add) {
            res.append("+");
            operatorPressed = "+";
        } else if (view.getId() == R.id.sub) {
            res.append("-");
            operatorPressed = "-";
        } else if (view.getId() == R.id.mul) {
            res.append("*");
            operatorPressed = "*";
        } else if (view.getId() == R.id.div) {
            res.append("/");
            operatorPressed = "/";
        } else if (view.getId() == R.id.clear) {
            res.setText(" ");
        } else if (view.getId() == R.id.equals) {
            finalResult = evaluateExpression(res.getText().toString(), operatorPressed);
            res.setText(String.valueOf(finalResult));
        } else {
            return;
        }

    }

    private double evaluateExpression(String res, String operatorPressed) {
        String[] tokens=res.split("\\+|-|\\*|\\/");

        double firstOperand = Double.parseDouble(tokens[0]);
        double secondOperand = Double.parseDouble(tokens[1]);
        switch(operatorPressed) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }
}
