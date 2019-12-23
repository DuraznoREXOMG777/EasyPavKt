package com.highf.genericrecyclerviewadapter;

/**
 * The most commonly used listener with the {@link GenericRecyclerViewAdapter}.
 * It is sutable for all cases where one click listener for a RecyclerView item is enough.
 * Otherwise (if for instance, you have multiple Butoons on an item), you will have to create a custom listener and define there as many callbacks as you need. Just make sure it extends from {@link BaseRecyclerListener} or {@link OnRecyclerItemClickListener}
 */

public interface OnRecyclerItemClickListener extends BaseRecyclerListener {

    /**
     * Returns clicked item position RecyclerView.ViewHolder#getAdapterPosition()
     *
     * @param position clicked item position.
     */
    void onItemClick(int position);
}