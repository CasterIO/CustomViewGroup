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
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof MarginLayoutParams;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildWithMargins(iconView, widthMeasureSpec, 0, heightMeasureSpec, 0);

        MarginLayoutParams lp = (MarginLayoutParams) iconView.getLayoutParams();
        int iconWidthUsed = iconView.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
        int iconHeightUsed = iconView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

        measureChildWithMargins(titleTextView, widthMeasureSpec, iconWidthUsed, heightMeasureSpec, 0);

        lp = (MarginLayoutParams) titleTextView.getLayoutParams();
        int titleWidthUsed = titleTextView.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
        int titleHeightUsed = titleTextView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

        measureChildWithMargins(subtitleTextView, widthMeasureSpec, iconWidthUsed, heightMeasureSpec, titleHeightUsed);

        lp = (MarginLayoutParams) subtitleTextView.getLayoutParams();
        int subtitleWidthUsed = subtitleTextView.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
        int subtitleHeightUsed = subtitleTextView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

        // At this point all the child views have been measured.

        // Now calculate the measured width and height of this CustomListItem.

        int width = iconWidthUsed + Math.max(titleWidthUsed, subtitleWidthUsed) +
            getPaddingLeft() + getPaddingRight();
        int height = Math.max(iconHeightUsed, titleHeightUsed + subtitleHeightUsed) +
            getPaddingTop() + getPaddingBottom();

        setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final MarginLayoutParams iconLayoutParams = (MarginLayoutParams) iconView.getLayoutParams();
        int left = getPaddingLeft() + iconLayoutParams.leftMargin;
        int top = getPaddingTop() + iconLayoutParams.topMargin;
        int right = left + iconView.getMeasuredWidth();
        int bottom = top + iconView.getMeasuredHeight();

        iconView.layout(left, top, right, bottom);

        final int iconRightPlusMargin = right + iconLayoutParams.rightMargin;

        final MarginLayoutParams titleLayoutParams = (MarginLayoutParams) titleTextView.getLayoutParams();
        left = iconRightPlusMargin + titleLayoutParams.leftMargin;
        top = getPaddingTop() + titleLayoutParams.topMargin;
        right = left + titleTextView.getMeasuredWidth();
        bottom = top + titleTextView.getMeasuredHeight();

        titleTextView.layout(left, top, right, bottom);

        final int titleBottomPlusMargin = bottom + titleLayoutParams.bottomMargin;

        final MarginLayoutParams subtitleLayoutParams = (MarginLayoutParams) subtitleTextView.getLayoutParams();
        left = iconRightPlusMargin + subtitleLayoutParams.leftMargin;
        top = titleBottomPlusMargin + subtitleLayoutParams.topMargin;
        right = left + subtitleTextView.getMeasuredWidth();
        bottom = top + subtitleTextView.getMeasuredHeight();

        subtitleTextView.layout(left, top, right, bottom);
    }
}
