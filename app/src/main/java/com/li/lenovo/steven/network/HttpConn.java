package com.li.lenovo.steven.network;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConn {
    public static String gethttp(Context context, String mpath, String mrm) {
        String messages = "";
        try {
            URL url = new URL(mpath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(mrm);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            //获得页面数据
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            //创建判断条件
            String len = "";
            while ((len = reader.readLine()) != null) {
                messages += len;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }
}
