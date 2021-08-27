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

import com.example.nike.R;

public class Question_1 extends AppCompatActivity {
    private TextView mTvTextView1;
    private TextView mTvTextView2;
    private TextView mTvTextView3;
    private TextView mTvTextView4;
    private TextView mTvTextView5;
    private TextView mTvTextView6;
    private Button mBtnNext;
    private View View1;
    private View View2;
    Animation topanim, bottomanim;
    private CheckBox TvCheck1Box;
    private CheckBox TvCheck2Box;
    private CheckBox TvCheck3Box;
    private CheckBox TvCheck4Box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        initViews();
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        mTvTextView1.setAnimation(topanim);
        mTvTextView2.setAnimation(topanim);
        mTvTextView3.setAnimation(topanim);
        TvCheck1Box.setAnimation(topanim);
        TvCheck2Box.setAnimation(topanim);
        View1.setAnimation(topanim);
        mTvTextView4.setAnimation(bottomanim);
        mTvTextView5.setAnimation(bottomanim);
        mTvTextView6.setAnimation(bottomanim);
        TvCheck3Box.setAnimation(bottomanim);
        TvCheck3Box.setAnimation(bottomanim);
        View2.setAnimation(bottomanim);
        mBtnNext.setAnimation(bottomanim);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Question_1.this , Question_2.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        mTvTextView1 = findViewById(R.id.textView11);
        mTvTextView2 = findViewById(R.id.textView6);
        mTvTextView3 = findViewById(R.id.textView7);
        mTvTextView4 = findViewById(R.id.textView8);
        mTvTextView5 = findViewById(R.id.textView9);
        mTvTextView6 = findViewById(R.id.textView10);
        View1 =findViewById(R.id.divider);
        View2 =findViewById(R.id.divider2);
        mBtnNext= findViewById(R.id.Next);
        TvCheck1Box = findViewById(R.id.check1box);
        TvCheck2Box = findViewById(R.id.check2box);
        TvCheck3Box = findViewById(R.id.check3box);
        TvCheck4Box = findViewById(R.id.check4box);
    }
}