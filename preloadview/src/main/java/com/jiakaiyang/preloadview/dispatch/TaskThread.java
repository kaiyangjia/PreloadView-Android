package com.jiakaiyang.preloadview.dispatch;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.jiakaiyang.preloadview.core.Preloader;
import com.jiakaiyang.preloadview.entity.BaseTask;

/**
 * 异步执行任务的线程
 */
public class TaskThread extends HandlerThread {
    private Handler mHandler;
    private Handler.Callback callback;
    private Preloader preloader;


    public TaskThread(Context context, String name) {
        super(name);
        init(context);
    }

    @Override
    public void run() {
        super.run();
    }

    /**
     * this method must be called before the thread start
     */
    private void init(Context context){
        mHandler = new Handler(getLooper());
        preloader = new Preloader(context);
        callback = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                BaseTask baseTask = (BaseTask) msg.obj;
                preloader.load(baseTask);
                return false;
            }
        };
    }
}
