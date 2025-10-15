package com.embarkx.firstspring;

public class firstchaelleng {
    private int id;
    private String name;
    private String desc;

    public firstchaelleng(String name, int id, String desc) {
        this.name = name;
        this.id = id;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
