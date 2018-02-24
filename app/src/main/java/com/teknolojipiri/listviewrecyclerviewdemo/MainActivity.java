package com.teknolojipiri.listviewrecyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_activity_title);

        findViewById(R.id.btn_listview).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_listview) {
            startActivity(new Intent(this, ListViewActivity.class));
        } else if (id == R.id.btn_recyclerview) {
            startActivity(new Intent(this, RecyclerViewActivity.class));
        }
    }
}
