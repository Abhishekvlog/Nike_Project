package RecyclerViews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nike.PreferenceHelper;
import com.example.nike.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ItemDetail extends AppCompatActivity {
    private Button mBtnAddToBag;
    private Button mBtnFavorite;
    private TextView TvName1;
    private TextView TvName2;
    private TextView TvDetails;
    private ImageView TvImage;
    private String nameofitem;
    private String imageofanItem;
    private SharedPreferences sp;
    private OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        initViews();

        int imageId = PreferenceHelper.getIntFromPreference(ItemDetail.this, "imageid");
        String Name = PreferenceHelper.getStringFromPreference(ItemDetail.this, "Nameid");

        TvImage.setImageResource(imageId);
        TvName1.setText(Name);
        TvName2.setText(Name);
        sp = getSharedPreferences("MyLocalDataBase", Context.MODE_PRIVATE);


        mBtnAddToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameofitem = TvName1.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Name",nameofitem);
                editor.commit();
                imageofanItem = sp.getString("ImageOfItem",null);
//
//                if (imageofanItem != null){
//                    try {
//                        Bitmap bm = BitmapFactory.decodeFile("/data/misc/imageofitem"+imageofanItem);
//                        setWallpaper(bm);
//
//                    }catch (IOException e){
//
//                    }
//                }

                Toast.makeText(ItemDetail.this, "Added to card", Toast.LENGTH_SHORT).show();

            }
        });
        mBtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemDetail.this, "Added to Favorite", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initViews() {
        mBtnAddToBag=findViewById(R.id.btnAddToBag);
        mBtnFavorite=findViewById(R.id.BtnFavorite);
        TvDetails = findViewById(R.id.detailofanitem);
        TvName1 = findViewById(R.id.nameofitem);
        TvName2 = findViewById(R.id.nameofitem2);
        TvImage = findViewById(R.id.imageofitem);
    }
}