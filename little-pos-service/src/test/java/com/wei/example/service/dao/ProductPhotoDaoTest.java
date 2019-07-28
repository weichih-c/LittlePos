/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.ProductPhotoPK;
import com.wei.example.common.to.ProductPhotoTO;
import com.wei.example.service.dao.intf.ProductPhotoDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ProductPhotoDaoTest extends DaoTest {
    private ProductPhotoDao dao;

    @Override
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.PRODUCT_PHOTO_DAO, ProductPhotoDao.class);
    }

    @Override
    public void setDown() {
        dao = null;
    }

    @Test
    public void testCRUD() {
        long productId = -1;
        Assert.assertTrue(dao.findPhotosByProductId(productId).isEmpty());
        ProductPhotoTO photoTO = new ProductPhotoTO();
        ProductPhotoPK photoPK = new ProductPhotoPK();
        photoPK.setPhotoId(1L);
        photoPK.setProductId(productId);
        photoTO.setPk(photoPK);
        photoTO.setCreateDate(new Date());
        photoTO.setUpdateDate(new Date());
        photoTO.setCreateUser("TEST_MAN");
        photoTO.setUpdateUser("TEST_MAN");
        photoTO.setPhotoPath("/test/path");

        dao.insertProductPhoto(photoTO);
        List<ProductPhotoTO> photoList = dao.findPhotosByProductId(productId);
        Assert.assertTrue(photoList.size() > 0);

        Assert.assertEquals(1, dao.deleteProductPhotoByProductId(productId));
    }
}
