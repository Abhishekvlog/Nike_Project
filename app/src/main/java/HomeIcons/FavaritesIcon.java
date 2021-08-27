package HomeIcons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nike.HomePage;
import com.example.nike.R;

public class FavaritesIcon extends AppCompatActivity {
    private Button mBtnfavShopNow;
    private TextView mTvnameOfItemInFavarites;
    private ImageView mTvHome;
    private ImageView mTvFavorite;
    private ImageView mTvIdentity;
    private ImageView mTvBag;
    private ImageView mTvSearchBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favarites_icon);
        mTvHome = findViewById(R.id.TvHome);
        mTvFavorite = findViewById(R.id.TvFavorites);
        mTvSearchBar = findViewById(R.id.TvSearchbar);
        mTvBag = findViewById(R.id.TvBag);
        mTvIdentity = findViewById(R.id.TvProfile);
        mBtnfavShopNow = findViewById(R.id.favShopNow);
        mTvnameOfItemInFavarites = findViewById(R.id.nameofiteminfav);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyLocalDataBase", Context.MODE_PRIVATE);
        String Name = sp.getString("Name","");
        mTvnameOfItemInFavarites.setText(Name);

        mBtnfavShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this , HomePage.class);
                startActivity(intent);

            }
        });
        mTvIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this, ProfileIcon.class);
                startActivity(intent);
            }
        });
        mTvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this,HomePage.class);
                startActivity(intent);
            }
        });
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this, HomeIcon.class);
                startActivity(intent);
            }
        });
        mTvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this, FavaritesIcon.class);
                startActivity(intent);
            }
        });
        mTvBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavaritesIcon.this, BagIcon.class);
                startActivity(intent);
            }
        });

    }
}