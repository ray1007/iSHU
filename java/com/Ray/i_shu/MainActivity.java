package com.Ray.i_shu;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;
//import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Ray on 2014/8/16.
 */
public class MainActivity extends Activity {
    private multirowGridView _gridsWhatsNew, _gridsCamp, _gridsInfo;
    private GridViewAdapter _gridViewAdapter;
    private ScrollView _scrollView;
    private int _scrollX, _scrollY;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        getActionBar().setTitle(R.string.app_name);
        _scrollView = (ScrollView) findViewById(R.id.main_scrollView);
        setMultirowGridViews();
        setMultirowGridViewListeners();
    }

    @Override
    public void onResume(){
        super.onResume();
        _scrollView.scrollTo(_scrollX, _scrollY);
    }

    @Override
    public void onPause(){
        super.onPause();
        _scrollX = _scrollView.getScrollX();
        _scrollY = _scrollView.getScrollY();
    }
    // methods to keep _scrollView position
    /*protected void onSaveInstanceState(Bundle outState){
        outState.putIntArray("SCROLL_POSITION", new int[]{_scrollView.getScrollX(),
                                                          _scrollView.getScrollY()});
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        int[] position = savedInstanceState.getIntArray("SCROLL_POSITION");
        if(position != null){
            _scrollView.scrollTo(position[0],position[1]);
        }
    }*/

    private void setMultirowGridViewListeners(){
        /*_gridsWhatsNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/
        _gridsCamp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 1://clicked camp_news
                        break;
                    case 4://clicked camp_activity
                        break;
                    case 5://clicked camp_album
                        break;
                    default://no function for other grid items.
                        break;
                }
            }
        });
        //_gridsInfo.setOnClickListener();
    }

    private void setMultirowGridViews(){
        _gridsWhatsNew = (multirowGridView) findViewById(R.id.whatsNew_content);
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
