package net.sppan.base.util;

public enum LoginType {
    USER("User"), CUSTOMER("Customer");

    private String type;    //定义的是登陆的类型

    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}

