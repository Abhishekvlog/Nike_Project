package SignAndLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nike.HomePage;
import com.example.nike.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private EditText mtvEnterEmail;
    private EditText mtvEnterPassword;
    private Button mBtnLogin;
    String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("Users");
    private ProgressDialog progressDialog;
    private FirebaseUser mUser;
    private TextView mTvGoToSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformLogin();

            }
        });
        mTvGoToSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SigIn.class);
                startActivity(intent);
            }
        });
    }

    private void PerformLogin() {
        String Email = mtvEnterEmail.getText().toString();
        String Password = mtvEnterPassword.getText().toString();
        if (!Email.matches(emailValidation))
            mtvEnterEmail.setError("Invalid Email Id");
        else if (!Password.matches(emailValidation) && Password.length() < 8)
            mtvEnterPassword.setError("Password length must be greater than 8 ");
        else {
            progressDialog.setMessage("Please wait...");
            progressDialog.setTitle("Login");
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(Login.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        login();
                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void login() {
       Intent intent = new Intent(Login.this, HomePage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initView() {
        mtvEnterEmail = findViewById(R.id.EnterEmail);
        mtvEnterPassword = findViewById(R.id.EnterPassword);
        mBtnLogin = findViewById(R.id.Login);
        mTvGoToSign = findViewById(R.id.GoToSign);
    }
}