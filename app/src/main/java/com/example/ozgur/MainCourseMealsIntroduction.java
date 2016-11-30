package com.example.ozgur.itu_yemekhane;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ozgur.itu_yemekhane.adresses.Adress;
import com.example.ozgur.itu_yemekhane.getterSetters.MealsUpdate;
import com.example.ozgur.itu_yemekhane.listviewAdapter.ListviewAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class MainCourseMealsIntroduction extends AppCompatActivity implements Adress {

    MealsUpdate mealsUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        ImageView ivlogo = (ImageView) findViewById(R.id.ivlogo);
        ivlogo.setImageResource(R.drawable.itulogo);

        new BackgroundTask2().execute();
    }

    public class BackgroundTask2 extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            Document document = null;

            try {
                document = (Jsoup.connect(mainCourseMealsIntroductionWebSite).get());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements main = document.select(mainCourseMealsIntroductionCategoriesHtml);
            Elements details = document.select(mainCourseMealsIntroductionDetailsHtml);

            List mainList = null;
            List detailList = null;

            for (Element mainListFor : main) {
                mainList.add(mainListFor.text().toString());
            }

            for (Element detailListFor : details) {
                detailList.add(detailListFor.text().toString());
            }
            mealsUpdate.setMealsLists(mainList);
            mealsUpdate.setDetailsLists(detailList);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            ListView mainListView = (ListView) findViewById(R.id.listViewMain);
            ListviewAdapter listviewAdapter = new ListviewAdapter(MainCourseMealsIntroduction.this, mealsUpdate.getMealsLists(), mealsUpdate.getDetailsLists());
            mainListView.setAdapter(listviewAdapter);
        }

    }
}

