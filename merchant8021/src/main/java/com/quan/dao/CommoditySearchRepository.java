package com.quan.dao;

import com.quan.entity.CommoditySearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/8
 */
@Component
public interface CommoditySearchRepository extends ElasticsearchRepository<CommoditySearch, Long> {
//    List<CommoditySearch> findAllByTitleOrName(String title, String name);
    List<CommoditySearch> findAllByTitleLikeAndNameLike(String title, String name);
}
