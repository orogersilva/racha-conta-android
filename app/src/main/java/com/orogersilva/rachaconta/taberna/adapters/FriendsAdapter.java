package com.orogersilva.rachaconta.taberna.adapters;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orogersilva.rachaconta.taberna.R;
import com.orogersilva.rachaconta.taberna.model.Friend;

import java.util.List;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ItemViewHolder> {

    // region FIELDS

    private List<Friend> mFriends;

    // endregion

    // region CONSTRUCTORS

    public FriendsAdapter(List<Friend> friends) {

        mFriends = friends;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_friend, parent, false);

        ItemViewHolder vh = new ItemViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.nameTextView.setText(mFriends.get(position).getName());

        double debt = mFriends.get(position).getDebt();

        if (debt == 0) {
            holder.debtTextView.setText("-");
        } else {
            holder.debtTextView.setText(String.valueOf(debt));
        }
    }

    @Override
    public int getItemCount() {

        return mFriends.size();
    }

    // endregion

    // region UTILITY CLASSES

    class ItemViewHolder extends RecyclerView.ViewHolder {

        // region FIELDS

        public TextView nameTextView;
        public TextView debtTextView;

        // endregion

        // region CONSTRUCTORS

        public ItemViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            debtTextView = (TextView) itemView.findViewById(R.id.debtTextView);
        }

        // endregion
    }

    // endregion
}
