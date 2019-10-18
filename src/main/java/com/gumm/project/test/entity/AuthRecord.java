package com.gumm.project.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: thl
 * @description: 授权记录表
 * @author: JingDe Ran
 * @create: 2019-10-17 17:28
 * @Email: sarakarma49@gmail.com
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_donor_auth_record")
@NameStyle(Style.camelhump)
@org.hibernate.annotations.Table(appliesTo = "t_donor_auth_record", comment = "授权记录表")
@ApiModel("授权记录表")
public class AuthRecord  {

    @Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int COMMENT '主键'")
    private Integer id;

    @Column(name = "CREATE_AT", insertable = false,updatable = false, columnDefinition = "DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP   COMMENT '创建时间'")
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createAt;


    @Column(name = "UPDATE_AT",insertable = false,updatable = false,
            columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间'")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateAt;

    @ApiModelProperty("操作收银员名称")
    @Column(columnDefinition = "varchar(255) comment '操作收银员名称'")
    private String operateCashier;

    @ApiModelProperty("操作收银员名称Id")
    @Column(columnDefinition = "int comment '操作收银员名称Id'")
    private Integer operateCashierId;

    @ApiModelProperty("授权包厢号")
    @Column(columnDefinition = "varchar(255) comment '授权包厢号'")
    private String authBoxNum;

    @ApiModelProperty("授权会员姓名")
    @Column(columnDefinition = "varchar(255) comment '授权会员姓名'")
    private String authorName;

    @ApiModelProperty("授权会员Id")
    @Column(columnDefinition = "int comment '授权会员Id'")
    private Integer authorId;

    @ApiModelProperty("授权总金额")
    @Column(columnDefinition = "decimal(19) comment '授权总金额'")
    private BigDecimal authTotalCount;

    @ApiModelProperty(value = "是否删除",hidden = true)
    @Column(name = "is_delete",columnDefinition = "tinyint comment '是否删除 0 未删除 1 已删除'")
    private Integer delete =0;

    @ApiModelProperty("授权商品不能为空,以,分隔")
    @NotEmpty(message = "授权商品不能为空,以,分隔")
    @Column(columnDefinition = "varchar(255) comment '授权商品Id'")
    private String authProductIds;



}