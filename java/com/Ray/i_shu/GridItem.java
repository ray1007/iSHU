package com.Ray.i_shu;

import android.graphics.Bitmap;

/**
 * Created by Ray on 2014/8/16.
 */
public class GridItem {
    private int _imageID;
    private String _title;

    public GridItem(int i, String s){
        _imageID = i;
        _title = s;
    }

    public void setImageID(int i) {
        this._imageID = i;
    }

    public int getImageID() {
        return _imageID;
    }

    public void setTitle(String s) {
        this._title = s;
    }

    public String getTitle() {
        return _title;
    }
}
