package com.gumm.project.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gumm.project.test.entity.basic.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.sql.Insert;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @program: thl
 * @description: 赠送中心 授权人
 * @author: JingDe Ran
 * @create: 2019-10-17 17:06
 * @Email: sarakarma49@gmail.com
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_donor_author")
@NameStyle(Style.camelhump)
@org.hibernate.annotations.Table(appliesTo = "t_donor_author", comment = "赠送中心 授权人")
@ApiModel("赠送中心 授权人")
public class AuthorDonor extends BaseEntity {

    @ApiModelProperty("授权人姓名")
    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '授权人姓名'")
    @NotBlank(groups = {Insert.class}, message = "授权人姓名不能为空")
    private String authName;

    @ApiModelProperty("授权人id")
    @Column(columnDefinition = "int NOT NULL COMMENT '授权人id'")
    @NotBlank(groups = {Insert.class}, message = "授权人id不能为空")
    private Integer authId;

    @ApiModelProperty("授权密码")
    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '授权密码'")
    @NotBlank(groups = {Insert.class}, message = "授权密码不能为空")
    private String authPassWord;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '授权人职位'")
    @NotBlank(groups = {Insert.class}, message = "授权人职位不能为空")
    @ApiModelProperty("授权人职位")
    private String authPosition;

    @Column(columnDefinition = "decimal(19) NOT NULL COMMENT '每月授权额'")
    @ApiModelProperty("每月授权额")
    @NotBlank(groups = {Insert.class}, message = "每月授权额不能为空")
    private BigDecimal authMonthCount ;

    @Column(columnDefinition = "decimal(19) COMMENT '已授权额'")
    @ApiModelProperty("已授权额")
    private BigDecimal authorizedCount;

}