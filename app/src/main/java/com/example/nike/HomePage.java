package com.example.nike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import HomeIcons.BagIcon;
import HomeIcons.FavaritesIcon;
import HomeIcons.HomeIcon;
import HomeIcons.ProfileIcon;
import RecyclerViews.ItemClickListener;
import RecyclerViews.ItemDetail;
import RecyclerViews.Shoe1;
import RecyclerViews.Shoe2;
import RecyclerViews.Shoe2Adapter;
import RecyclerViews.Shoe3;
import RecyclerViews.Shoe3Adapter;
import RecyclerViews.ShoeAdapter;

public class HomePage extends AppCompatActivity implements ItemClickListener {
  //  private ImageView mTvSearch;
    private ImageView mTvHome;
    private ImageView mTvSearchBar;
    private ImageView mTvFavorite;
    private ImageView mTvIdentity;
    private ImageView mTvBag;
    private Button mBtnViewAll;
    private Button mBtnfindstore;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private ArrayList<Shoe1> shoe1List = new ArrayList<>();
    private ArrayList<Shoe2> shoe2List = new ArrayList<>();
    private ArrayList<Shoe3> shoe3List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        Card_Item_Fragment card_item_fragment = new Card_Item_Fragment();
//        FragmentTransaction  fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.Relativelayout,card_item_fragment);
//        fragmentTransaction.commit();

       initViews();
       BuildRecyclerViewData();
       BuildRecyclerViewData2();
       BuildRecyclerViewData3();
       setRecyclerViewAdapter();
       setRecyclerViewAdapter2();
       setRecyclerViewAdapter3();
       mBtnViewAll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(HomePage.this,"Working in Progress",Toast.LENGTH_SHORT).show();
           }
       });


        mTvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,HomePage.class);
                startActivity(intent);
            }
        });
        mTvIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ProfileIcon.class);
                startActivity(intent);
            }
        });
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, HomeIcon.class);
                startActivity(intent);
            }
        });
        mTvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, FavaritesIcon.class);
                startActivity(intent);
            }
        });
        mTvBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, BagIcon.class);
                startActivity(intent);
            }
        });
        mBtnfindstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this,"Working in Progress",Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void setRecyclerViewAdapter3() {
        Shoe3Adapter shoe3Adapter = new Shoe3Adapter(shoe3List,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView3 .setLayoutManager(linearLayoutManager);
        recyclerView3.setAdapter(shoe3Adapter);

    }

    private void BuildRecyclerViewData3() {
        shoe3List = new ArrayList<>();
        shoe3List.add(new Shoe3(R.drawable.image14,"Basketball Highlight"));
        shoe3List.add(new Shoe3(R.drawable.image12,"Football Kits"));
        shoe3List.add(new Shoe3(R.drawable.image11,"Rawdacious Packs"));
        shoe3List.add(new Shoe3(R.drawable.image10,"Classic"));
        shoe3List.add(new Shoe3(R.drawable.image9,"Jordan"));
    }

    private void setRecyclerViewAdapter2() {
        Shoe2Adapter shoe2Adapter = new Shoe2Adapter(shoe2List,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView2 .setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(shoe2Adapter);

    }

    private void BuildRecyclerViewData2() {
        shoe2List = new ArrayList<>();
        shoe2List.add(new Shoe2(R.drawable.imge8,"Style Of The Week"));
        shoe2List.add(new Shoe2(R.drawable.image7,"Accessories"));
        shoe2List.add(new Shoe2(R.drawable.image6,"Choice by You"));
        shoe2List.add(new Shoe2(R.drawable.image5,"Run Run"));
        shoe2List.add(new Shoe2(R.drawable.image4,"Just Run"));
    }

    private void setRecyclerViewAdapter() {
        ShoeAdapter shoeAdapter = new ShoeAdapter(shoe1List , this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView1 .setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(shoeAdapter);

    }

    private void BuildRecyclerViewData() {
        shoe1List = new ArrayList<>();
        shoe1List.add(new Shoe1(R.drawable.image3,"Air Force 1 "));
        shoe1List.add(new Shoe1(R.drawable.image2,"Ghost Racer"));
        shoe1List.add(new Shoe1(R.drawable.image1,"Fearless"));
    }

    private void initViews() {
     //   mTvSearch = findViewById(R.id.TvSearch);
        mTvSearchBar = findViewById(R.id.TvSearchbar);
        mTvHome = findViewById(R.id.TvHome);
        mTvFavorite = findViewById(R.id.TvFavorites);
        mTvBag = findViewById(R.id.TvBag);
        mBtnViewAll = findViewById(R.id.BtnViewAll);
        mBtnfindstore = findViewById(R.id.findStore);
        mTvIdentity = findViewById(R.id.TvProfile);
        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView3 = findViewById(R.id.recyclerView3);
     }

    @Override
    public void onItemClicked(int position,Shoe1 shoe1) {
        Toast.makeText(HomePage.this ,shoe1.getmTvName()+""+position,Toast.LENGTH_SHORT).show();
        PreferenceHelper.writeIntToPreference(this,"imageid",shoe1.getmTvImage());
        PreferenceHelper.writeStringToPreference(this,"Nameid",shoe1.getmTvName());
        Intent intent = new Intent(HomePage.this, ItemDetail.class);
        startActivity(intent);
    }
}
