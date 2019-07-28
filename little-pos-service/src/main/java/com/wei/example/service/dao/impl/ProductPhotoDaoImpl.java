/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.ProductPhotoTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.ProductPhotoDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = SpringBootConstants.PRODUCT_PHOTO_DAO)
public class ProductPhotoDaoImpl extends AbstractDao implements ProductPhotoDao {

    @Override
    public List<ProductPhotoTO> findPhotosByProductId(long productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findPhotosByProductId", "start"));
        long startTime = System.currentTimeMillis();
        List<ProductPhotoTO> retList = new ArrayList<>();

        String sql = "SELECT v FROM ProductPhotoTO v WHERE v.pk.productId = :productId ORDER BY v.pk.photoId";
        TypedQuery<ProductPhotoTO> query = entityManager.createQuery(sql, ProductPhotoTO.class);
        query.setParameter("productId", productId);
        List<ProductPhotoTO> resultList = query.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            retList = resultList;
        } else {
            logger.warn("result list is empty.");
        }

        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findPhotosByProductId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findPhotosByProductId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));
        return retList;
    }

    @Override
    public void insertProductPhoto(ProductPhotoTO productPhotoTO) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertProductPhoto", "start"));
        if (productPhotoTO != null) {
            entityManager.persist(productPhotoTO);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertProductPhoto", "finish"));

    }

    @Override
    public int deleteProductPhotoByProductId(long productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductPhotoByProductId", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM ProductPhotoTO v WHERE v.pk.productId = :productId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("productId", productId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductPhotoByProductId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductPhotoByProductId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
