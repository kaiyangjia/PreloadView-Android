package com.jiakaiyang.preloadview.dispatch;

import com.jiakaiyang.preloadview.entity.Task;

import java.util.LinkedList;

/**
 * 任务looper，自定义实现，和android的Lopper没有关系
 */
public class TaskLooper  {
    private LinkedList<Task> taskQueue;
    private boolean isStoped = false;

    public void loop(){
        while(!isStoped
                && taskQueue.size() > 0){
            Task task = taskQueue.element();
            task.start();
        }
    }

    public boolean isStoped() {
        return isStoped;
    }

    public void setStoped(boolean stoped) {
        isStoped = stoped;
    }

    public LinkedList getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(LinkedList taskQueue) {
        this.taskQueue = taskQueue;
    }
}
