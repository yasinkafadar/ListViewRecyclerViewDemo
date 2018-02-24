package com.teknolojipiri.listviewrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements CountryAdapterRecyclerView.OnItemClickListener, View.OnClickListener {

    private RecyclerView countryRecyclerView;
    private CountryAdapterRecyclerView countryAdapterRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setTitle(R.string.recycler_view_title);

        countryRecyclerView = findViewById(R.id.recycler_view_country);

        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        countryRecyclerView.setLayoutManager(layoutManager);
//        countryRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        countryAdapterRecyclerView = new CountryAdapterRecyclerView(CountryDataSource.getAllCountries());
        countryAdapterRecyclerView.setItemClickListener(this);

        countryRecyclerView.setAdapter(countryAdapterRecyclerView);
        countryRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        findViewById(R.id.btn_add_item).setOnClickListener(this);
        findViewById(R.id.btn_remove_item).setOnClickListener(this);
    }

    @Override
    public void onItemClicked(int position, Country country) {
        Toast.makeText(this, country.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_add_item) {
            List<Country> countryList = CountryDataSource.getAllCountries();
            countryList.add(2, new Country("TR", "Turkey", "+90", R.drawable.flag_tr));
            countryAdapterRecyclerView.notifyItemInserted(2);
        } else if (id == R.id.btn_remove_item) {
            List<Country> countryList = CountryDataSource.getAllCountries();
            countryList.remove(2);
            countryAdapterRecyclerView.notifyItemRemoved(2);
        }
    }
}
