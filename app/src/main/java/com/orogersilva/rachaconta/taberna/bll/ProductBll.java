package com.orogersilva.rachaconta.taberna.bll;

import com.orogersilva.rachaconta.taberna.dal.ProductDal;
import com.orogersilva.rachaconta.taberna.model.Product;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class ProductBll {

    // region FIELDS

    private ProductDal mProductDal;

    // endregion

    // region CONSTRUCTORS

    public ProductBll(ProductDal productDal) {

        mProductDal = productDal;
    }

    // endregion

    // region PUBLIC METHODS

    public void addProduct(Product product) {

        if (product == null) throw new NullPointerException();

        mProductDal.create(product);
    }

    // endregion
}
