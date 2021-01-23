package com.share.graphical_password;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Numerical_password extends AppCompatActivity implements View.OnClickListener{

    public int counter;
    Button timer;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button submit;
    ArrayList<String> value;
    TextView textView;
    TextView input;
    public String fixedValue;
    public int input_count;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_password);
        counter = 60;
        fixedValue = "123456";
        input_count = 0;
        value = new ArrayList<String>();
        timer= (Button) findViewById(R.id.timer);
        textView= (TextView) findViewById(R.id.time);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        input = findViewById(R.id.input);
        submit = findViewById(R.id.submit);
        count = findViewById(R.id.count);








        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                for(String s : value) {
                    builder.append(s);
                }
                String str = builder.toString();
                if(str.equals(fixedValue))
                {
                   input_count = input_count+1;

                }

                count.setText(String.valueOf(input_count));
                input.setText("");
                value.clear();

            }





        });

        timer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                submit.setVisibility(View.VISIBLE);
                new CountDownTimer(60000, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText(String.valueOf(counter));
                        counter--;
                    }
                    public  void onFinish(){
                        textView.setText("FINISH!!");
                        submit.setVisibility(View.INVISIBLE);
                        counter = 60;
                    }
                }.start();
            }
        });

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                input.setText(input.getText()+"1");
                value.add("1");
                break;
            case R.id.two:
                input.setText(input.getText()+"2");
                value.add("2");

                break;
            case R.id.three:
                input.setText(input.getText()+"3");
                value.add("3");
                break;
            case R.id.four:
                input.setText(input.getText()+"4");
                value.add("4");
                break;
            case R.id.five:
                input.setText(input.getText()+"5");
                value.add("5");
                break;
            case R.id.six:
                input.setText(input.getText()+"6");
                value.add("6");
                break;
            default:
                break;
        }
    }

}
