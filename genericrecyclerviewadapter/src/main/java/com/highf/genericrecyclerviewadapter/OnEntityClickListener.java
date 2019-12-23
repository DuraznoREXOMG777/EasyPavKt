package com.highf.genericrecyclerviewadapter;

/**
 * Listener, which triggers an object associated with the item,
 * rather than position, on recycler item click.
 *
 * @param <T> object click listener
 */
public interface OnEntityClickListener<T> extends BaseRecyclerListener {

    /**
     * Item has been clicked.
     * Here you retrieve an entity associated with the clicked item and you are free to use it in any way.
     *
     * @param item object associated with the clicked item.
     */
    void onItemClicked(T item);
}