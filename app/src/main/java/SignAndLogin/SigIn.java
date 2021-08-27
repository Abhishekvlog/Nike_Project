package SignAndLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nike.R;
import RecyclerViews.UserHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SigIn extends AppCompatActivity {
    private Button mbtnNext;
    private EditText metEmail;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myReference = firebaseDatabase.getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);
        initViews();



        mbtnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Email = metEmail.getText().toString().trim();
                if (Email.matches(emailPattern)){
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Users");
                    UserHelper userHelper = new UserHelper(Email);
                    reference.setValue(userHelper);
                    Intent intent = new Intent(SigIn.this , AccountsDetails.class);
                    startActivity(intent);

//                    UserHelper userHelper = new UserHelper(Email);
//                    myReference.child(mAuth.getCurrentUser().getUid())
//                            .setValue(userHelper)
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    Intent intent = new Intent(SigIn.this , AccountsDetails.class);
//                                    startActivity(intent);
//                                }
//                            });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }


    private void initViews() {
        mbtnNext = findViewById(R.id.btnnext);
        metEmail = findViewById(R.id.etEmail);
    }

}