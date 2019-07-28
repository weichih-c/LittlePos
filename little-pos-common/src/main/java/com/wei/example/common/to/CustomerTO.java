/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Customers")
public class CustomerTO implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @Column(name = "CustomerId")
    private Long customerId;

    @Column(name = "CorpName")
    private String corpName;

    @Column(name = "Descrpt")
    private String descrpt;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email")
    private String email;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Contactor")
    private String contactor;

    @Column(name = "LatestOrderTime")
    private Date latestOrderTime;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "UpdateUser")
    private String updateUser;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getDescrpt() {
        return descrpt;
    }

    public void setDescrpt(String descrpt) {
        this.descrpt = descrpt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public Date getLatestOrderTime() {
        return latestOrderTime;
    }

    public void setLatestOrderTime(Date latestOrderTime) {
        this.latestOrderTime = latestOrderTime;
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
        return "CustomerTO{" +
                "customerId=" + customerId +
                ", corpName='" + corpName + '\'' +
                ", descrpt='" + descrpt + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", contactor='" + contactor + '\'' +
                ", latestOrderTime=" + latestOrderTime +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
