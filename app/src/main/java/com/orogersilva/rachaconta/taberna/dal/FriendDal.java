package com.orogersilva.rachaconta.taberna.dal;

import android.content.Context;

import com.orogersilva.rachaconta.taberna.model.Friend;

import io.realm.Realm;
import io.realm.annotations.PrimaryKey;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

/**
 * Created by orogersilva on 12/25/2016.
 */

public class FriendDal {

    // region FIELDS

    private Realm mRealm;
    private Context mContext;

    public static final int SUCCESS_OPERATION = 0;
    public static final int FAIL_OPERATION = 1;

    // endregion

    // region CONSTRUCTORS

    public FriendDal(Context context) {

        mContext = context;

        Realm.init(mContext);

        mRealm = Realm.getDefaultInstance();
    }

    // endregion

    // region CRUD

    public int create(Friend friend) {

        mRealm.beginTransaction();

        try {


        } catch (IllegalArgumentException | RealmPrimaryKeyConstraintException e) {

            mRealm.cancelTransaction();
            throw e;
        }

        mRealm.commitTransaction();

        return SUCCESS_OPERATION;
    }

    public Friend retrieve(String name) {

        return null;
    }

    // endregion

    // region OTHER METHODS

    public void resetDatabase() {

        if (mRealm != null && mRealm.isInTransaction()) {
            mRealm.cancelTransaction();
        }
    }

    public void clearDatabase() {

        resetDatabase();

        mRealm.beginTransaction();
        mRealm.where(Friend.class).findAll().deleteAllFromRealm();
        mRealm.commitTransaction();
    }

    // endregion
}
