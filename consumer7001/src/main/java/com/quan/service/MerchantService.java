package com.quan.service;

import com.quan.entity.CommoditySearch;
import com.quan.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/5
 */
@Component
@FeignClient(value = "merchant")
public interface MerchantService {

    @PostMapping("/commodity/addCommodity")
    Result<String> addCommodity(@RequestParam(value = "id", required = false) Long id,
                               @RequestParam("title") String title,
                               @RequestParam("name") String name,
                               @RequestParam("category") Byte category,
                               @RequestParam("stock") Integer stock,
                               @RequestParam("price") BigDecimal price,
                               @RequestParam(value = "sellTime", required = false) Date sellTime,
                               @RequestParam("imageUrl") String imageUrl
    );

    @GetMapping("/commodity/loadCommodityList")
    Result<Object> loadCommodityList();

    @GetMapping("/commodity/categoryList")
    Result<Object> categoryList();

    @GetMapping("/commodity/categoryListMap")
    Result<Object> categoryListMap();

    @GetMapping("/commodity/indexCommodityList")
    Result<Object> indexCommodityList();

    @PostMapping("/commodity/applyCreateCommodityId")
    Result<Object> applyCreateCommodityId();

    @PostMapping("/commodity/getCommodityListByCategory/{key}")
    Result<Object> getCommodityListByCategory(@PathVariable("key") Byte key,
                                             @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                             @RequestParam(value = "pageCount", required = false) Integer pageCount,
                                             @RequestParam(value = "priceOrder", required = false) Integer priceOrder);

    @GetMapping("/commodity/getCommodityDetails/{id}")
    Result<Object> getCommodityDetails(@PathVariable("id") Long id);
    @GetMapping("/commodity/synchronize")
    Result<String> synchronize();

    @GetMapping("/commodity/search/{name}")
    Result<List<CommoditySearch>> getCommoditySearchLike(@PathVariable("name") String name);



    @PostMapping(value = "/file/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<String> image(MultipartFile file, @RequestParam("commodityId") Long commodityId) throws IOException;



    @PostMapping("/order/addShopCar")
    Result<Object> addShopCar(@RequestParam("commodityId") Long commodityId,
                             @RequestParam("num") Integer num);

    /**
     * 获取购物车商品数量
     */
    @GetMapping("/order/getShopCarNum")
    Result<Object> getShopCarNum();

    @GetMapping("/order/loadMyShopCar")
    Result<Object> loadMyShopCar();

    @PostMapping("/order/submitOrder")
    Result<String> submitOrder();

    @GetMapping("/order/loadMyOrder")
    Result<Object> loadMyOrder();

    @PostMapping("/order/buy")
    Result<String> buy(@RequestParam("commodityId") Long commodityId);
}
