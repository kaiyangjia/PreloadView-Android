package com.jiakaiyang.preloadview.dispatch;

import android.content.Context;
import android.view.View;

import com.jiakaiyang.preloadview.core.Preloader;
import com.jiakaiyang.preloadview.entity.BaseTask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 管理预加载的activity以及其对应的view tree
 */
public class PreloadManager {
    private Context context;
    private static PreloadManager instance;

    //正在排队等候被加载的任务队列
    private LinkedList<BaseTask> taskQueue;
    private Map<String, BaseTask> preloadedViews;

    //负责加载view的worker
    private Preloader preloader;

    private PreloadManager(Context context){
        taskQueue = new LinkedList<>();
        preloadedViews = new HashMap<>();
        preloader = new Preloader(context);
    }

    public static PreloadManager getInstance(Context context){
        if(instance == null){
            instance = new PreloadManager(context);
        }

        return instance;
    }


    /**
     * 预加载一个界面的view
     * @param hostName 布局所在的宿主的name，必须是唯一的
     * @param layout 需要加载的布局的id
     */
    public void preloadView(String hostName, int layout){
        BaseTask baseTask = new BaseTask(hostName, layout);
        preloader.load(baseTask);
        preloadedViews.put(hostName, baseTask);
    }


    /**
     * 获取一个已经加载过的task
     * @param hostName
     * @return 已经加载过的task对象，不存的话返回null
     */
    public BaseTask getPreloadedTask(String hostName){
        if(!preloadedViews.containsKey(hostName)){
            return null;
        }

        try {
            BaseTask task = preloadedViews.get(hostName);
            return task;
        }catch (ClassCastException e){
            return null;
        }
    }

    /**
     * 根据一个host的实例取出已经预加载过的对应的view
     * @param hostName host 的名字
     * @return 预加载的view实体，没有预加载的话返回null
     */
    public View getPreloadedView(String hostName){
        BaseTask baseTask = getPreloadedTask(hostName);
        if(baseTask == null){
            return null;
        }

        return baseTask.getRootView();
    }
}
