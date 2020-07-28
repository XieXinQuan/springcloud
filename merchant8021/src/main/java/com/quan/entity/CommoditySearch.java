package com.quan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/8
 */
@Data
@Document(indexName = "commodity", type = "docs", shards = 1, replicas = 0)
@AllArgsConstructor
@NoArgsConstructor
public class CommoditySearch {
    /**
     * @ID 注解必须是springframework包下的
     * org.springframework.data.annotation.Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(type = FieldType.Long, store = true)
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String title;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String name;

    @Field(type = FieldType.Byte, store = true)
    private Byte category;

    @Field(type = FieldType.Double, store = true)
    private BigDecimal price;

    @Field(type = FieldType.Byte, store = true)
    private Byte status;

    @Field(type = FieldType.Text, store = true)
    private String imageUrl;

    @Field(type = FieldType.Long, store = true)
    private Long shopId;

}
