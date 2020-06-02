package com.quan.Enum;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/22
 */
public enum CommodityStatus {

    Normal(1, "正常"),
    Draft(2, "草稿"),
    OffShelf(3, "下架"),
    Violation(4, "违规");

    Byte key;
    String value;

    CommodityStatus(int key, String value) {
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
