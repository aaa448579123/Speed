package org.phoenix.speed.shiro.util;

import java.util.UUID;

public class CommonUtil {
    /**
     * 生成uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
