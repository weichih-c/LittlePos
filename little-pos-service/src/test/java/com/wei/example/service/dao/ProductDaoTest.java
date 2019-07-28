package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.ProductTO;
import com.wei.example.service.dao.intf.ProductDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ProductDaoTest extends DaoTest {
    private ProductDao dao;

    /**
     * Before each test method running.
     */
    @Before
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.PRODUCT_DAO, ProductDao.class);
    }

    /**
     * After each test  method running.
     */
    @After
    public void setDown() {
        dao = null;
    }

    @Test
    public void testInsert() {
        ProductTO product = new ProductTO();
        product.setProductId(-1);
        product.setName("TEST");
        product.setCreateDate(new Date());
        product.setCreateUser("");
        product.setUpdateDate(new Date());
        product.setUpdateUser("");
        dao.insertProduct(product);
        List<ProductTO> productList = dao.findAll();
        logger.debug("product count: " + productList.size());
        ProductTO prodMinus1 = dao.findById(-1);
        Assert.assertNotNull(prodMinus1);
        Assert.assertEquals(1, dao.deleteProductById(-1));
    }

}
