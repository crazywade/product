package com.hcnay.product.dao;

import com.hcnay.product.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;


/**** imports ****/
@Mapper
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}