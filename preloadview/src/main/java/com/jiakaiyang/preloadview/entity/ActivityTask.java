package com.jiakaiyang.preloadview.entity;

import android.content.Context;
import android.view.View;

import com.jiakaiyang.preloadview.core.Preloader;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * activity使用的同步的任务
 */
public class ActivityTask extends Task{
    private Preloader preloader;
    private String activiyName;
    private int layout;
    private View rootView;

    public ActivityTask(String activiyName, int layout) {
        this.activiyName = activiyName;
        this.layout = layout;
        preloader = new Preloader();
    }

    @Override
    public void start(Context context) {
        rootView = preloader.load(layout, context);
    }

    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(17, 37).
                append(activiyName).
                append(layout).
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
                .append(activiyName, rhs.activiyName)
                .append(layout, rhs.layout)
                .isEquals();
    }

    public String getActiviyName() {
        return activiyName;
    }

    public void setActiviyName(String activiyName) {
        this.activiyName = activiyName;
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
}
