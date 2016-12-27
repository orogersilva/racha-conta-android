package com.orogersilva.rachaconta.taberna.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by orogersilva on 12/25/2016.
 */

public class Friend extends RealmObject {

    // region FIELDS

    @PrimaryKey
    private String name;
    private double debt;

    // endregion

    // region CONSTRUCTORS

    public Friend() {}

    public Friend(String name, double debt) {

        this.name = name;
        this.debt = debt;
    }

    // endregion

    // region GETTERS AND SETTERS

    public String getName() {

        return name;
    }

    public double getDebt() {

        return debt;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        final double PRECISION = 0.01;

        return (name != null && friend.getName() != null && name.equals(friend.getName())) &&
                Math.abs(debt - friend.getDebt()) < PRECISION;
    }

    // endregion
}
