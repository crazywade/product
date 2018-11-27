package com.hcnay.product.service.impl;

import com.hcnay.product.dao.ProductDao;
import com.hcnay.product.dao.PurchaseRecordDao;
import com.hcnay.product.pojo.ProductPo;
import com.hcnay.product.pojo.PurchaseRecordPo;
import com.hcnay.product.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductDao productDao = null;

    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;

    @Override
    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {
        ProductPo product = productDao.getProduct(productId);
        //比较库存和购买数量
        if(product.getStock()<quantity){
            //库存不足
            return false;
        }
        //减少库存
        productDao.decreaseProduct(productId,quantity);
        //初始化信息
        PurchaseRecordPo pr = this.initPurchaseRecord(userId,product,quantity);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(pr);
        return true;
    }

    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }


}
