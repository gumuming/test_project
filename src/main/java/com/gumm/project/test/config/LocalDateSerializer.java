package com.gumm.project.test.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
*LocalDate 序列化成时间戳
*@author: Sara Karma
*@date: 2019/10/22
*/
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    public static final LocalDateSerializer INSTANCE;

    static {
        INSTANCE = new LocalDateSerializer();
    }

    private LocalDateSerializer() {
    }

    /**
     * 当前时区偏移量
     */
    private static final ZoneOffset CURRENT_ZONE_OFFSET = ZoneOffset.ofHours(8);

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //序列化为毫秒时间戳
        jsonGenerator.writeNumber(localDate.atStartOfDay(CURRENT_ZONE_OFFSET).toInstant().toEpochMilli());
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.atStartOfDay(CURRENT_ZONE_OFFSET).toInstant().toEpochMilli());
    }
}