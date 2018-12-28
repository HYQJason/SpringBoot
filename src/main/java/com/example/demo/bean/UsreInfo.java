package com.example.demo.bean;

public class UsreInfo {
    private Long account;
    private String username;
    private int age;
    private Integer id;

    public UsreInfo(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public UsreInfo(String username, int age, Integer id, Long account) {
        this.account = account;
        this.username = username;
        this.age = age;
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsreInfo{" +
                "account=" + account +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
