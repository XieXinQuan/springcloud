package com.quan.controller;

import com.quan.Enum.CommodityCategoryEnum;
import com.quan.annotation.EnumValue;
import com.quan.annotation.SimpleValue;
import com.quan.entity.CommoditySearch;
import com.quan.entity.Result;
import com.quan.service.MerchantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/7
 */
@RestController
public class MerchantController {
    @Resource
    MerchantService merchantService;



    @PostMapping("/commodity/addCommodity")
    public String addCommodity(@RequestParam(value = "id", required = false) Long id,
                               @RequestParam("title") @Size(min = 1, max = 20, message = "商品标题的长度在1~20之间.") String title,
                               @RequestParam("name") @Size(min = 1, max = 20, message = "商品名称的长度在1~20之间.") String name,
                               @RequestParam("category") @EnumValue(value = CommodityCategoryEnum.class, message = "不存在该商品分类") Byte category,
                               @RequestParam("stock") @NotNull(message = "库存不能为空") @Min(value = 1, message = "库存不得小于1.") @Max(value = Integer.MAX_VALUE, message = "库存不得超过2147483647") Integer stock,
                               @RequestParam("price") @NotNull(message = "单价不能为空") @DecimalMax(value = "9999.99", message = "单价不得超过￥9999.99元") @DecimalMin(value = "0.01", message = "商品单价不得少于￥0.01元") BigDecimal price,
                               @RequestParam(value = "sellTime", required = false)  Date sellTime,
                               @RequestParam("imageUrl") String imageUrl
    ){
        Result<String> result = merchantService.addCommodity(id, title, name, category, stock, price, sellTime, imageUrl);
        return result.getData();
    }

    @GetMapping("/commodity/loadCommodityList")
    public Object loadCommodityList(){
        Result<Object> result = merchantService.loadCommodityList();
        return result.getData();
    }

    @GetMapping("/commodity/categoryList")
    public Object categoryList(){
        Result<Object> result = merchantService.categoryList();
        return result.getData();
    }

    @GetMapping("/commodity/categoryListMap")
    public Object categoryListMap(){

        Result<Object> result = merchantService.categoryListMap();
        return result.getData();
    }

    @GetMapping("/commodity/indexCommodityList")
    public Object indexCommodityList(){
        Result<Object> result = merchantService.indexCommodityList();
        return result.getData();
    }

    @PostMapping("/commodity/applyCreateCommodityId")
    public Object applyCreateCommodityId(){
        Result<Object> result = merchantService.applyCreateCommodityId();
        return result.getData();
    }

    @PostMapping("/commodity/getCommodityListByCategory/{key}")
    public Object getCommodityListByCategory(@PathVariable("key") Byte key,
                                             @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                             @RequestParam(value = "pageCount", required = false) Integer pageCount,
                                             @RequestParam(value = "priceOrder", required = false) @SimpleValue({0, 1, 2}) Integer priceOrder){

        Result<Object> result = merchantService.getCommodityListByCategory(key, pageIndex, pageCount, priceOrder);
        return result.getData();
    }

    @GetMapping("/commodity/getCommodityDetails/{id}")
    public Object getCommodityDetails(@PathVariable("id") Long id){
        Result<Object> result = merchantService.getCommodityDetails(id);
        return result.getData();
    }
    @GetMapping("/synchronize")
    public Object synchronize(){
        Result<String> result = merchantService.synchronize();
        return result.getData();
    }
    @GetMapping("/search/{name}")
    public Object getCommoditySearchLike(@PathVariable("name") String name){
        Result<List<CommoditySearch>> commoditySearchLike = merchantService.getCommoditySearchLike(name);
        return commoditySearchLike.getData();
    }


    @PostMapping("/file/image")
    public String image(MultipartFile file, @RequestParam("commodityId") Long commodityId) throws IOException {
        Result<String> result = merchantService.image(file, commodityId);
        return result.getData();
    }


    
    @PostMapping("/order/addShopCar")
    public Object addShopCar(@RequestParam("commodityId") Long commodityId,
                             @RequestParam("num") Integer num){
        Result<Object> result = merchantService.addShopCar(commodityId, num);
        return result.getData();
    }

    /**
     * 获取购物车商品数量
     */
    @GetMapping("/order/getShopCarNum")
    public Object getShopCarNum(){
        Result<Object> result = merchantService.getShopCarNum();
        return result.getData();
    }

    @GetMapping("/order/loadMyShopCar")
    public Object loadMyShopCar(){
        Result<Object> result = merchantService.loadMyShopCar();
        return result.getData();
    }

    @PostMapping("/order/submitOrder")
    public String submitOrder(){
        Result<String> result = merchantService.submitOrder();
        return result.getData();
    }

    @GetMapping("/order/loadMyOrder")
    public Object loadMyOrder(){
        Result<Object> result = merchantService.loadMyOrder();
        return result.getData();
    }

    @PostMapping("/order/buy")
    public String buy(@RequestParam("commodityId") Long commodityId){
        Result<String> result = merchantService.buy(commodityId);
        return result.getData();
    }

}
