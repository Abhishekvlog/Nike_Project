package SignAndLogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nike.DatePickerFragment;
import com.example.nike.R;
import com.example.nike.SuccessfullySign;
import RecyclerViews.UserHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class AccountsDetails extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText metFirstName;
    private EditText metLastName;
    private EditText metpassword;
    private EditText metDateofbirth;
    private ImageView mivHide;
    private ImageView mivCalender;
    private Button mbtnCreateAccount;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_details);
        initViews();
        metDateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        mbtnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Password = metpassword.getText().toString().trim();
                if (TextUtils.isEmpty(Password)){
                    metpassword.setError("Password is Required");
                    return;
                }if (!Password.matches("\\A\\w{4,20}\\z")){
                    metpassword.setError("White Spaces are not allowed! ");
                }

                if (Password.length() < 8){
                    metpassword.setError("Password must be more than 8 characters");
                    return;
                }
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User");
                String FirstName = metFirstName.getText().toString().trim();
                String LastName = metLastName.getText().toString().trim();
                String Pass = metpassword.getText().toString().trim();
                UserHelper helper = new UserHelper(FirstName,LastName,Pass);
                reference.setValue(helper);
                    Intent intent = new Intent(AccountsDetails.this, SuccessfullySign.class);
                    startActivity(intent);

            }
        });



    }

    private void initViews() {
        metFirstName = findViewById(R.id.etfirstname);
        metLastName = findViewById(R.id.etlastname);
        metpassword = findViewById(R.id.etpassword);
        metDateofbirth = findViewById(R.id.etDob);
        mivHide = findViewById(R.id.tvhide);
        mivCalender = findViewById(R.id.tvcalender);
        mbtnCreateAccount = findViewById(R.id.btncreataccount);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String CurrentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.etDob);
        textView.setText(CurrentDateString);
    }
}
