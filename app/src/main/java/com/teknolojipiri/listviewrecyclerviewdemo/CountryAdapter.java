package com.teknolojipiri.listviewrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yasin on 24.02.2018.
 */

public class CountryAdapter extends BaseAdapter {

    private List<Country> items;
    private LayoutInflater inflater;
    private Context context;

    public CountryAdapter(Context context, List<Country> items){
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public Country getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_country, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.imgFlag = convertView.findViewById(R.id.img_flag);
            viewHolder.txtCountryName = convertView.findViewById(R.id.txt_country_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Country country = getItem(position);
        viewHolder.imgFlag.setImageResource(country.getFlag());
        viewHolder.txtCountryName.setText(country.getName());

        return convertView;
    }

    private static class ViewHolder {
        public ImageView imgFlag;
        public TextView txtCountryName;
    }
}
