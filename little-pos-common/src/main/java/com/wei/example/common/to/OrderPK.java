/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.to;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderPK implements Serializable {

    private static long serialVersionUID = 1L;

    @Column(name = "OrderId")
    private String orderId;

    @Column(name = "ProductId")
    private Long productId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderPK{" +
                "orderId='" + orderId + '\'' +
                ", productId=" + productId +
                '}';
    }
}
