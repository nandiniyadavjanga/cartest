package com.example.carbhejdo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class CarInfoActivity extends AppCompatActivity {
    ImageView addimage;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private static final int PERMISSION_REQUEST_AGAIN=0;
    private static final int RESULT_LOAD_IMAGE_CAR=1;

    private EditText car_name;
    private EditText model_no;
    private EditText year;
    private EditText location;
    private EditText miles_driven;
    private EditText price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
//         addimage = findViewById(R.id.addimage);
//        addimgbutton = findViewById(R.id.addimgbutton);
//        addimgbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openGallery();
//            }
//        });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_AGAIN);
        }
        addimage = findViewById(R.id.addimage);
        Button  addimgbutton = findViewById(R.id.addimgbutton);
        addimgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE_CAR);
            }
        });



        Button push_sell_car = findViewById(R.id.push_sell_car);
        push_sell_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String object_id = SignUpProfileActivity.object_id;
                if (object_id == null) {

                    object_id = SIgninSignupActivity.object_id;

                }

                car_name = findViewById(R.id.car_name);
                model_no = findViewById(R.id.model_no);
                year = findViewById(R.id.year);
                location = findViewById(R.id.location);
                miles_driven = findViewById(R.id.miles_driven);
                price = findViewById(R.id.price);

                final ParseObject push_car_info = new ParseObject("sellingCarInfo");
                push_car_info.put("user_object_id", object_id);
                push_car_info.put("car_name", car_name.getText().toString());
                push_car_info.put("model_no",model_no.getText().toString());
                push_car_info.put("year",year.getText().toString());
                push_car_info.put("location",location.getText().toString());
                push_car_info.put("miles_driven",miles_driven.getText().toString());
                push_car_info.put("price",price.getText().toString());
                push_car_info.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(CarInfoActivity.this, "car details added for selling", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(CarInfoActivity.this, "unable to add car details " + e, Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_AGAIN:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Permission not granted",Toast.LENGTH_SHORT).show();
                    finish();
                }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case RESULT_LOAD_IMAGE_CAR:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn1 = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage,filePathColumn1, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex= cursor.getColumnIndex(filePathColumn1[0]);
                    String picturepath1 = cursor.getString(columnIndex);
                    addimage.setImageBitmap(BitmapFactory.decodeFile(picturepath1));
                }
        }
    }
    public void onPostClick(View v){
        Intent ini = new Intent(this, BuyCarListActivity.class);
        startActivity(ini);
    }

private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
}

//    @Override
//   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//       super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
//            imageUri = data.getData();
//            addimage.setImageURI(imageUri);
//
//       }
//    }
}
