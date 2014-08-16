package com.Ray.i_shu;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by Ray on 2014/8/16.
 */
public class MainActivity extends Activity {
    private multirowGridView _gridsWhatsNew, _gridsCamp, _gridsInfo;
    private GridViewAdapter _gridViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        getActionBar().setTitle(R.string.app_name);
        setMultirowGridViews();
        setMultirowGridViewListeners();
    }

    private void setMultirowGridViewListeners(){
        _gridsWhatsNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        //_gridsCamp.setOnClickListener();
        //_gridsInfo.setOnClickListener();
    }

    private void setMultirowGridViews(){
        _gridsWhatsNew = (multirowGridView) findViewById(R.id.whats_new_content);
        _gridsCamp = (multirowGridView) findViewById(R.id.camp_content);
        _gridsInfo = (multirowGridView) findViewById(R.id.information_content);
        _gridViewAdapter = new GridViewAdapter(this, R.layout.grid_view, getNewsData());
        _gridsWhatsNew.setAdapter(_gridViewAdapter);
        _gridViewAdapter = new GridViewAdapter(this, R.layout.grid_view, getCampData());
        _gridsCamp.setAdapter(_gridViewAdapter);
        _gridViewAdapter = new GridViewAdapter(this, R.layout.grid_view, getInfoData());
        _gridsInfo.setAdapter(_gridViewAdapter);
    }

    private ArrayList<GridItem> getNewsData(){
        ArrayList<GridItem> list = new ArrayList<GridItem>();
        TypedArray imgIDs = getResources().obtainTypedArray(R.array.whats_new_item_imgIDs);
        TypedArray titles = getResources().obtainTypedArray(R.array.whats_new_item_titles);

        for(int i=0;i<imgIDs.length();++i){
            list.add(new GridItem(imgIDs.getResourceId(i, -1), titles.getString(i)));
        }
        imgIDs.recycle();
        titles.recycle();

        return list;
    }

    private ArrayList<GridItem> getCampData(){
        ArrayList<GridItem> list = new ArrayList<GridItem>();
        TypedArray imgIDs = getResources().obtainTypedArray(R.array.camp_item_imgIDs);
        TypedArray titles = getResources().obtainTypedArray(R.array.camp_item_titles);

        for(int i=0;i<imgIDs.length();++i){
            list.add(new GridItem(imgIDs.getResourceId(i, -1), titles.getString(i)));
        }
        imgIDs.recycle();
        titles.recycle();

        return list;
    }

    private ArrayList<GridItem> getInfoData(){
        ArrayList<GridItem> list = new ArrayList<GridItem>();
        TypedArray imgIDs = getResources().obtainTypedArray(R.array.information_item_imgIDs);
        TypedArray titles = getResources().obtainTypedArray(R.array.information_item_titles);

        for(int i=0;i<imgIDs.length();++i){
            list.add(new GridItem(imgIDs.getResourceId(i, -1), titles.getString(i)));
        }
        imgIDs.recycle();
        titles.recycle();

        return list;
    }
}
