package com.hcnay.product.service;

import com.hcnay.product.pojo.PurchaseRecordPo;

import java.util.List;

public interface PurchaseService {

    /**0-
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 购买数量
     * @return 成功或失败
     */
    public boolean purchase(Long userId,Long productId,int quantity);

}
