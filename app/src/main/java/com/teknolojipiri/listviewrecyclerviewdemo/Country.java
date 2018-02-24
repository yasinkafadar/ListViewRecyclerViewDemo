package com.teknolojipiri.listviewrecyclerviewdemo;

/**
 * Created by yasin on 24.02.2018.
 */

public class Country {

    private String code;
    private String name;
    private String dialCode;
    private int flag;

    public Country(String code, String name, String dialCode, int flag) {
        this.code = code;
        this.name = name;
        this.dialCode = dialCode;
        this.flag = flag;
    }

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
