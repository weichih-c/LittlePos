package com.wei.example.service.dao.intf;

import com.wei.example.common.to.ProductTO;

import java.util.List;

public interface ProductDao {
    List<ProductTO> findAll();

    ProductTO findById(int productId);

    void insertProduct(ProductTO productTO);

    int deleteProductById(int productId);
}
