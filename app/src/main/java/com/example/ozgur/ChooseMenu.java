package com.example.ozgur.itu_yemekhane;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ChooseMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);

        ImageView ivlogo = (ImageView) findViewById(R.id.ivlogo);
        ivlogo.setImageResource(R.drawable.itulogo);

        Button bnSoup = (Button) findViewById(R.id.bnSoup);
        Button bnMainCourse = (Button) findViewById(R.id.bnMainCourse);
        Button bnSideCourse = (Button) findViewById(R.id.bnSideCourse);
        Button bnSaladDessert = (Button) findViewById(R.id.bnSaladDessert);


        bnSoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseMenu.this, SoupMealsIntroduction.class);
            }
        });

        bnMainCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseMenu.this, MainCourseMealsIntroduction.class);
                startActivity(intent);
            }
        });

        bnSideCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseMenu.this, SideCourseMealsIntroduction.class);
                startActivity(intent);
            }
        });

        bnSaladDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseMenu.this, SaladAndDessertMealsIntroduction.class);
                startActivity(intent);
            }
        });
    }
}
