package com.jiakaiyang.preloadview.entity;

import android.view.View;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 预加载任务的实体类
 */
public class BaseTask {
    public static final int STATUS_NOT_START = 0;

    public static final int STATUS_EXECUTING = 1;

    public static final int STATUS_COMPLETE = 2;

    public static final int STATUS_ERROR = 3;

    private int status;


    //需要加载的布局依赖的场景的类名，可以是一个activity或者是fragment的名字，必须是唯一的
    private String hostName;
    //一个任务需要加载的布局文件
    private int layout = -1;
    //加载的view树的跟view
    private View rootView;

    private OnStatusChangedListener onStatusChangedListener;


    public BaseTask(String hostName, int layout) {
        this.hostName = hostName;
        this.layout = layout;
    }

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


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(17, 37).
                append(getHostName()).
                append(getLayout()).
                toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ActivityTask rhs = (ActivityTask) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(getHostName(), rhs.getHostName())
                .append(getLayout(), rhs.getLayout())
                .isEquals();
    }
}
