package com.eathindhar.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{

        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if(squareRoot==Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangular(){
            int x = 1;
            int triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber==number){
                return true;
            }else{
                return false;
            }
        }
    }

    public void checkNumber(View view) {

        EditText num = (EditText) findViewById(R.id.editText);
        TextView text = (TextView) findViewById(R.id.outputTextView);
        Log.i("info", "Button Clicked!");
        Number myNumber = new Number();
        String msg;
        if (num.getText().toString().isEmpty()) {
            msg = "Enter a Number!";
            text.setText(msg);
        } else {
            myNumber.number = Integer.parseInt(num.getText().toString());
            msg = num.getText().toString();
            if (myNumber.isSquare() && myNumber.isTriangular()) {
                text.setText(msg + " = Triangular & Square");
                msg += " = Triangular & Square";
            } else if (myNumber.isSquare()) {
                text.setText(msg + " = Square Number");
                msg += " = Square Number";
            } else if (myNumber.isTriangular()) {
                text.setText(msg + " = Triangular Number");
                msg += " = Triangular Number";
            } else {
                text.setText(msg + " = Neither Triangular nor Square");
                msg += " = Neither Triangular nor Square";
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
