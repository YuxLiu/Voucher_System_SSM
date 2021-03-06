package com.ssm.ob.biz;

import com.ssm.ob.entity.ClaimVoucher;
import com.ssm.ob.entity.ClaimVoucherItem;
import com.ssm.ob.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void edit(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    void submit(int id);

    void deal(DealRecord dealRecord);
}
