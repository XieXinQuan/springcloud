package com.quan.config;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/30
 */

public class Shop {
    private Integer num;
    private String name;
    private Shop(){}
    public Shop(Integer num){
        this.name = "default";
        this.num = num;
    }

    public Integer getNum() throws Exception {
        if (num < 0) throw new Exception("商品超卖.");
        return num;
    }


    public void setNum(Integer num) {
        this.num = num;
    }
}
