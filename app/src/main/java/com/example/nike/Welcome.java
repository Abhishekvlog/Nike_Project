package com.example.nike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import Questions.AskQuestions;
import RecyclerViews.UserHelper;

public class Welcome extends AppCompatActivity {
    private TextView mtvName;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myReference = firebaseDatabase.getReference("Users");
    private static  int SPLASH_SCREEN= 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mtvName = findViewById(R.id.tvName);

//        myReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("abhishek", snapshot.getValue().toString());
//                if(snapshot.exists()) {
//                    GenericTypeIndicator<UserHelper> genericTypeIndicator = new GenericTypeIndicator<UserHelper>() {
//                    };
//
//                    UserHelper user = snapshot.getValue(genericTypeIndicator);
//                    assert user != null;
//                    Log.d("abhishek", user.getFirst_Name().toString()+"");
//                    mtvName.setText(user.getFirst_Name().toString());
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.d("abhishek", error.getMessage().toString());
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