package com.gumm.project.test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;

/**
 * @program: thl
 * @description: 授权人商品关联
 * @author: JingDe Ran
 * @create: 2019-10-17 17:24
 * @Email: sarakarma49@gmail.com
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "授权人商品关联")
@NameStyle(Style.camelhump)
@Table(name = "t_donor_author_goods")
@org.hibernate.annotations.Table(appliesTo = "t_donor_author_goods", comment = "授权人商品关联")
public class AuthorGoods {

    @Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int COMMENT '主键'")
    private Integer id;


    @ApiModelProperty("授权人Id")
    @Column(columnDefinition = "int comment'授权人Id' ")
    private Integer authorId;

    @ApiModelProperty("商品id")
    @Column(columnDefinition = "int  comment'商品id ' ")
    private Integer goodsId;

}