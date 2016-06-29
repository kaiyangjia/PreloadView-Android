package com.jiakaiyang.preloadview.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.google.common.base.Preconditions;
import com.jiakaiyang.preloadview.entity.BaseTask;

/**
 * 核心的工作类，对布局文件进行加载
 */
public class Preloader {
    private Context context;

    public Preloader(Context context) {
        this.context = context;
    }

    /**
     * 基础的加载方法，加载一个布局并返回一个view类对象
     * @param layout
     * @return
     */
    public View load(int layout){
        View contentView = LayoutInflater.from(context).inflate(layout, null);
        return contentView;
    }

    /**
     * 加载一个task到内存中
     * @param baseTask
     */
    public void load(BaseTask baseTask){
        Preconditions.checkNotNull(baseTask);
        Preconditions.checkArgument(baseTask.getLayout() != -1);

        View rootView = load(baseTask.getLayout());
        baseTask.setRootView(rootView);
    }

    /**
     * 获取一个已经被加载过的task
     * @param baseTask
     * @return 返回已经加载过的一个task的rootView，如果该task的view不再内存中，则返回null
     */
    public View getLoaded(BaseTask baseTask){
        Preconditions.checkNotNull(baseTask);
        return baseTask.getRootView();
    }
}
