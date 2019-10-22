package com.gumm.project.test.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sun.jmx.snmp.Timestamp;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;


/**
*LocalDate 序列化成时间戳
*@author: Sara Karma
*@date: 2019/10/22
*/
public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

    public static final LocalTimeSerializer INSTANCE;

    static {
        INSTANCE = new LocalTimeSerializer();
    }

    private LocalTimeSerializer() {
    }

    /**
     * 当前时区偏移量
     */
    private static final ZoneOffset CURRENT_ZONE_OFFSET = ZoneOffset.ofHours(8);

    @Override
    public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //序列化为毫秒时间戳
        jsonGenerator.writeNumber(localTime.atOffset(CURRENT_ZONE_OFFSET).getLong(ChronoField.INSTANT_SECONDS));
    }

    public static void main(String[] args) {
    }
}