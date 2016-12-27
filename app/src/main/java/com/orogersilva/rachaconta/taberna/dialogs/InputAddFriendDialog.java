package com.orogersilva.rachaconta.taberna.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.orogersilva.rachaconta.taberna.R;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class InputAddFriendDialog extends Dialog {

    // region FIELDS

    private InputAddFriendClickListener mListener;

    private Button mAddFriendButton;

    // endregion

    // region INTERFACES

    public interface InputAddFriendClickListener {

        // region METHODS

        void onClick();

        // endregion
    }

    // endregion

    // region CONSTRUCTORS

    public InputAddFriendDialog(final Context context) {

        super(context);
    }

    // endregion

    // region PUBLIC METHODS

    public void setListener(InputAddFriendClickListener listener) {

        mListener = listener;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_add_friend);

        mAddFriendButton = (Button) findViewById(R.id.add_friend_button);

        mAddFriendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mListener.onClick();

                dismiss();
            }
        });
    }

    // endregion
}
