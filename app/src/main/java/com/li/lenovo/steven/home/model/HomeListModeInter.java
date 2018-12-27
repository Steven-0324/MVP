package com.li.lenovo.steven.home.model;

import android.util.Log;

import com.li.lenovo.steven.network.MyAsyncTask;

public class HomeListModeInter implements IHomeListModelnter {
    ModuleInterface moduleInterface;

    public HomeListModeInter(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    @Override
    public void getdata(final String url) {
        new Runnable() {
            @Override
            public void run() {
                new MyAsyncTask<String>(url, "GET").setTaskListeners(new MyAsyncTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result:=== "+t);
                        if (t != null) {
                            moduleInterface.LoadSuccess(t);
                        } else {
                            moduleInterface.LoadFailed();
                        }
                    }
                });
            }
        }.run();
    }

    public interface ModuleInterface {
        //获取数据状态回调的接口
        void LoadSuccess(String data);

        void LoadFailed();
    }
}
