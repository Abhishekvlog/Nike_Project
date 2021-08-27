package HomeIcons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nike.HomePage;
import com.example.nike.R;

import java.util.ArrayList;

import RecyclerViews.Poster;
import RecyclerViews.PosterAdapter;

public class HomeIcon extends AppCompatActivity {
    private ArrayList<Poster> posterList = new ArrayList<>();
    private RecyclerView recyclerView4;
    private ImageView mTvHome;
    private ImageView mTvSearchBar;
    private ImageView mTvFavorite;
    private ImageView mTvIdentity;
    private ImageView mTvBag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_icon);
        mTvHome = findViewById(R.id.TvHome);
        mTvFavorite = findViewById(R.id.TvFavorites);
        mTvBag = findViewById(R.id.TvBag);
        mTvSearchBar = findViewById(R.id.TvSearchbar);
        mTvIdentity = findViewById(R.id.TvProfile);
        recyclerView4 = findViewById(R.id.recyclerView4);
        BuildRecyclerViewData();
        setRecyclerViewAdapter();
        mTvIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeIcon.this, ProfileIcon.class);
                startActivity(intent);
            }
        });
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeIcon.this, HomeIcon.class);
                startActivity(intent);
            }
        });
        mTvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeIcon.this,HomePage.class);
                startActivity(intent);
            }
        });
        mTvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeIcon.this, FavaritesIcon.class);
                startActivity(intent);
            }
        });
        mTvBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeIcon.this, BagIcon.class);
                startActivity(intent);
            }
        });
    }

    private void setRecyclerViewAdapter() {
        PosterAdapter posterAdapter = new PosterAdapter(posterList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView4 .setLayoutManager(linearLayoutManager);
        recyclerView4.setAdapter(posterAdapter);
    }

    private void BuildRecyclerViewData() {
        posterList = new ArrayList<>();
        posterList.add(new Poster(R.drawable.poster1));
        posterList.add(new Poster(R.drawable.poster2));
        posterList.add(new Poster(R.drawable.poster3));
        posterList.add(new Poster(R.drawable.poster4));
        posterList.add(new Poster(R.drawable.poster5));
        posterList.add(new Poster(R.drawable.poster6));
        posterList.add(new Poster(R.drawable.poster7));
        posterList.add(new Poster(R.drawable.poster8));
        posterList.add(new Poster(R.drawable.poster9));
        posterList.add(new Poster(R.drawable.poster10));
    }
}