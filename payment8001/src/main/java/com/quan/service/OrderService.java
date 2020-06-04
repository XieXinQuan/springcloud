package com.quan.service;

import com.quan.Enum.CommonByteEnum;
import com.quan.Enum.ResultEnum;
import com.quan.dao.CommodityRepository;
import com.quan.dao.ShopCarRepository;
import com.quan.dao.TOrderRepository;
import com.quan.entity.Commodity;
import com.quan.entity.ShopCar;
import com.quan.entity.TOrder;
import com.quan.exception.GlobalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/23
 */
@Service
public class OrderService extends BaseService{
    @Resource
    ShopCarRepository shopCarRepository;
    @Resource
    TOrderRepository orderRepository;
    @Resource
    CommodityRepository commodityRepository;

    public Integer addShopCar(Long commodityId, Integer num){

        Integer count = shopCarRepository.countByUserIdAndCommodityIdAndStatus(getCurrentUserId(), commodityId, CommonByteEnum.Normal.getKey());
        if (count > 0) throw new GlobalException(ResultEnum.CustomException.getKey(), "您已经添加过了.");


        ShopCar shopCar = new ShopCar();
        shopCar.setUserId(getCurrentUserId());
        shopCar.setCommodityId(commodityId);
        shopCar.setNum(num);
        shopCar.setStatus(CommonByteEnum.Normal.getKey());

        shopCarRepository.save(shopCar);
        return shopCarRepository.countByUserIdAndStatus(getCurrentUserId(), CommonByteEnum.Normal.getKey());
    }
    public Integer getShopCarNum(){
        Integer count = shopCarRepository.countByUserIdAndStatus(getCurrentUserId(), CommonByteEnum.Normal.getKey());
        return count;
    }

    public List<Map<String, Object>> getMyShopCarList(){
        List<Map<String, Object>> myShopCarList = shopCarRepository.getMyShopCarList(getCurrentUserId());
        return myShopCarList;
    }

    /**
     * commodityId 为空 清空购物车
     */
    public void submitOrder(Long commodityId){
        List<Long> commodityIds = new ArrayList<>();
        List<ShopCar> shops = new ArrayList<>();
        if (commodityId == null) {
            shops = shopCarRepository.findAllByUserIdAndStatus(getCurrentUserId(), CommonByteEnum.Normal.getKey());
            commodityIds = new ArrayList<>(shops.size());
            for (ShopCar car : shops) {
                commodityIds.add(car.getCommodityId());
            }
        }else {
            commodityIds.add(commodityId);
        }

        List<TOrder> orders = new ArrayList<>();
        List<Commodity> commodityList = commodityRepository.findByIdIn(commodityIds);

        if (commodityId != null){
            Commodity commodity = commodityRepository.findById(commodityId).get();
            TOrder order = new TOrder(getCurrentUserId(), commodityId, commodity.getPrice(), 1, commodity.getPrice(), 1L, CommonByteEnum.Normal.getKey());
            orders.add(order);
        }else {
            for (ShopCar shopCar : shops) {
                Commodity commodity = commodityList.stream().filter(commodity1 -> shopCar.getCommodityId().equals(commodity1.getId())).collect(Collectors.toList()).get(0);
                TOrder order = new TOrder(getCurrentUserId(), shopCar.getCommodityId(), commodity.getPrice(), shopCar.getNum(), commodity.getPrice().multiply(new BigDecimal(shopCar.getNum())), 1L, CommonByteEnum.Normal.getKey());
                orders.add(order);
            }
        }
        orderRepository.saveAll(orders);
        if (commodityId == null){
            shops.stream().forEach(shopCar -> shopCar.setStatus(Byte.parseByte("3")));
            shopCarRepository.saveAll(shops);
        }

    }


    public void submitOrder(){
        submitOrder(null);
    }

    public List<Map<String, Object>> loadMyOrder(){
        List<Map<String, Object>> list = orderRepository.loadMyOrder(getCurrentUserId());
        return list;
    }


}