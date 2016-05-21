package com.jiakaiyang.preloadview.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 核心的工作类，对布局文件进行加载
 */
public class Preloader {

    public View load(int layout, Context context){
        View contentView = LayoutInflater.from(context).inflate(layout, null);
        return contentView;
    }
}
