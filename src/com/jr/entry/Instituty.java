package com.jr.entry;
//金融机构表
public class Instituty {
    private int id;//金融机构id
    private String name;//金融机构名称

    public Instituty() {
    }

    public Instituty(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Instituty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
