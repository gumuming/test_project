package com.gumm.project.test.entity.basic;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
*@author: Sara Karma
*@date: 2019/10/18
*/
public class UUIdGenId implements GenId<String> {

    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString().replace("-","");
    }
}
