package com.ssm.ob.controller;

import com.ssm.ob.biz.ClaimVoucherBiz;
import com.ssm.ob.dto.ClaimVoucherInfo;
import com.ssm.ob.entity.Employee;
import com.ssm.ob.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class ClaimVoucherController {

    private ClaimVoucherBiz claimVoucherBiz;

    @Autowired
    public ClaimVoucherController(ClaimVoucherBiz claimVoucherBiz) {
        this.claimVoucherBiz = claimVoucherBiz;
    }

    public String toAdd(Map<String, Object> map) {
        map.put("items", Constant.getItems());
        map.put("info", new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    public String add(HttpSession session, ClaimVoucherInfo info) {
        Employee employee = (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(info.getClaimVoucher(), info.getItems());
        return "redirect:detail";
    }

}
