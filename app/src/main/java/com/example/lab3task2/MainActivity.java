package com.example.lab3task2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button call,camera,contact,browser,call_log,Gallery,dailpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);
        call=findViewById(R.id.Call);
        camera=findViewById(R.id.Camera);
        contact=findViewById(R.id.Contact);
        browser=findViewById(R.id.Browser);
        call_log=findViewById(R.id.Call_log);
        Gallery=findViewById(R.id.Gallery);
        dailpad=findViewById(R.id.Dail_pad);



        call.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View arg0) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:1234567890"));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[] { Manifest.permission.CALL_PHONE },1);
                    return;
                }
                startActivity(call);
            }
        });

        camera.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View v){
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[] { Manifest.permission.CAMERA },1);
                    return;
                }
                startActivity(intent);
            }
        });

        dailpad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_DIAL);
                startActivity(i);

            }
        });

        browser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://"+text.getText().toString()));
                startActivity(i);

            }
        });

        call_log.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://call_log/calls"));
                startActivity(i);
            }
        });

        Gallery.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(i);
            }
        });

        contact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);

            }
        });
    }
}


