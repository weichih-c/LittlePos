/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.util;

public class LogMsgUtil {
    public static String genMethodLogMsg(String classPrefix, String methodName, String message) {
        return new StringBuilder(classPrefix).append(" - ")
                .append(methodName).append(" >> ")
                .append(message).toString();
    }
}
