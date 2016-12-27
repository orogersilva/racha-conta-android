package com.orogersilva.rachaconta.taberna;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.orogersilva.rachaconta.taberna.activities.DeskActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by orogersilva on 12/26/2016.
 */

@MediumTest
@RunWith(AndroidJUnit4.class)
public class UC1_AdicionarAmigos {

    // region FIELDS

    @Rule
    public ActivityTestRule<DeskActivity> mDeskActivityRule =
            new ActivityTestRule<>(DeskActivity.class);

    // endregion

    // region TEST METHODS

    /**
     * CENÁRIO: Adiciona novo amigo em lista de amigos vazia
     * DADO que não existem amigos ainda
     * QUANDO eu adiciono um novo amigo
     * ENTÃO uma nova linha é mostrada na lista
     */
    @Test
    public void dadoQueNaoExistemAmigosAinda_quandoEuCadastroUmNovoAmigo_entaoEsseAmigoEhAdicionadoNaListaEAListaDeixaDeSerVazia() {

        // ARRANGE

        final String FRIEND_NAME = "Roger";

        // ACT

        onView(withId(R.id.deskfloatingactionbutton)).perform(click());
        onView(withId(R.id.friend_name_edittext)).perform(typeText(FRIEND_NAME));
        onView(withId(R.id.add_friend_button)).perform(click());

        // ASSERT

        onView(withId(R.id.friends_recyclerview)).perform(actionOnItemAtPosition(0, click()));
    }

    // endregion
}
