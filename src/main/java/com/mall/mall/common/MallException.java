/**
 * Copyright (C), 2020-2020
 * FileName: MallException
 * Author:   Kingsman
 * Date:     2020/6/8 2:12
 * Description:
 */

package com.mall.mall.common;

public class MallException extends RuntimeException {

    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     * @param message
     */
    public static void fail(String message) {
        throw new MallException(message);
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