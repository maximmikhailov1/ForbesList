package com.example.bdworks;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

public class ForbesAdapter extends ArrayAdapter<Person> {
    public ForbesAdapter(Context context, Person[] arr) {
        super(context, R.layout.list_item, arr);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        final Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }
        assert person != null;
        ((TextView) convertView.findViewById(R.id.name)).setText(person.name);
        ((TextView) convertView.findViewById(R.id.money)).setText(person.money);
        ((ImageView) convertView.findViewById(R.id.flag)).setImageResource(person.flag_res);



        return convertView;
    }
}
