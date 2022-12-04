package com.jr.biz;

import com.jr.entry.Instituty;

import java.util.List;

public interface IInstitutyBiz {
    /*
    *获取所有金融机构名称
    * */
    public List<Instituty> getAllNames();
    /*
    根据金融机构的名字查id
     */
    public  Instituty quaryIdByname(Instituty instituty);
}
