package com.tikerdev.tikerdevlibrary.viewfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.tikerdev.tikerdevlibrary.viewfont.util.FontCache;

/**
 * Created by Error404 on 18/5/2559.
 */
public class TRadioButton extends AppCompatRadioButton {

    private Typeface mTypeface;

    public TRadioButton(Context context) {
        super(context);
    }

    public TRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithAttrs(attrs, 0, 0);
    }

    public TRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TDevTextView,
                defStyleAttr, defStyleRes);
        try {
            int fontName = a.getInt(R.styleable.TDevTextView_fontName, 1);
            mTypeface = FontCache.applyCustomFont(getContext(), attrs, fontName);
            updateFontName();
        } finally {
            a.recycle();
        }

    }

    public void setFontName(Typeface typeface) {
        this.mTypeface = typeface;
        updateFontName();
    }

    private void updateFontName() {
        if (mTypeface != null) {
            setTypeface(mTypeface);
        }
    }
}