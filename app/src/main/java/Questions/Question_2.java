package Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nike.Congrats;
import com.example.nike.R;

public class Question_2 extends AppCompatActivity {
    private TextView mTvText;
    private TextView mTvText1;
    private TextView mTvText2;
    private TextView mTvText3;
    private TextView mTvText4;
    private TextView mTvText5;
    private TextView mTvText6;
    private TextView mTvText7;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private Button mBtnnext;
    Animation topanim, bottomanim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        initViews();
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        mTvText.setAnimation(topanim);
        mTvText1.setAnimation(bottomanim);
        mTvText2.setAnimation(bottomanim);
        mTvText3.setAnimation(bottomanim);
        mTvText4.setAnimation(bottomanim);
        mTvText5.setAnimation(bottomanim);
        mTvText6.setAnimation(bottomanim);
        mTvText7.setAnimation(bottomanim);
        checkBox1.setAnimation(bottomanim);
        checkBox2.setAnimation(bottomanim);
        checkBox3.setAnimation(bottomanim);
        checkBox4.setAnimation(bottomanim);
        checkBox5.setAnimation(bottomanim);
        checkBox6.setAnimation(bottomanim);
        checkBox7.setAnimation(bottomanim);
        mBtnnext.setAnimation(bottomanim);
        mBtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question_2.this, Congrats.class);
                startActivity(intent);
            }
        });


    }

    private void initViews() {
        mTvText =findViewById(R.id.textView12);
        mTvText1 =findViewById(R.id.textView13);
        mTvText2 =findViewById(R.id.textView14);
        mTvText3 =findViewById(R.id.textView15);
        mTvText4 =findViewById(R.id.textView16);
        mTvText5 =findViewById(R.id.textView17);
        mTvText6 =findViewById(R.id.textView18);
        mTvText7 =findViewById(R.id.textView19);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        checkBox5 = findViewById(R.id.checkbox5);
        checkBox6 = findViewById(R.id.checkbox6);
        checkBox7 = findViewById(R.id.checkbox7);
        mBtnnext= findViewById(R.id.next);
    }
}