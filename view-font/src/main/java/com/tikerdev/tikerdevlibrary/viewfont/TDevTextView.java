package com.tikerdev.tikerdevlibrary.viewfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.tikerdev.tikerdevlibrary.viewfont.util.FontCache;

import static com.tikerdev.tikerdevlibrary.viewfont.util.Config.ANDROID_SCHEMA;
import static com.tikerdev.tikerdevlibrary.viewfont.util.Config.FONT_CS_CHAT_THAI_UI;
import static com.tikerdev.tikerdevlibrary.viewfont.util.Config.FONT_KANIT;
import static com.tikerdev.tikerdevlibrary.viewfont.util.Config.ROOT_DIRECTORY;

/**
 * Created by Error404 on 18/5/2559.
 */
public class TDevTextView extends AppCompatTextView {

    private Typeface mTypeface;

    public TDevTextView(Context context) {
        super(context);
    }

    public TDevTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithAttrs(attrs, 0, 0);
    }

    public TDevTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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