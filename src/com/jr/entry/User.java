package com.jr.entry;

public class User {
    private int id;//用户主键
    private String name;//用户名
    private String enterPriseId;//企业id
    private String phone;//手机号
    private String account;//账号
    private String password;//密码
    private String idcardName;//身份证姓名
    private String idcardNo;//身份证号码

    public User() {
    }

    public User(int id, String name, String enterPriseId,
                String phone, String account, String password,
                String idcardName, String idcardNo) {
        this.id = id;
        this.name = name;
        this.enterPriseId = enterPriseId;
        this.phone = phone;
        this.account = account;
        this.password = password;
        this.idcardName = idcardName;
        this.idcardNo = idcardNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcardName() {
        return idcardName;
    }

    public void setIdcardName(String idcardName) {
        this.idcardName = idcardName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", idcardName='" + idcardName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                '}';
    }
}
