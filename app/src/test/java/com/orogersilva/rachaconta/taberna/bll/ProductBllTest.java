package com.orogersilva.rachaconta.taberna.bll;



import com.orogersilva.rachaconta.taberna.dal.ProductDal;
import com.orogersilva.rachaconta.taberna.model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;

/**
 * Created by orogersilva on 12/26/2016.
 */

public class ProductBllTest {

    // region FIELDS

    private ProductBll mProductBll;

    @Mock
    private ProductDal mProductDalMock;

    // endregion

    // region SETUP METHODS

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mProductBll = new ProductBll(mProductDalMock);
    }


    // region TEST METHODS

    @Test
    public void addProduct_whenProductIsNotNull_verifyCallToDal() {

        // ARRANGE

        final String NAME = "Chopp";

        Product product = new Product(NAME);

        // ACT

        mProductBll.addProduct(product);

        // ASSERT

        Mockito.verify(mProductDalMock, times(1)).create(product);
    }

    @Test(expected = NullPointerException.class)
    public void addProduct_whenProductIsNull_throwsNullPointerException() {

        // ARRANGE

        Product nullProduct = null;

        // ACT / ASSERT

        mProductBll.addProduct(nullProduct);
    }

    // endregion
}
