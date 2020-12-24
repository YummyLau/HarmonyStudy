package com.effective.harmony.study.util;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * 基于鸿蒙 HiLog 日志系统功能
 * created by yummylau on 2020/12/24
 */
public class LogUtils {

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "Study");

    public static void debug(String format, Object... args) {
        HiLog.debug(label, format, args);
    }

    public static void info(String format, Object... args) {
        HiLog.info(label, format, args);
    }

    public static void warn(String format, Object... args) {
        HiLog.warn(label, format, args);
    }

    public static void error(String format, Object... args) {
        HiLog.error(label, format, args);
    }

    public static void fatal(String format, Object... args) {
        HiLog.fatal(label, format, args);
    }
}
