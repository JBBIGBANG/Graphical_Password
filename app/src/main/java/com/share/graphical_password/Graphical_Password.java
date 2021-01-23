package com.share.graphical_password;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Graphical_Password extends AppCompatActivity implements View.OnClickListener {
    public int counter;
    Button submit;
    ArrayList<String> value;
    TextView textView;
    TextView input;
    public String fixedValue;
    public int input_count;
    TextView count;
    Button timer;
    ImageView flower1;
    ImageView flower2;
    ImageView flower3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphical__password);
        counter = 60;
        fixedValue = "123456";
        input_count = 0;
        value = new ArrayList<String>();
        timer = (Button) findViewById(R.id.timer);
        textView = (TextView) findViewById(R.id.time);
        input = findViewById(R.id.input);
        submit = findViewById(R.id.submit);
        count = findViewById(R.id.count);
        flower1 = findViewById(R.id.flower);
        flower2 = findViewById(R.id.flo2);
        flower3 = findViewById(R.id.flo3);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                for (String s : value) {
                    builder.append(s);
                }
                String str = builder.toString();
                if (str.equals(fixedValue)) {
                    input_count = input_count + 1;

                }

                count.setText(String.valueOf(input_count));
                input.setText("");
                value.clear();

            }


        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit.setVisibility(View.VISIBLE);
                new CountDownTimer(60000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textView.setText(String.valueOf(counter));
                        counter--;
                    }

                    public void onFinish() {
                        textView.setText("FINISH!!");
                        submit.setVisibility(View.INVISIBLE);
                        counter = 60;
                    }
                }.start();
            }
        });
        flower1.setOnClickListener(this);
        flower2.setOnClickListener(this);
        flower3.setOnClickListener(this);
    }


        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.flower:
                    input.setText(input.getText() + "12");
                    value.add("12");
                    break;
                case R.id.flo2:
                    input.setText(input.getText() + "34");
                    value.add("34");
                    break;
                case R.id.flo3:
                    input.setText(input.getText() + "56");
                    value.add("56");
                    break;
                default:
                    break;
            }
        }
    }

