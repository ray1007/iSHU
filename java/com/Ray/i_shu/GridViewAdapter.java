package com.Ray.i_shu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ray on 2014/8/16.
 */
public class GridViewAdapter extends ArrayAdapter<GridItem> {
    private Context _context;
    private int _layoutResourceId;
    private ArrayList<GridItem> _data = new ArrayList();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList<GridItem> data){
        super(context, layoutResourceId, data);
        this._context = context;
        this._layoutResourceId = layoutResourceId;
        this._data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        ViewHolder holder = null;
        if(view == null){
            LayoutInflater inflater = ((Activity)_context).getLayoutInflater();
            view = inflater.inflate(_layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder._bg = (ImageView) view.findViewById(R.id.grid_view_bg);
            holder._title = (TextView) view.findViewById(R.id.grid_view_title);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        GridItem gridItem = _data.get(position);
        holder._bg.setImageResource(gridItem.getImageID());
        holder._title.setText(gridItem.getTitle());

        return view;
    }

    static class ViewHolder{
        ImageView _bg;
        TextView _title;
    }
}
