package com.gumm.project.test.udp;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @program: thl
 * @description: udp请求数据分析
 * @author: JingDe Ran
 * @create: 2019-10-22 16:44
 * @Email: sarakarma49@gmail.com
 */
public class DataUtils {
    public static byte[] wrapUdpData(String head, String body) {

        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String res = "0x010x02";
        String ip = "192.168.2.230";
        String[] split = ip.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        Arrays.stream(split).forEach(s -> stringBuffer.append(HexadecimalUtil.hexadecimal(Integer.parseInt(s))));
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.length());
    }


}