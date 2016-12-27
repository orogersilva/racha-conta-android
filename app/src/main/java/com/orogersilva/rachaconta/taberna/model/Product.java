package com.orogersilva.rachaconta.taberna.model;

import io.realm.annotations.PrimaryKey;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class Product {

    // region FIELDS

    @PrimaryKey
    private String name;

    // endregion

    // region CONSTRUCTORS

    public Product(String name) {

        this.name = name;
    }

    // endregion

    // region GETTERS AND SETTERS

    public String getName() {

        return name;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return (name != null && product.getName() != null && name.equals(product.getName()));
    }

    // endregion
}
