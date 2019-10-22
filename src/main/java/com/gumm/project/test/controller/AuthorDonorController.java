package com.gumm.project.test.controller;

import com.gumm.project.test.dto.TimeDto;
import com.gumm.project.test.entity.AuthorDonor;
import com.gumm.project.test.mapper.AuthorDonorMapper;
import com.gumm.project.test.repo.AuthorDonorRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @program: test_project
 * @description: 授权管理测试
 * @author: JingDe Ran
 * @create: 2019-10-18 17:19
 * @Email: sarakarma49@gmail.com
 */
@RestController
@RequestMapping("/pcm/donor/author/record")
@Api(tags = "05-03 赠送中心>>>授权人记录")
public class AuthorDonorController {
    @Resource
    AuthorDonorMapper authorDonorMapper;
    @Resource
    AuthorDonorRepo authorDonorRepo;

    @ApiOperation("mapper 保存")
    @PostMapping("save")
    @ResponseBody
    public String save(@RequestBody AuthorDonor authorDonor){
        authorDonorMapper.insert(authorDonor);
        return "200";
    }
    @ApiOperation("repo 保存")
    @PostMapping("add")
    @ResponseBody
    public String add(@RequestBody AuthorDonor authorDonor){
        authorDonorRepo.save(authorDonor);
        return "200";
    }

    @ApiOperation("localDateTime ")
    @PostMapping("localDateTime")
    @ResponseBody
    public LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }

    @ApiOperation("timeDto ")
    @PostMapping("timeDto")
    @ResponseBody
    public TimeDto timeDto()
    {
        TimeDto build = TimeDto.builder().localDate(LocalDate.now())
                .localDateTime(LocalDateTime.now())
                .localTime(LocalTime.now()).build();
        return build;
    }

    @ApiOperation("unixlocalDateTime ")
    @PostMapping("unixlocalDateTime")
    @ResponseBody
    public String tranceTime(@RequestBody TimeDto timeDto){
        System.out.println(timeDto.getLocalDateTime());
        System.out.println(timeDto.getLocalDate());
        System.out.println(timeDto.getLocalTime());
        return "200";
    }


    public static void main(String[] args) {
        long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
    }



}