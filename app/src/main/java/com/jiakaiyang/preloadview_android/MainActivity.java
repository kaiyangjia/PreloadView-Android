package com.jiakaiyang.preloadview_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiakaiyang.preloadview.dispatch.PreloadManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init(){
        Button btnPreload = (Button) findViewById(R.id.btn_preload);
        Button btnNormal = (Button) findViewById(R.id.btn_normal);
        Button btnPreloadStart = (Button) findViewById(R.id.btn_preload_start);
        txtMsg = (TextView) findViewById(R.id.preload_msg);

        btnPreload.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnPreloadStart.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, TestPreloadActivity.class);
        switch (v.getId()){
            case R.id.btn_preload:
                PreloadManager.getInstance(getApplicationContext()).preloadView("test", R.layout.test_layout);
                txtMsg.setText("OK");
                break;
            case R.id.btn_normal:
                intent.putExtra("flag", "normal");
                startActivity(intent);
                break;
            case R.id.btn_preload_start:
                intent.putExtra("flag", "preload");
                startActivity(intent);
                break;
        }
    }
}
