package com.Ray.i_shu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Ray on 2014/8/16.
 */
public class multirowGridView extends GridView {
    public multirowGridView(Context context){
        super(context);
    }

    public multirowGridView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public multirowGridView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int heightSpec;

        if(getLayoutParams().height == LayoutParams.WRAP_CONTENT){
            heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }else{ heightSpec = heightMeasureSpec; }

        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
