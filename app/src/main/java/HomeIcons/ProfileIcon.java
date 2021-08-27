package HomeIcons;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.nike.EditPage;
import com.example.nike.HomePage;
import com.example.nike.R;
import RecyclerViews.UserHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class ProfileIcon extends AppCompatActivity {
    private TextView TvUserName;
    FirebaseAuth fAuth;
    private Button mBtnEditProfile;
    FirebaseDatabase rootNode;
    private ImageView mTvprofileUpload;
    private ImageView mTvHome;
    private ImageView mTvFavorite;
    private ImageView mTvIdentity;
    private ImageView mTvBag;
    private ImageView mTvSearchBar;


    private String imageUrl = null;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("Users");

    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageReference = storage.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_icon);
        mTvHome = findViewById(R.id.TvHome);
        mTvFavorite = findViewById(R.id.TvFavorites);
        mTvSearchBar = findViewById(R.id.TvSearchbar);
        mTvBag = findViewById(R.id.TvBag);
        mTvIdentity = findViewById(R.id.TvProfile);
        TvUserName = findViewById(R.id.username);
        mBtnEditProfile = findViewById(R.id.btnedittext);
        mTvprofileUpload = findViewById(R.id.profileUpload);
        mTvprofileUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();


            }
        });

        mBtnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this, EditPage.class);
                startActivity(intent);
            }
        });
//        myReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                GenericTypeIndicator<UserHelper> genericTypeIndicator = new GenericTypeIndicator<UserHelper>() {
//                };
//                UserHelper user2 = snapshot.getValue(genericTypeIndicator);
//                TvUserName.setText(user2.getFirst_Name()+" "+user2.getLast_Name());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        if (mAuth.getCurrentUser()!=null){
            GenericTypeIndicator<UserHelper> genericTypeIndicator = new GenericTypeIndicator<UserHelper>() {
            };
            reference.child(mAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserHelper userHelper = snapshot.getValue(genericTypeIndicator);
                    TvUserName.setText(userHelper.getFirst_Name()+" "+userHelper.getLast_Name());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            if (imageUrl != null){
                UserHelper userHelper = new UserHelper(imageUrl,1);
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");
                reference.setValue(userHelper).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(ProfileIcon.this , ProfileIcon.class);
                        startActivity(intent);
                    }
                });

//                reference.child(mAuth.getCurrentUser().getUid())
//                        .setValue(userHelper)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                Intent intent = new Intent(ProfileIcon.this,ProfileIcon.class);
//                                startActivity(intent);
//                            }
//                        });
            }
        }
        mTvIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this, ProfileIcon.class);
                startActivity(intent);
            }
        });
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this, HomeIcon.class);
                startActivity(intent);
            }
        });
        mTvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this,HomePage.class);
                startActivity(intent);
            }
        });
        mTvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this, FavaritesIcon.class);
                startActivity(intent);
            }
        });
        mTvBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileIcon.this, BagIcon.class);
                startActivity(intent);
            }
        });

    }

    private void SelectImage() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        startActivityForResult(chooserIntent, 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            Uri uri = data.getData();
            mTvprofileUpload.setImageURI(uri);
            upload();
            Intent intent = new Intent(ProfileIcon.this, ProfileIcon.class);
            startActivity(intent);
        }
    }

    private void upload() {
        Bitmap bitmap = ((BitmapDrawable) mTvprofileUpload.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        storageReference.child(Math.random()+".jpg").putBytes(data).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                task.getResult().getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {

                        if (task.isComplete()){
                            imageUrl = task.getResult().toString();

                        }
                    }
                });
            }
        });
    }
}