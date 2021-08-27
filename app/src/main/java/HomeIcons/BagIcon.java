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

import java.util.ArrayList;

import RecyclerViews.Shoe1;

public class BagIcon extends AppCompatActivity {
    private TextView mTvCardItemName;
    private Button mBtnShopNow;
    private ImageView mTvHome;
    private ImageView mTvFavorite;
    private ImageView mTvIdentity;
    private ImageView mTvSearchBar;
    private ImageView mTvBag;

    private ImageView mTvCardItemImage;
  //  ArrayList<Shoe1> shoe1List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag_icon);
        mTvHome = findViewById(R.id.TvHome);
        mTvFavorite = findViewById(R.id.TvFavorites);
        mTvBag = findViewById(R.id.TvBag);
        mTvIdentity = findViewById(R.id.TvProfile);
        mBtnShopNow= findViewById(R.id.BagShopNow);
        mTvSearchBar = findViewById(R.id.TvSearchbar);




        //  mTvCardItemImage = findViewById(R.id.carditemimage);
        mTvCardItemName = findViewById(R.id.carditemname);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyLocalDataBase", Context.MODE_PRIVATE);
        String Name = sp.getString("Name","");
   //     int Image = sp.getInt("image",1);

        mTvCardItemName.setText(Name);

        mBtnShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this, HomePage.class);
                startActivity(intent);
            }
        });
        mTvIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this, ProfileIcon.class);
                startActivity(intent);
            }
        });
        mTvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this,HomePage.class);
                startActivity(intent);
            }
        });
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this, HomeIcon.class);
                startActivity(intent);
            }
        });
        mTvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this, FavaritesIcon.class);
                startActivity(intent);
            }
        });
        mTvBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BagIcon.this, BagIcon.class);
                startActivity(intent);
            }
        });

//        mTvCardItemImage.setImageURI(Image);
    }
}