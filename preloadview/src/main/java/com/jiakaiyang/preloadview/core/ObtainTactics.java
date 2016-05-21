package com.jiakaiyang.preloadview.core;

/**
 * 使用策略
 */
public class ObtainTactics {


    /**
     * 优先使用预加载的view tree
     * 如果预加载的view tree存在，那么久使用，如果不存在就使用指定的layout进行传统的方法进行显示
     * 默认的策略
     */
    static final int PRIORITY_PRELOAD = 0;


    /**
     * 总是使用预加载的view tree
     * 如果预加载的view tree存在，那么就使用，如果不存在就阻塞线程，知道预加载的view tree存在再使用
     */
    static final int ALWAYS_PRELOAD = 1;


    /**
     * 总是使用layout进行传统方法的加载，不使用预加载。
     * 多用于对比测试
     */
    static final int ALWAYS_LAYOUT = 2;
}
