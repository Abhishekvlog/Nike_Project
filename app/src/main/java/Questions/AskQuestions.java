package Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.nike.R;

public class AskQuestions extends AppCompatActivity {
    private Button mbtnGetStarted;
    private VideoView videoview;
    Animation topanim, bottomanim;
    private TextView mtvtextQues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_questions);
        mbtnGetStarted = findViewById(R.id.btnGetStarted);
        mtvtextQues= findViewById(R.id.tvtextques);
        videoview = findViewById(R.id.TvVideoView);
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash_2);

        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoview.start();

        mtvtextQues.setAnimation(topanim);
        mbtnGetStarted.setAnimation(bottomanim);
        mbtnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskQuestions.this , Question_1.class);
                startActivity(intent);
            }
        });

    }
}