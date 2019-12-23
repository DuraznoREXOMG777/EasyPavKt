package com.highf.genericrecyclerviewadapter.decorator;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Item decorator {@link RecyclerView.ItemDecoration} which allows using
 * a custom drawable as a source.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class DrawableItemDecorator extends RecyclerView.ItemDecoration {

    private Drawable dividerDrawable;

    public DrawableItemDecorator(Drawable dividerDrawable) {
        validateDrawableOrThrow(dividerDrawable);
        this.dividerDrawable = dividerDrawable;
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < adapter.getItemCount() - 2; i++) {
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + dividerDrawable.getIntrinsicHeight();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }

    /**
     * Validates a divider drawable.
     *
     * @param drawable which has to be used as a divider between {@link RecyclerView} items
     * @throws IllegalArgumentException in case drawable is <code>null</code> or has illegal size.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    private void validateDrawableOrThrow(Drawable drawable) throws IllegalArgumentException {
        if (drawable == null) {
            throw new IllegalArgumentException("Divider cannot be null");
        } else if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            throw new IllegalArgumentException("Illegal divider drawable. Wrong size: width = " + drawable.getIntrinsicWidth() + ", height = " + drawable.getIntrinsicHeight());
        }
    }
}