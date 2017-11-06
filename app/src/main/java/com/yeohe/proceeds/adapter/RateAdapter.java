package com.yeohe.proceeds.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yeohe.proceeds.R;
import com.yeohe.proceeds.bean.Rate;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/6.
 */

public class RateAdapter extends RecyclerView.Adapter<RateAdapter.ViewHolder > {

    private ArrayList<Rate> mData=new ArrayList<Rate>();

    public RateAdapter(ArrayList<Rate> mData) {
        this.mData=mData;
    }

    public void updateData(ArrayList<Rate> data){
        this.mData=data;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rate_layout,null);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //綁定數據
        holder.name_tv.setText(mData.get(position).getName()+"");
        holder.card_type_tv.setText(mData.get(position).getCardStyle()+"");
        holder.time_tv.setText(mData.get(position).getTime()+"");
        holder.rate_tv.setText(mData.get(position).getRate()+"");
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name_tv;
        TextView card_type_tv;
        TextView time_tv;
        TextView rate_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            name_tv= (TextView) itemView.findViewById(R.id.name_tv);
            card_type_tv= (TextView) itemView.findViewById(R.id.card_type_tv);
            time_tv= (TextView) itemView.findViewById(R.id.time_tv);
            rate_tv= (TextView) itemView.findViewById(R.id.rate_tv);
        }
    }

}
