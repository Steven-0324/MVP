package com.li.lenovo.steven.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrlUtils {
    public static String gethttpcon(String mPath, String mRam) {
        String message = "";
        try {
            URL url = new URL(mPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(mRam);
            connection.setConnectTimeout(5 * 1000);
            connection.setReadTimeout(5 * 1000);
            //数据流处理
            if (connection.getResponseCode() == 200) {
                //获取输入流
                InputStream inputStream = connection.getInputStream();
                //读取输入流
                byte[] b = new byte[1024 * 1024];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int len = 0;
                while ((len = inputStream.read(b)) > -1) {
                    baos.write(b, 0, len);
                }
                message = baos.toString();
                inputStream.close();
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
