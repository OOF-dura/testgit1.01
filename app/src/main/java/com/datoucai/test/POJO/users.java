package com.datoucai.test.POJO;

import cn.bmob.v3.BmobObject;

/**
 * Created by frankdura on 2017/7/21.
 */

public class users extends BmobObject {
    private Integer id;
    private String password;
    private String username;

    public users() {
        setTableName("users");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
