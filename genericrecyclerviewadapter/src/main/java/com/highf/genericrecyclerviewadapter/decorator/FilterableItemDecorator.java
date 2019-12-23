package com.highf.genericrecyclerviewadapter.decorator;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Item decorator which draws a divider only between views of the same types {@link #viewType}
 */

public class FilterableItemDecorator extends RecyclerView.ItemDecoration {

    private Drawable dividerDrawable;
    /**
     * View contentType between which to draw a divider.
     * Pass in zero <code>0</code> or a negative vale instead to show divider between any view types.
     */
    private @LayoutRes
    int viewType;

    public FilterableItemDecorator(Drawable dividerDrawable, @LayoutRes int viewType) {
        validateDrawableOrThrow(dividerDrawable);
        this.dividerDrawable = dividerDrawable;
        this.viewType = viewType;
    }


    @SuppressLint("ResourceType")
    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (null == adapter) {
            return;
        }
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int itemCount = adapter.getItemCount();
        for (int i = 0; i < itemCount - 1; i++) {

            final View child = parent.getChildAt(i);
            if (null == child) {
                continue;
            }
            int position = parent.getChildAdapterPosition(child);

            if (viewType <= 0 || position > 0 && position < adapter.getItemCount() - 1
                    && adapter.getItemViewType(position) == viewType
                    && adapter.getItemViewType(position + 1) == viewType) {
                // we are between two needed view types, draw the divider
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + dividerDrawable.getIntrinsicHeight();
                dividerDrawable.setBounds(left, top, right, bottom);
                dividerDrawable.draw(canvas);
            }
        }
    }

    /**
     * Validates a divider drawable.
     *
     * @param drawable which has to be used as a divider between {@link RecyclerView} items
     * @throws IllegalArgumentException in case drawable is <code>null</code> or has illegal size.
     */
    private void validateDrawableOrThrow(Drawable drawable) throws IllegalArgumentException {
        if (drawable == null) {
            throw new IllegalArgumentException("Divider cannot be null");
        } else if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            throw new IllegalArgumentException("Illegal divider drawable. Wrong size: width = " + drawable.getIntrinsicWidth() + ", height = " + drawable.getIntrinsicHeight());
        }
    }
}