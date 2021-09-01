package SignAndLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nike.R;
import RecyclerViews.UserHelper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SigIn extends AppCompatActivity {
    private Button mbtnNext;
    private EditText metEmail;
    private EditText mEtPassword;
    private EditText mEtConfirmPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);
        initViews();


        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = metEmail.getText().toString();

                if (Email.matches(emailPattern)){

                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Users");
                    UserHelper userHelper = new UserHelper(Email);
                    reference.setValue(userHelper).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Log.d("abhishek", task.toString());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("abhishek", e.getMessage().toString());
                        }
                    });
                    Intent intent = new Intent(SigIn.this , AccountsDetails.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();

                }
//                if (Vaildate()) {
//
//                    firebaseAuth.createUserWithEmailAndPassword(metEmail.getText().toString(), mEtPassword.getText().toString())
//                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        UserHelper userHelper = new UserHelper(metEmail.getText().toString(),
//                                                mEtPassword.getText().toString());
//                                        myRef.child(firebaseAuth.getCurrentUser().getUid())
//                                                .setValue(userHelper)
//                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<Void> task) {
//                                                        Intent intent = new Intent(SigIn.this, AccountsDetails.class);
//                                                        startActivity(intent);
//                                                    }
//                                                });
//                                    }
//                                }
//                            });
//                } else {
//                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
//
//                }
            }
        });


    }

//    private boolean Vaildate() {
//        boolean isvalid = true;
//        if (!metEmail.getText().toString().trim().matches(emailPattern)){
//            metEmail.setError("Invalid Email");
//            isvalid = false;
//        }
//        if ( mEtPassword.getText().toString().length()<8){
//            mEtPassword.setError("Password must be greater than 8 Characters ");
//            isvalid = false;
//        }
//        return isvalid;
//    }


    private void initViews() {
        mbtnNext = findViewById(R.id.btnnext);
        metEmail = findViewById(R.id.etEmail);
//        mEtPassword = findViewById(R.id.etPassword);
//        mEtConfirmPassword = findViewById(R.id.etConfirmPassword);
    }

}