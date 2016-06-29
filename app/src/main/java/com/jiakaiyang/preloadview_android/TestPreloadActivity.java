package com.jiakaiyang.preloadview_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.jiakaiyang.preloadview.dispatch.PreloadManager;

/**
 * 测试预加载功能的页面
 */
public class TestPreloadActivity extends AppCompatActivity {
    private long startTime;
    private String startType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startTime = System.currentTimeMillis();
        if("preload".equals(getIntent().getStringExtra("flag"))){
            startType="preload start : ";
            preloadInit();
        }else{
            normalInit();
            startType="normal start : ";
        }
    }

    private void preloadInit(){
        View view = PreloadManager.getInstance(getApplicationContext()).getPreloadedView("test");
        if (view.getParent() != null){
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
        setContentView(view);
    }

    private void normalInit(){
        setContentView(R.layout.test_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView txtMsg = (TextView) findViewById(R.id.preload_msg);
        long time = System.currentTimeMillis() - startTime;
        txtMsg.setText(startType + " " + time + "ms");
    }
}
