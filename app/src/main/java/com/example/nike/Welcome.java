package com.example.nike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Questions.AskQuestions;

public class Welcome extends AppCompatActivity {
    private TextView mtvName;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myReference = firebaseDatabase.getReference("Users");
    private static  int SPLASH_SCREEN= 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        myReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                GenericTypeIndicator<UserHelper> genericTypeIndicator = new GenericTypeIndicator<UserHelper>() {
//                };
//                UserHelper user1 = snapshot.getValue(genericTypeIndicator);
//                mtvName.setText(user1.getFirst_Name());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, AskQuestions.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);




    }
}