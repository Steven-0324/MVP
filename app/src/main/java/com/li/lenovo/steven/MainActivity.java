package com.li.lenovo.steven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        findViewById(R.id.mButtond).setOnClickListener(this);
        findViewById(R.id.mButtonz).setOnClickListener(this);
        EditText mEditTextp = findViewById(R.id.mEditTextp);
        EditText mEditTextz = findViewById(R.id.mEditTextz);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mButtond:
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                break;
            case R.id.mButtonz:
                startActivity(new Intent(MainActivity.this, ZhuCeActivity.class));
                break;
        }
    }
}
