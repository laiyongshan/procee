package com.yeohe.proceeds.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yeohe.proceeds.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private String[] titles;
    private Class[] classes;

    private ViewHolder holder;

    public ItemAdapter(Context context, String[] titles, Class[] classes){
        this.context=context;
        this.titles=titles;
        this.classes=classes;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_parallax_listview,null);

            holder=new ViewHolder();

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.item_tv= (TextView) convertView.findViewById(R.id.item_tv);
        holder.item_tv.setText(titles[position]);

        return convertView;
    }


    class ViewHolder{
        TextView item_tv;
    }

}
