package com.share.graphical_password;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button numerical;
    private Button graphical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numerical = findViewById(R.id.numeric);
        graphical = findViewById(R.id.grapical);

        numerical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumerical_password();
            }
        });

        graphical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGraphical_Password();
            }
        });
    }

    private void openGraphical_Password() {

        Intent intent = new Intent(this,Graphical_Password.class);
        intent.putExtra("graphical","invisible");
        startActivity(intent);
    }


    private void openNumerical_password() {

        Intent intent=new Intent(this,Numerical_password.class);
        intent.putExtra("numerical" , "invisible");
        startActivity(intent);
    }
}

