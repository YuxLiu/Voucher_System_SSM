package com.ssm.ob.dao;

import com.ssm.ob.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRecordDao {
    // 如实记录,不可删除,修改,故只有 insert 与 select 方法
    void insert(DealRecord dealRecord);
    // 针对 1 个报销单, 查询其处理流程
    List<DealRecord> selectByClaimVoucher(int cvid);
}
