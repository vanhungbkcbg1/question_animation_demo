package com.example.vanhung.demo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by vanhung on 11/25/2015.
 */
public class FontView extends TextView {
    private static Typeface font;
    private String icon="   "+getResources().getString(R.string.fa_check);
    public FontView(Context context) {
        super(context);
        setFont(context);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public FontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }
    private void setFont(Context context) {
        // prevent exception in Android Studio / ADT interface builder
        if (this.isInEditMode()) {
            return;
        }

        //Check for font is already loaded
        if(font == null) {
            try {
                font = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
            } catch (RuntimeException e) {
            }
        }

        //Finally set the font
        setBackgroundColor(Color.parseColor("#FFDBDB"));
        setTypeface(font);
        setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new OnClickListener() {
        @Override
        public void onClick(View v) {
            String text=((TextView)v).getText().toString();
            if (!text.contains(icon))
            {
                text=text+icon;
            }
            setText(text);

        }
    };

}
