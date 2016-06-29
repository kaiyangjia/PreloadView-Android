package com.jiakaiyang.preloadview.core;

import android.content.Context;

import com.jiakaiyang.preloadview.dispatch.PreloadManager;

/**
 * 使用帮助类，提供面向用户的api供使用者调用该库的所有对外功能
 * 理论上除了该类以外，其他类的功能对使用者都是不可见的。
 * 该类使用单例模式
 */
public class PreloadHelper {
    private Context context;
    private PreloadManager preloadManager;
    private static PreloadHelper instance;

    private PreloadHelper(Context context){
        this.context = context;
        preloadManager = PreloadManager.getInstance(context);
    }

    public PreloadHelper getInstance(Context context){
        if(instance == null){
            instance = new PreloadHelper(context);
        }
        return instance;
    }


    /**
     * 开始进行预加载
     * @param activity 使用预加载的activity名字
     * @param layout
     */
    public void startPreload(String activity, int layout){

    }

    /**
     * 在activity中使用预加载过的view tree
     * @param activity 使用预加载的activity的名字
     * @param obtainTactics 获取策略，为ObtainTactics 的变量值
     * @param layout activity 使用的布局文件
     */
    public void getPreloadView(String activity, int obtainTactics, int layout){
        switch (obtainTactics){
            case ObtainTactics.ALWAYS_LAYOUT:

                break;
            case ObtainTactics.ALWAYS_PRELOAD:

                break;
            case ObtainTactics.PRIORITY_PRELOAD:
            default:

                break;
        }
    }
}
