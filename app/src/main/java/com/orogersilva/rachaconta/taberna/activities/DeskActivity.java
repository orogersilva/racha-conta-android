package com.orogersilva.rachaconta.taberna.activities;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orogersilva.rachaconta.taberna.R;
import com.orogersilva.rachaconta.taberna.adapters.FriendsAdapter;
import com.orogersilva.rachaconta.taberna.dialogs.InputAddFriendDialog;
import com.orogersilva.rachaconta.taberna.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class DeskActivity extends AppCompatActivity {

    // region FIELDS

    private RecyclerView mFriendsRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FriendsAdapter mFriendsAdapter;

    private TextView mWarningTextView;

    private List<Friend> mFriends = new ArrayList<>();

    private FloatingActionButton mAddFriendFloatingActionButton;

    // endregion

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desk);

        mFriendsRecyclerView = (RecyclerView) findViewById(R.id.friends_recyclerview);
        mWarningTextView = (TextView) findViewById(R.id.warningTextView);

        mFriendsAdapter = new FriendsAdapter(mFriends);
        mLayoutManager = new LinearLayoutManager(this);

        mFriendsRecyclerView.setLayoutManager(mLayoutManager);
        mFriendsRecyclerView.setAdapter(mFriendsAdapter);

        mAddFriendFloatingActionButton = (FloatingActionButton) findViewById(R.id.deskfloatingactionbutton);

        mAddFriendFloatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final InputAddFriendDialog inputAddFriendDialog = new InputAddFriendDialog(DeskActivity.this);

                InputAddFriendDialog.InputAddFriendClickListener listener  = new InputAddFriendDialog.InputAddFriendClickListener() {

                    @Override
                    public void onClick() {

                        final EditText nameEditText = (EditText) inputAddFriendDialog.findViewById(R.id.friend_name_edittext);

                        final String FRIEND_NAME = nameEditText.getText().toString();

                        Friend friend = new Friend(FRIEND_NAME, 0);

                        mFriends.add(friend);

                        if (mFriends.size() > 0) {
                            mWarningTextView.setVisibility(View.GONE);
                            mFriendsRecyclerView.setVisibility(View.VISIBLE);
                        }

                        mFriendsAdapter.notifyDataSetChanged();
                    }
                };

                inputAddFriendDialog.setListener(listener);
                inputAddFriendDialog.show();
            }
        });
    }

    // endregion
}
