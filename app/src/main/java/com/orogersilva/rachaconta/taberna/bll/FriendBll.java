package com.orogersilva.rachaconta.taberna.bll;

import com.orogersilva.rachaconta.taberna.dal.FriendDal;
import com.orogersilva.rachaconta.taberna.exception.InvalidStringException;
import com.orogersilva.rachaconta.taberna.model.Friend;
import com.orogersilva.rachaconta.taberna.util.StringUtils;

/**
 * Created by orogersilva on 12/25/2016.
 */

public class FriendBll {

    // region FIELDS

    private FriendDal mFriendDal;

    // endregion

    // region CONSTRUCTORS

    public FriendBll(FriendDal friendDal) {

        mFriendDal = friendDal;
    }

    // endregion

    // region PUBLIC METHODS

    public Friend getFriend(String name) {

        Friend friend = null;

        try {

            if (StringUtils.isNullOrEmpty(name)) {
                throw new InvalidStringException();
            }

            friend = mFriendDal.retrieve(name);

        } catch (InvalidStringException e) {}

        return friend;
    }

    public void addFriend(Friend friend) {

        if (friend == null) throw new NullPointerException();

        mFriendDal.create(friend);
    }

    // endregion
}
