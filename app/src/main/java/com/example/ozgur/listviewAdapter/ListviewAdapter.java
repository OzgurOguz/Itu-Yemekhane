package com.example.ozgur.itu_yemekhane.listviewAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ozgur.itu_yemekhane.R;
import com.example.ozgur.itu_yemekhane.getterSetters.MealsUpdate;

import java.util.List;


public class ListviewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<MealsUpdate> mealsUpdatesList;
    private List<MealsUpdate> mealsUpdatesList2;

    public ListviewAdapter(Activity activity, List <MealsUpdate> mealsUpdates, List <MealsUpdate> mealsUpdates2){

        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mealsUpdatesList = mealsUpdates;
        mealsUpdatesList = mealsUpdates2;
    }
    @Override
    public int getCount() {
        return mealsUpdatesList.size();
    }

    @Override
    public MealsUpdate getItem(int position) {
        return mealsUpdatesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listviewAdapterView;

        listviewAdapterView = mInflater.inflate(R.layout.listview_adapter, null);
        TextView textView = (TextView) listviewAdapterView.findViewById(R.id.main);
        TextView textView1 = (TextView) listviewAdapterView.findViewById(R.id.detail);

        MealsUpdate mealsUpdate= mealsUpdatesList.get(position);
        MealsUpdate mealsUpdate2= mealsUpdatesList2.get(position);


        textView.setText(mealsUpdate.getMealsLists().toString());
        textView1.setText(mealsUpdate2.getDetailsLists().toString());


        return listviewAdapterView;
    }
}
