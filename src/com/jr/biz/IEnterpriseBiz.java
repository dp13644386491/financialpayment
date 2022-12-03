package com.jr.biz;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseBiz {
    /*
    * 通过id获取企业信息
    * */
    public Enterprise getEnterpriseInfo(Enterprise enterprise);

    /*
    *获取所有企业名称
    * */
    public List<Enterprise> getAllEnterpriseNames();
    //通过企业名称，获取企业id和企业社会信用代码
    public  Enterprise queryIdAndSocialUniformCodeByEnterpriseName(Enterprise enterprise);
    //查询去掉开单企业，查询剩下的所有企业
    public   Enterprise querydeletone(Enterprise enterprise);
}
