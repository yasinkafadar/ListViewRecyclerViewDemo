package com.teknolojipiri.listviewrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setTitle(R.string.list_view_title);

        ListView listCountry = findViewById(R.id.list_country);
        countryAdapter = new CountryAdapter(this, CountryDataSource.getAllCountries());
        listCountry.setAdapter(countryAdapter);
        listCountry.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Country country = countryAdapter.getItem(position);
        Toast.makeText(this, country.getName(), Toast.LENGTH_SHORT).show();
    }
}
