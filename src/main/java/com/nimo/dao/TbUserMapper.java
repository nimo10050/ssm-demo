package com.nimo.dao;

import com.nimo.entity.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKeyWithBLOBs(TbUser record);

    int updateByPrimaryKey(TbUser record);

    List<TbUser> selectUserList();
}