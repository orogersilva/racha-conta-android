package com.orogersilva.rachaconta.taberna.dal;

import android.content.Context;

import com.orogersilva.rachaconta.taberna.model.Friend;
import com.orogersilva.rachaconta.taberna.model.Product;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class ProductDal {

    // region FIELDS

    private Realm mRealm;
    private Context mContext;

    public static final int SUCCESS_OPERATION = 0;
    public static final int FAIL_OPERATION = 1;

    // endregion

    // region CONSTRUCTORS

    public ProductDal(Context context) {

        mContext = context;

        Realm.init(mContext);

        mRealm = Realm.getDefaultInstance();
    }

    // endregion

    // region CRUD

    public int create(Product product) {

        mRealm.beginTransaction();

        try {


        } catch (IllegalArgumentException | RealmPrimaryKeyConstraintException e) {

            mRealm.cancelTransaction();
            throw e;
        }

        mRealm.commitTransaction();

        return SUCCESS_OPERATION;
    }

    // endregion
}
