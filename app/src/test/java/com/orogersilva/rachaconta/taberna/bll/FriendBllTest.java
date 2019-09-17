package com.orogersilva.rachaconta.taberna.bll;

import com.orogersilva.rachaconta.taberna.dal.FriendDal;
import com.orogersilva.rachaconta.taberna.model.Friend;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by orogersilva on 12/25/2016.
 */

public class FriendBllTest {

    // region FIELDS

    private FriendBll mFriendBll;

    @Mock
    private FriendDal mFriendDalMock;

    // endregion

    // region SETUP METHODS

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mFriendBll = new FriendBll(mFriendDalMock);
    }

    // endregion

    // region TEST METHODS

    @Test(expected = NullPointerException.class)
    public void addFriend_whenFriendIsNull_throwsNullPointerException() {

        // ARRANGE

        Friend nullFriend = null;

        // ACT / ASSERT

        mFriendBll.addFriend(nullFriend);
    }

    @Test
    public void addFriend_whenFriendIsNotNull_verifyCallToDal() {

        // ARRANGE

        final String NAME = "Roger";
        final double DEBT = 3.95;

        Friend friend = new Friend(NAME, DEBT);

        // ACT

        mFriendBll.addFriend(friend);

        // ASSERT

        verify(mFriendDalMock, times(1)).create(friend);
    }

    @Test
    public void getFriend_whenFriendNameIsNull_returnsNull() {

        // ARRANGE

        final String NULL_FRIEND_NAME = null;

        // ACT

        Friend gottenNullFriend = mFriendBll.getFriend(NULL_FRIEND_NAME);
	//gottenNullFriend = new Friend();
        // ASSERT

       assertNull(gottenNullFriend);
 
    }

    @Test
    public void getFriend_whenFriendNameIsEmpty_returnsNull() {

        // ARRANGE

        final String EMPTY_FRIEND_NAME = "";

        // ACT

        Friend nullFriend = mFriendBll.getFriend(EMPTY_FRIEND_NAME);

        // ASSERT

        assertNull(nullFriend);
    }

    @Test
    public void getFriend_whenFriendNameIsValid_returnsFriend() {

        // ARRANGE

        final String FAILED_TEST_MESSAGE = "Objeto 'Friend' recuperado deve ser igual ao objeto 'Friend' esperado.";
        final String VALID_FRIEND_NAME = "Roger";
        final double FRIEND_DEBT = 34.00;

        Friend expectedFriend = new Friend(VALID_FRIEND_NAME, FRIEND_DEBT);

        when(mFriendDalMock.retrieve(VALID_FRIEND_NAME)).thenReturn(expectedFriend);

        // ACT

        Friend gottenValidFriend = mFriendBll.getFriend(VALID_FRIEND_NAME);

        // ASSERT

        assertEquals(FAILED_TEST_MESSAGE, expectedFriend, gottenValidFriend);
    }

    // endregion
}
