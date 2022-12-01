package com.jr.entry;
//企业表对应的实体类
public class Enterprise {

    private int id;//企业id
    private String name;//企业名称
    private String socialUniformCcode;//社会统一代码
    private String email;//邮箱
    private String phone;//企业电话
    private String address;//企业注册详细地址
    private String scale;//企业规模
    private String fax;//传真

    public Enterprise() {
    }

    public Enterprise(int id, String name, String socialUniformCcode, String email, String phone, String address, String scale, String fax) {
        this.id = id;
        this.name = name;
        this.socialUniformCcode = socialUniformCcode;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.scale = scale;
        this.fax = fax;
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

    public String getSocialUniformCcode() {
        return socialUniformCcode;
    }

    public void setSocialUniformCcode(String socialUniformCcode) {
        this.socialUniformCcode = socialUniformCcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", socialUniformCcode='" + socialUniformCcode + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", scale='" + scale + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
