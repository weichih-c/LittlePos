/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.intf;

import com.wei.example.common.to.ProductPhotoTO;

import java.util.List;

public interface ProductPhotoDao {
    List<ProductPhotoTO> findPhotosByProductId(long productId);

    void insertProductPhoto(ProductPhotoTO productPhotoTO);

    int deleteProductPhotoByProductId(long productId);
}
