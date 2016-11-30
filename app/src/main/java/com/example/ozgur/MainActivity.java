package com.example.ozgur.itu_yemekhane;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ozgur.itu_yemekhane.adresses.Adress;
import com.example.ozgur.itu_yemekhane.connectionControl.ConnectionControl;
import com.example.ozgur.itu_yemekhane.getterSetters.GetDailyMailDataGS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adress{

    GetDailyMailDataGS getDailyMailDataGS = new GetDailyMailDataGS();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        ConnectionControl connectionControl = new ConnectionControl();
        if(connectionControl.ConnectionControl()) {

            new BackgroundTask().execute();
        }
        else{
            TextView tvDate = (TextView) findViewById(R.id.tvDate);
            tvDate.setText("İnternet Bağlantınızı Kontrol Ediniz");
        }

        ImageView ivlogo = (ImageView) findViewById(R.id.ivlogo);
        ivlogo.setImageResource(R.drawable.itulogo);


        Button bnContact = (Button) findViewById(R.id.bnContact);
        Button bnVariaty = (Button) findViewById(R.id.bnVariaty);


        bnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Contacts.class);
                startActivity(intent);
            }
        });

        bnVariaty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ChooseMenu.class);
                startActivity(intent);
            }
        });


    }


    public class BackgroundTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Document doc = null;
            Document docMeal = null;


            try {
                doc = (Jsoup.connect(mainActivityMealsWebSite).get());
                docMeal = (Jsoup.connect(mainActivityMealsWebSite).get());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("hata");
            }

            List list = new ArrayList();

            Elements dateElements = doc.select(Adress.mainActivityDateMealsHtml);


            if (docMeal.select(mainActivityMealsHtml).size() > 0) {
                Elements mealElements = doc.select(mainActivityMealsHtml);
                for (Element mealElementsFor : mealElements) {
                    list.add(mealElementsFor.text());
                    getDailyMailDataGS.setDate(dateElements.text());
                    getDailyMailDataGS.setList(list);
                }
            } else {
                Elements mealElements = doc.select(mainActivityErrorHtml);
                for(Element mealElementsFor : mealElements)
                {
                    list.add(mealElementsFor.text());
                }
                list.add("");
                list.add("");
                list.add("");
                getDailyMailDataGS.setList(list);

            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {


            TextView tvDate = (TextView) findViewById(R.id.tvDate);
            TextView tvMeal1 = (TextView) findViewById(R.id.tvMeal1);
            TextView tvMeal2 = (TextView) findViewById(R.id.tvMeal2);
            TextView tvMeal3 = (TextView) findViewById(R.id.tvMeal3);
            TextView tvMeal4 = (TextView) findViewById(R.id.tvMeal4);


            tvDate.setText(getDailyMailDataGS.getDate());
            List list = getDailyMailDataGS.getList();

            tvMeal1.setText(list.get(0).toString());
            tvMeal2.setText(list.get(1).toString());
            tvMeal3.setText(list.get(2).toString());
            tvMeal4.setText(list.get(3).toString());


        }
    }
}

