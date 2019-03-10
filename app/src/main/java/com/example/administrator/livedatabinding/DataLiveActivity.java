package com.example.administrator.livedatabinding;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.livedatabinding.databinding.ActivityDataLiveBinding;

public class DataLiveActivity extends AppCompatActivity {
    ActivityDataLiveBinding activityDataLiveBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 根据布局文件xml生成 xxxxBinding.java, binding中有view控件
        activityDataLiveBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_live);
//        activityDataLiveBinding.btn
        // 实例化ViewModel，这里是直接new
        MainViewModel mainViewModel = new MainViewModel(getApplication());
        // bataLveBing 与  ViewModel 关联
        activityDataLiveBinding.setViewModel(mainViewModel);
        activityDataLiveBinding.setLifecycleOwner(this);
        activityDataLiveBinding.setActivity(this);

        mainViewModel.input.setValue("this input str");
        mainViewModel.commonString = "this is common string";

        mainViewModel.input.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i("wangweijun", "onchanged s :"+s);
            }
        });
    }

    public void callActivity() {
        Log.i("wangweijun", "call callActivity");
    }
}
