package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.ProductTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.ProductDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = SpringBootConstants.PRODUCT_DAO)
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    public List<ProductTO> findAll() {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "FindAll", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "SELECT v FROM ProductTO v ";
        TypedQuery<ProductTO> query = entityManager.createQuery(sql, ProductTO.class);

        List<ProductTO> retList = new ArrayList<>();
        List<ProductTO> resultList = query.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            retList = resultList;
        } else {
            logger.warn("result list is empty.");
        }

        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "FindAll", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "FindAll",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));
        return retList;
    }

    @Override
    public ProductTO findById(int productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "start"));
        if (productId != 0) {
            logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "finish"));
            return entityManager.find(ProductTO.class, productId);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "finish"));
        return null;
    }


    @Override
    public void insertProduct(ProductTO productTO) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertProduct", "start"));

        if (productTO != null) {
            entityManager.persist(productTO);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertProduct", "finish"));
    }

    @Override
    public int deleteProductById(int productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductById", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM ProductTO v WHERE v.productId = :productId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("productId", productId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductById", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteProductById",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
