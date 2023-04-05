package com.example.bdworks;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ForbesAdapter adapter = new ForbesAdapter(this,makeAMan());
        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name =  ((Person)parent.getItemAtPosition(position)).name;
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    // Метод cоздания массива полей людей
    Person[] makeAMan() {
        Person[] people = new Person[100];
        Resources  res =getResources();
        String [] names = res.getStringArray(R.array.forbes);
        String [] money = {"$86 B", "$75.6 B", "$72.8 B", "$71.3 B", "$56 B", "$54.5 B", "$52.2 B", "$48.3 B", "$48.3 B", "$47.5 B", "$41.5 B", "$40.7 B", "$39.8 B", "$39.5 B", "$34.1 B", "$34 B", "$33.8 B", "$31.3 B", "$31.2 B", "$30.4 B", "$30 B", "$29.2 B", "$28.3 B", "$27.2 B", "$27.2 B", "$27 B", "$27 B", "$26.2 B", "$25.2 B", "$25.2 B", "$24.9 B", "$24.4 B", "$23.2 B", "$21.2 B", "$21.1 B", "$20.7 B", "$20.5 B", "$20.4 B", "$20.4 B", "$20 B", "$20 B", "$19.9 B", "$19.6 B", "$18.8 B", "$18.7 B", "$18.4 B", "$18.3 B", "$18.3 B", "$18 B", "$17.9 B", "$17.5 B", "$17.3 B", "$17 B", "$16.8 B", "$16.6 B", "$16.4 B", "$16.1 B", "$16.1 B", "$16 B", "$15.9 B", "$15.9 B", "$15.8 B", "$15.7 B", "$15.4 B", "$15.3 B", "$15.2 B", "$15.2 B", "$15.1 B", "$15 B", "$15 B", "$15 B", "$14.9 B", "$14.8 B", "$14.5 B", "$14.4 B", "$14.4 B", "$14.3 B", "$14.3 B", "$14 B", "$13.9 B", "$13.9 B", "$13.8 B", "$13.8 B", "$13.7 B", "$13.7 B", "$13.4 B", "$13.3 B", "$13.3 B", "$13.2 B", "$13.1 B", "$13.1 B", "$13 B", "$13 B", "$12.7 B", "$12.6 B", "$12.5 B", "$12.5 B", "$12.5 B", "$12.5 B", "$12.4 B", };
        int [] flags = {R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.spain, R.drawable.united_states, R.drawable.mexico, R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.france, R.drawable.united_states, R.drawable.united_states, R.drawable.france, R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.china, R.drawable.hong_kong, R.drawable.united_states, R.drawable.united_states, R.drawable.brazil, R.drawable.china, R.drawable.germany, R.drawable.canada, R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.italy, R.drawable.united_states, R.drawable.china, R.drawable.hong_kong, R.drawable.india, R.drawable.japan, R.drawable.denmark, R.drawable.germany, R.drawable.brazil, R.drawable.united_states, R.drawable.germany, R.drawable.united_states, R.drawable.united_states, R.drawable.united_states, R.drawable.sweden, R.drawable.germany, R.drawable.saudi_arabia, R.drawable.russia, R.drawable.united_states, R.drawable.germany, R.drawable.united_states, R.drawable.italy, R.drawable.russia, R.drawable.china, R.drawable.germany, R.drawable.united_states, R.drawable.united_states, R.drawable.india, R.drawable.france, R.drawable.russia, R.drawable.russia, R.drawable.china, R.drawable.japan, R.drawable.thailand, R.drawable.france, R.drawable.united_kingdom, R.drawable.united_kingdom, R.drawable.united_states, R.drawable.russia, R.drawable.south_korea, R.drawable.hong_kong, R.drawable.hong_kong, R.drawable.australia, R.drawable.india, R.drawable.brazil, R.drawable.russia, R.drawable.russia, R.drawable.united_states, R.drawable.ireland, R.drawable.russia, R.drawable.china, R.drawable.united_states, R.drawable.italy, R.drawable.mexico, R.drawable.united_states, R.drawable.chile, R.drawable.india, R.drawable.austria, R.drawable.united_states, R.drawable.china, R.drawable.russia, R.drawable.united_states, R.drawable.germany, R.drawable.united_states, R.drawable.france, R.drawable.philippines, R.drawable.netherlands, R.drawable.united_states, R.drawable.united_states, R.drawable.sweden, R.drawable.brazil, R.drawable.germany, } ;


        for (int i = 0; i < people.length; i++) {
            Person person = new Person();
            person.name = names[i];
            person.money = money[i];
            person.flag_res = flags[i] ;
            people[i] = person;
        }
        return people;
    }
}