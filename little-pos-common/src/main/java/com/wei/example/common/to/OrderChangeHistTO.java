/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.to;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OrderChangeHist")
public class OrderChangeHistTO implements Serializable {
    private static long serialVersionUID = 1L;

    @EmbeddedId
    private OrderChangeHistPK pk;

    @Column(name = "Quantity")
    private Long quantity;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "DeliverDate")
    private Date deliverDate;

    @Column(name = "CustomerId")
    private Long customerId;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "UpdateUser")
    private String updateUser;

    public OrderChangeHistPK getPk() {
        return pk;
    }

    public void setPk(OrderChangeHistPK pk) {
        this.pk = pk;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "OrderChangeHistTO{" +
                "pk=" + pk +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", deliverDate=" + deliverDate +
                ", customerId=" + customerId +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
