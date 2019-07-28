package com.wei.example.common.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Products")
public class ProductTO implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @Column(name = "ProductId")
    private Integer productId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Descrpt")
    private String descrpt;

    @Column(name = "Price")
    private Long price;

    @Column(name = "TotalStock")
    private Long totalStock;

    @Column(name = "ResrvStock")
    private Long resrvStock;

    @Column(name = "IdleStock")
    private Long idleStock;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateUser")
    private String createUser;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "UpdateUser")
    private String updateUser;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrpt() {
        return descrpt;
    }

    public void setDescrpt(String descrpt) {
        this.descrpt = descrpt;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }

    public Long getResrvStock() {
        return resrvStock;
    }

    public void setResrvStock(Long resrvStock) {
        this.resrvStock = resrvStock;
    }

    public Long getIdleStock() {
        return idleStock;
    }

    public void setIdleStock(Long idleStock) {
        this.idleStock = idleStock;
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
        return "ProductTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", descrpt='" + descrpt + '\'' +
                ", price=" + price +
                ", totalStock=" + totalStock +
                ", resrvStock=" + resrvStock +
                ", idleStock=" + idleStock +
                '}';
    }
}
