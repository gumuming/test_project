package com.gumm.project.test.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 *文本形式的时间戳,反序列化成LocalDate
 *@author: Sara Karma
 *@date: 2019/10/22
 */
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    public static final LocalTimeDeserializer INSTANCE;

    static {
        INSTANCE = new LocalTimeDeserializer();
    }

    private LocalTimeDeserializer() {
    }

    /**
     * 当前时区偏移量
     */
    private static final ZoneOffset CURRENT_ZONE_OFFSET = ZoneOffset.ofHours(8);

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Instant.ofEpochMilli(Long.valueOf(jsonParser.getText())).atZone(CURRENT_ZONE_OFFSET).toLocalTime();
    }
}