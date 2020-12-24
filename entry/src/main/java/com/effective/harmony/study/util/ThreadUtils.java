package com.effective.harmony.study.util;

import ohos.app.Context;
import ohos.app.dispatcher.TaskDispatcher;
import ohos.app.dispatcher.task.Revocable;
import ohos.app.dispatcher.task.TaskPriority;

/**
 * 线程管理工作
 * created by yummylau on 2020/12/24
 */
public class ThreadUtils {

    private static TaskDispatcher globalTaskDispatcher;
    private static TaskDispatcher parallelTaskDispatcher;
    private static TaskDispatcher serialTaskDispatcher;

    public static void init(Context context) {
        globalTaskDispatcher = context.getGlobalTaskDispatcher(TaskPriority.DEFAULT);
        parallelTaskDispatcher = context.createParallelTaskDispatcher("并发任务分发器", TaskPriority.DEFAULT);
        serialTaskDispatcher = context.createSerialTaskDispatcher("串行任务分发器", TaskPriority.DEFAULT);
    }

    /**
     * 返回并发分发器
     * @return
     */
    public static TaskDispatcher getParallelTaskDispatcher() {
        return parallelTaskDispatcher;
    }

    public static TaskDispatcher getUiTaskDispatcher(Context context) {
        return context.getUITaskDispatcher();
    }

    public static TaskDispatcher getMainTaskDispatcher(Context context) {
        return context.getMainTaskDispatcher();
    }

    public static void sync(Runnable runnable) {
        globalTaskDispatcher.syncDispatch(runnable);
    }

    public static Revocable async(Runnable runnable) {
        return globalTaskDispatcher.asyncDispatch(runnable);
    }

    public static Revocable delay(Runnable runnable, long delayTime) {
        return globalTaskDispatcher.delayDispatch(runnable, delayTime);
    }

}
