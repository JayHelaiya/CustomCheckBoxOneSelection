package com.example.nichetech.customchackbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ListView listView;
    Country_Adepter adepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Country> clist=new ArrayList<>();
        clist.add(new Country(121,"india"));
        clist.add(new Country(109,"Australia"));
        clist.add(new Country(108,"USA"));
        clist.add(new Country(111,"London"));
        clist.add(new Country(112,"Denmark"));
        clist.add(new Country(101,"Ezipt"));


        listView = (ListView) findViewById(R.id.listview);
        listView.setClickable(true);
        Button button=(Button)findViewById(R.id.coutrybtn);


        adepter = new Country_Adepter(getApplicationContext(),clist);
        listView.setAdapter(adepter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Country country=adepter.getCountry();

                Toast.makeText(getApplicationContext(),country.getCountryName()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
