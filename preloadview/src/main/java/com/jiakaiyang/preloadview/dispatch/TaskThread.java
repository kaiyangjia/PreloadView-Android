package com.jiakaiyang.preloadview.dispatch;

/**
 * Created by admin on 2016/5/21.
 */
public class TaskThread extends Thread{
    private TaskLooper taskLooper;

    public TaskLooper getTaskLooper() {
        return taskLooper;
    }

    public void setTaskLooper(TaskLooper taskLooper) {
        this.taskLooper = taskLooper;
    }
}
