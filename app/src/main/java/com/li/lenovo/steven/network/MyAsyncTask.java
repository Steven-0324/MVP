package com.li.lenovo.steven.network;

import android.content.Context;
import android.os.AsyncTask;

public class MyAsyncTask<T> extends AsyncTask<T, T, String> {

    private TaskListeners taskListeners;
    Context context;
    String mPath;
    String mRam;

    //构造方法
    public MyAsyncTask(String mPath, String mRam) {
        this.mPath = mPath;
        this.mRam = mRam;
    }

    //获取接口
    public MyAsyncTask setTaskListeners(TaskListeners taskListeners) {
        this.taskListeners = taskListeners;
        return this;
    }

    @Override
    protected String doInBackground(T... ts) {
        return HttpUrlUtils.gethttpcon(mPath, mRam);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null) {
            //实现接口的方法
            taskListeners.result(s);
        }
    }

    //定义接口
    public interface TaskListeners {
        void result(String t);
    }
}
