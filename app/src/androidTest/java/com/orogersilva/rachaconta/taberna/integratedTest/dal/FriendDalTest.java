package com.orogersilva.rachaconta.taberna.integratedTest.dal;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import com.orogersilva.rachaconta.taberna.dal.FriendDal;
import com.orogersilva.rachaconta.taberna.model.Friend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;

import static org.junit.Assert.assertEquals;

/**
 * Created by orogersilva on 12/26/2016.
 */

@MediumTest
@RunWith(AndroidJUnit4.class)
public class FriendDalTest {

    // region FIELDS

    private static FriendDal mFriendDal;
    private static Context mContext;

    // endregion

    // region SETUP METHODS

    @BeforeClass
    public static void setupClass() {

        mContext = InstrumentationRegistry.getTargetContext().getApplicationContext();

        mFriendDal = new FriendDal(mContext);
        mFriendDal.clearDatabase();
    }

    @Before
    public void setup() {

        mFriendDal.resetDatabase();
    }

    // endregion

    // region TEST METHODS

    @Test(expected = IllegalArgumentException.class)
    public void create_whenFriendIsNull_returnsIllegalArgumentException() {

        // ARRANGE

        Friend nullFriend = null;

        // ACT / ASSERT

        mFriendDal.create(nullFriend);
    }

    @Test
    public void retrieve_whenFriendNameExists_returnsFriend() {

        // ARRANGE

        final String FRIEND_NAME = "Roger";
        final double FRIEND_DEBT = 52.00;
        final double DEBT_DELTA = 0.01;

        Friend friend = new Friend(FRIEND_NAME, FRIEND_DEBT);

        Realm.init(mContext);
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.copyToRealm(friend);
        realm.commitTransaction();

        // ACT

        Friend retrievedFriend = mFriendDal.retrieve(FRIEND_NAME);

        // ASSERT

        assertEquals(friend.getName(), retrievedFriend.getName());
        assertEquals(friend.getDebt(), retrievedFriend.getDebt(), DEBT_DELTA);
    }

    // endregion

    // region TEARDOWN METHODS

    @After
    public void teardown() {

        mFriendDal.clearDatabase();
    }

    @AfterClass
    public static void teardownClass() {

        mFriendDal = null;
    }

    // endregion
}
