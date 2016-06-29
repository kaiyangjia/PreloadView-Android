package com.jiakaiyang.preloadview.entity;


import android.support.v4.app.Fragment;

/**
 * host是Fragment的task，使用的是android.support.v4.app.Fragment
 */
public class FragmentTaskV4 extends BaseTask{
    private Fragment host;

    public FragmentTaskV4(String hostName, int layout) {
        super(hostName, layout);
    }
}
