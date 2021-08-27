package com.example.nike;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import HomeIcons.HomeIcon;
import HomeIcons.ProfileIcon;

public class EditPage extends AppCompatActivity {
    private ImageView EditBackBtn;
    private Button EditSaveBtn;
    private ImageView EditProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);
        EditBackBtn = findViewById(R.id.editback);
        EditSaveBtn = findViewById(R.id.editSave);
        EditProfileImage = findViewById(R.id.editphoto);

        EditSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditPage.this, "Data has been Saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditPage.this, ProfileIcon.class);
                startActivity(intent);
            }
        });

        EditBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditPage.this, ProfileIcon.class);
                startActivity(intent);
            }
        });

    }
}