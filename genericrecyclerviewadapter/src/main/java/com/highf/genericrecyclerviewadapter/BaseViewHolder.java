package com.highf.genericrecyclerviewadapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Base ViewHolder to be used with the generic adapter.
 * {@link GenericRecyclerViewAdapter}
 *
 * @param <T> contentType of objects, which will be used in the adapter's data set
 * @param <L> click listener {@link BaseRecyclerListener}
 */
public abstract class BaseViewHolder<T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    private L listener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(View itemView, L listener) {
        super(itemView);
        this.listener = listener;
    }

    /**
     * Bind data to the item.
     * Make sure not to perform any expensive operations here.
     *
     * @param item object, associated with the item.
     */
    public abstract void onBind(T item);

    /**
     * Bind data to the item.
     * Override this method for using the payloads in order to achieve the full power of DiffUtil
     *
     * @param item object, associated with the item.
     */
    public void onBind(T item, List<Object> payloads) {
        onBind(item);
    }

    protected L getListener() {
        return listener;
    }
}
