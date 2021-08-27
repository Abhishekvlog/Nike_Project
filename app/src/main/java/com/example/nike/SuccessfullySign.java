package com.example.nike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessfullySign extends AppCompatActivity {
    private Button mbtnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucessfull_sign);
        mbtnContinue = findViewById(R.id.btncontinue);
        mbtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessfullySign.this, Welcome.class);
                startActivity(intent);
            }
        });

    }
}