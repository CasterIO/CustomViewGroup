package io.caster.customviewgroup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.caster.customviewgroup.R;

/**
 *
 */

public class CustomListItem extends ViewGroup {

    private ImageView iconView;
    private TextView titleTextView;
    private TextView subtitleTextView;

    public CustomListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        iconView = findViewById(R.id.icon);
        titleTextView = findViewById(R.id.title);
        subtitleTextView = findViewById(R.id.subtitle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
