package com.example.ozgur.itu_yemekhane;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        ImageView ivlogo = (ImageView) findViewById(R.id.ivlogo);
        ivlogo.setImageResource(R.drawable.itulogo);
    }
}
