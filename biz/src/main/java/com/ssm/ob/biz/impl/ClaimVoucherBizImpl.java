package com.ssm.ob.biz.impl;

import com.ssm.ob.biz.ClaimVoucherBiz;
import com.ssm.ob.dao.ClaimVoucherDao;
import com.ssm.ob.dao.ClaimVoucherItemDao;
import com.ssm.ob.dao.DealRecordDao;
import com.ssm.ob.entity.ClaimVoucher;
import com.ssm.ob.entity.ClaimVoucherItem;
import com.ssm.ob.entity.DealRecord;
import com.ssm.ob.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

    private ClaimVoucherDao claimVoucherDao;
    private ClaimVoucherItemDao claimVoucherItemDao;
    private DealRecordDao dealRecordDao;

    @Autowired
    public ClaimVoucherBizImpl(ClaimVoucherDao claimVoucherDao,
                               ClaimVoucherItemDao claimVoucherItemDao, DealRecordDao dealRecordDao) {
        this.claimVoucherDao = claimVoucherDao;
        this.claimVoucherItemDao = claimVoucherItemDao;
        this.dealRecordDao = dealRecordDao;
    }

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {

        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Constant.CLAIMVOUCHER_CREATED);

        claimVoucherDao.insert(claimVoucher);

        for (ClaimVoucherItem item : items) {
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }
}
