package com.li.lenovo.steven.home.presenter;

import android.util.Log;

import com.li.lenovo.steven.HomeActivity;
import com.li.lenovo.steven.api.Api;
import com.li.lenovo.steven.home.model.HomeListModeInter;

public class HomeListPresenter implements IHomeListPresenter, HomeListModeInter.ModuleInterface {
    HomeActivity hview;
    private final HomeListModeInter homeListModeInter1;


    //构造器
    public HomeListPresenter(HomeActivity hview) {
        this.hview = hview;
        homeListModeInter1 = new HomeListModeInter(this);
    }

    //Presenter的接口类
    @Override
    public void getmodeldata() {
        //回调model
        homeListModeInter1.getdata(Api.SHOPLIST);
    }

    //Mode的接口文件
    @Override
    public void LoadSuccess(String data) {
        hview.getviewdata(data);
    }

    @Override
    public void LoadFailed() {
        hview.getviewdata("加载失败");
    }
}
