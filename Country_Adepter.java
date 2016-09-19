package com.example.nichetech.customchackbox;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nichetech on 19/9/16.
 */
public class Country_Adepter extends BaseAdapter {

    Integer selected_position = -1;
    List<Country> countries;
    Context context;
    LayoutInflater inflter;
    int prevposition;
    int FristTimeSelectedId=121;

    public Country_Adepter(Context context, List<Country> countries) {

        this.context = context;
        this.countries = countries;


        for(int i=0; i<countries.size(); i++){
            if(FristTimeSelectedId==countries.get(i).getCountryID()){
                countries.get(i).setFlag(1);

            }else{
                countries.get(i).setFlag(0);

            }
        }
    }


    public Country getCountry()
    {
        int selectedposition=-1;

        for(int i=0; i<countries.size(); i++){
            if(countries.get(i).getFlag()==1){

                Log.e("get Selected ---->>",""+countries.get(i).getCountryID());
                selectedposition=i;

                break;

            }else{
            }
        }

        if(selectedposition>=0)
        {
            return countries.get(selectedposition);
        }
        else {
            return null;
        }

    }

    @Override
    public int getCount() {
        return countries.size();
    }
    @Override
    public Object getItem(int position) {

        return countries.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        inflter = (LayoutInflater.from(context));
        view = inflter.inflate(R.layout.custome_countrylist_adepter, null);
        TextView names = (TextView) view.findViewById(R.id.country_name);
        final CheckBox chkbox = (CheckBox) view.findViewById(R.id.country_selected);
        names.setText(countries.get(position).getCountryName());

        if (countries.get(position).getFlag() == 1) {
            chkbox.setChecked(true);
            prevposition = position;


        } else {
            chkbox.setChecked(false);
        }

        chkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (chkbox.isChecked()) {

                    countries.get(position).setFlag(1);
                    if (countries.get(position) != countries.get(prevposition)) {
                        countries.get(prevposition).setFlag(0);
                        Log.e("prevposition==>", "" + prevposition);
                    }
                    Log.e("position==>", "" + position);

                } else {

                    countries.get(position).setFlag(0);

                }
                notifyDataSetChanged();

            }
        });

        return view;
    }
}
