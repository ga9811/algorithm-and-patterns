package com.yc.jdbc.domain;

public class User {
    private Integer id;
    private String user_id;
    private String pwd;
    private String name;
    private Integer user_type;

    public User() {
    }

    public User(String user_id, String pwd, Integer user_type) {
        this.user_id = user_id;
        this.pwd = pwd;
        this.user_type = user_type;
    }

    public User(Integer id, String user_id, String pwd, String name, Integer user_type) {
        this.id = id;
        this.user_id = user_id;
        this.pwd = pwd;
        this.name = name;
        this.user_type = user_type;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

