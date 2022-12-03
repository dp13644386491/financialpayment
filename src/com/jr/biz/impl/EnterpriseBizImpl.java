package com.jr.biz.impl;

import com.jr.biz.IEnterpriseBiz;
import com.jr.dao.impl.EnterpriseDaoImpl;
import com.jr.entry.Enterprise;

import java.util.List;

public class EnterpriseBizImpl implements IEnterpriseBiz {
    EnterpriseDaoImpl edi = new EnterpriseDaoImpl();
    /*
     * 通过id获取企业信息
     * */
    @Override
    public Enterprise getEnterpriseInfo(Enterprise enterprise) {
        return edi.queryByid(enterprise);
    }

    /*
     *获取所有企业名称
     * */
    @Override
    public List<Enterprise> getAllEnterpriseNames() {
        return edi.queryAllEnterpriseNames();
    }
//    //通过企业名称，获取企业id和企业社会信用代码
    @Override
    public Enterprise queryIdAndSocialUniformCodeByEnterpriseName(Enterprise enterprise) {
        return edi.queryIdAndSocialUniformCodeByEnterpriseName(enterprise);
    }

    @Override
    public Enterprise querydeletone(Enterprise enterprise) {
        return edi.querydeletone(enterprise);
    }
}
