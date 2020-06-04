package com.quan.Enum;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
public enum  EmailType {
    Normal(1, "下单"),
    Unavailable(2, "发货");

    Byte key;
    String value;

    EmailType(int key, String value) {
        this.key = (byte)(key & 0xFF);
        this.value = value;
    }

    public Byte getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
