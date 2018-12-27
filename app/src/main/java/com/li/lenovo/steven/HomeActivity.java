package com.li.lenovo.steven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.li.lenovo.steven.home.model.HomeListModeInter;
import com.li.lenovo.steven.home.presenter.HomeListPresenter;
import com.li.lenovo.steven.home.view.IHomeListView;

public class HomeActivity extends AppCompatActivity implements IHomeListView {
    private TextView hTextView;
    private HomeListPresenter homeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //获取控件
        hTextView = findViewById(R.id.hTextView);
        //初始化presenter
        homeListPresenter = new HomeListPresenter(this);
        homeListPresenter.getmodeldata();
    }

    @Override
    public void getviewdata(String mViewData) {
        hTextView.setText(mViewData);
    }
}
