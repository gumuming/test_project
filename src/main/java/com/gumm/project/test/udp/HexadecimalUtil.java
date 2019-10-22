package com.gumm.project.test.udp;

/**
 * @program: thl
 * @description: 十六进制util
 * @author: JingDe Ran
 * @create: 2019-10-22 17:26
 * @Email: sarakarma49@gmail.com
 */
public class HexadecimalUtil {

    /**
     * 将一个整数将为十六进制字符串
     * @param num
     * @return
     */
    public static String hexadecimal(int num){
        String ox ="";
        int mod;
        while (num != 0) {
            mod = num % 16;
            num = num / 16;
            char chars;
            if (mod >= 9) {
                chars = (char) ('A' + (mod - 10));
            } else {
                chars = (char) ('0' + (mod - 0));
            }
            ox= chars+ox;
        }
        return ox;
    }
}