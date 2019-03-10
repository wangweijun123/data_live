package com.example.administrator.livedatabinding;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.Random;

public class MainViewModel extends AndroidViewModel {

    // ViewModel 什么叫做数据双向绑定, live data, 把数据放入livedata, UI层
    // 使用vm.input 使用livedata<T> 保存，
    public final MutableLiveData<String> input = new MutableLiveData<>();
    public final MutableLiveData<String> include_string = new MutableLiveData<>();
//    public String input;
//    public String include_string;

    Handler handler;

    public String commonString;
    public String observableString;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public void onClick() {
        Random random = new Random();
        input.setValue(random.nextInt(100) + "");
        include_string.setValue(random.nextInt(100) + "");

        commonString = "变了吗";//
//        input = random.nextInt(100) + "";
//        include_string = random.nextInt(100) + "";

    }

    public void onAsyncClick() {
        final Random random = new Random();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                input.setValue(random.nextInt(100) + "async");
                include_string.setValue(random.nextInt(100) + "async");

            }
        }, 5000);
    }
}
