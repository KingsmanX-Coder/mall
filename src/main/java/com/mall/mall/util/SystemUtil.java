/**
 * Copyright (C), 2020-2020
 * FileName: SystemUtil
 * Author:   Kingsman
 * Date:     2020/6/8 4:27
 * Description:
 */

package com.mall.mall.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SystemUtil {

    private SystemUtil() {
    }

    /**
     * 登录或注册成功后,生成保持用户登录状态会话token值
     * @param src:为用户最新一次登录时的now()+user.id+random(4)
     * @return
     */
    public static String genToken(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */