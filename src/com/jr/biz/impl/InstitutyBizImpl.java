package com.jr.biz.impl;

import com.jr.biz.IInstitutyBiz;
import com.jr.dao.impl.InstitutyDaoImpl;
import com.jr.entry.Instituty;

import java.util.List;

public class InstitutyBizImpl implements IInstitutyBiz {
    InstitutyDaoImpl institutyDao=new InstitutyDaoImpl();
    /*
     *获取所有金融机构名称
     * */
    @Override
    public List<Instituty> getAllNames() {
        return institutyDao.queryAllNames();
    }

    @Override
    public Instituty quaryIdByname(Instituty instituty) {
        return institutyDao.quaryIdByname(instituty);
    }
}
