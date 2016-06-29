package com.jiakaiyang.preloadview.entity;

import android.app.Fragment;

/**
 * host是Fragment的task，使用的是android.app.Fragment
 */
public class FragmentTask extends BaseTask{
    private Fragment host;

    public FragmentTask(String hostName, int layout) {
        super(hostName, layout);
    }
}
