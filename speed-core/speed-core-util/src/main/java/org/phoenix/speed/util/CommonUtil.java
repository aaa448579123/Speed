package org.phoenix.speed.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class CommonUtil {
    /**
     * 生成
     * @return
     */
    public static String createId(){
        Snowflake snowflake = IdUtil.createSnowflake(2,1);
        return snowflake.nextIdStr();
    }
}
