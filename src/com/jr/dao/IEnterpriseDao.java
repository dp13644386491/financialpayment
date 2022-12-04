package com.jr.dao;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseDao {
    /*
     * 根据企业id查询企业信息
     * */
    public Enterprise queryByid(Enterprise enterprise);

    /*
     *查询所有企业名称
     * */
    public List<Enterprise> queryAllEnterpriseNames();

    /**
     * 根据企业名称查询企业id和社会统一代码
     */
    public Enterprise queryIdAndSocialUniformCodeByEnterpriseName(Enterprise enterprise);
}
