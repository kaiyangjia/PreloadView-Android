package com.jiakaiyang.preloadview.dispatch;

import android.content.Context;
import android.view.View;

import com.jiakaiyang.preloadview.core.Preloader;
import com.jiakaiyang.preloadview.entity.ActivityTask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 管理预加载的activity以及其对应的view tree
 */
public class PreloadActivityManager {
    private Context context;
    private static PreloadActivityManager instance;
    private LinkedList<ActivityTask> taskQueue;
    private Map<String, ActivityTask> preloadedViews;

    private PreloadActivityManager (Context context){
        taskQueue = new LinkedList<>();
        preloadedViews = new HashMap<>();
    }

    public static PreloadActivityManager getInstance(Context context){
        if(instance == null){
            instance = new PreloadActivityManager(context);
        }

        return instance;
    }


    /**
     * 开始预加载一个布局
     * @param activity
     * @param layout
     */
    public void startPreload(String activity, int layout){
        ActivityTask activityTask = new ActivityTask(activity, layout);
        activityTask.start(context);
    }

    /**
     * 根据一个activity的实例取出已经预加载过的对应的view
     * @param activity activity 的名字
     * @return 预加载的view实体，没有预加载的话返回null
     */
    public View getPreloadView(String activity){
        if(!preloadedViews.containsKey(activity)){
            return null;
        }

        try {
            ActivityTask task = preloadedViews.get(activity);
            View view = task.getRootView();
            return view;
        }catch (ClassCastException e){
            return null;
        }
    }
}
