/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.to;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductPhotoPK implements Serializable {
    private static long serialVersionUID = 1L;

    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "PhotoId")
    private Long photoId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "ProductPhotoPK{" +
                "productId=" + productId +
                ", photoId=" + photoId +
                '}';
    }
}
