package com.jr.dao;

import com.jr.entry.Instituty;

import java.util.List;

public interface IInstitutyDao {
    /*
     *查询所有金融机构名称
     * */
    public List<Instituty> queryAllNames();
    /*
   根据金融机构的名字查id
    */
    public  Instituty quaryIdByname(Instituty instituty);
}
