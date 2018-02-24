package com.teknolojipiri.listviewrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yasin on 24.02.2018.
 */

public class CountryAdapterRecyclerView extends RecyclerView.Adapter<CountryAdapterRecyclerView.CountryViewHolder> {

    private List<Country> items;

    public OnItemClickListener itemClickListener;
    public interface OnItemClickListener {
        void onItemClicked(int position, Country country);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCountryName;
        public ImageView imgFlag;

        public CountryViewHolder(View itemView) {
            super(itemView);
            txtCountryName = itemView.findViewById(R.id.txt_country_name);
            imgFlag = itemView.findViewById(R.id.img_flag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        int position = getAdapterPosition();
                        itemClickListener.onItemClicked(position, items.get(position));
                    }
                }
            });
        }
    }

    public CountryAdapterRecyclerView(List<Country> items){
        this.items = items;
    }

    public void setDataSource(List<Country> items){
        this.items = items;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.list_item_country, parent, false);
        CountryViewHolder viewHolder = new CountryViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = items.get(position);
        holder.txtCountryName.setText(country.getName());
        holder.imgFlag.setImageResource(country.getFlag());
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
