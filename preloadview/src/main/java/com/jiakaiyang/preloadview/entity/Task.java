package com.jiakaiyang.preloadview.entity;

import android.content.Context;

/**
 * 预加载任务的实体类
 */
public abstract class Task {
    public static final int STATUS_NOT_START = 0;

    public static final int STATUS_EXECUTING = 1;

    public static final int STATUS_COMPLETE = 2;

    public static final int STATUS_ERROR = 3;

    private int status;
    private OnStatusChangedListener onStatusChangedListener;

    public abstract void start(Context context);

    public OnStatusChangedListener getOnStatusChangedListener() {
        return onStatusChangedListener;
    }

    public void setOnStatusChangedListener(OnStatusChangedListener onStatusChangedListener) {
        this.onStatusChangedListener = onStatusChangedListener;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public interface OnStatusChangedListener{
        public void onStatusChanged(int currentStatus);
    }
}
