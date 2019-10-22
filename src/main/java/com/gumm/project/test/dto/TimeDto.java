package com.gumm.project.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @program: test_project
 * @description: 时间参数
 * @author: JingDe Ran
 * @create: 2019-10-22 10:12
 * @Email: sarakarma49@gmail.com
 */
@ApiModel("时间参数")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeDto {

    @ApiModelProperty("localDateTime")
    private LocalDateTime localDateTime;

    @ApiModelProperty("localDate")
    private LocalDate localDate;

    @ApiModelProperty("localTime")
    private LocalTime localTime;

    public static void main(String[] args) {


            int mun = 192;

            String s = "";
            int shang = mun;
            int yu;
            while (shang != 0) {
                yu = shang % 16;
                shang = shang / 16;
                // *************
                char result;
                if (yu >= 9) {
                    result = (char) ('A' + (yu - 10));
                } else {
                    result = (char) ('0' + (yu - 0));
                }
                // *************
                s = result + s;
            }
            System.out.println(mun + "的十六进制是：" + s);


    }
}