package com.carter.test;

import com.carter.utils.Base64Util;
import com.carter.utils.FileUtil;
import com.carter.utils.HttpUtil;

import java.net.URLEncoder;

public class Test {
    /*public static String advancedGeneral() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
        try {
            // 本地文件路径
            String filePath = "D://timg.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.13725b1da233b1691b77ec816ff2a068.2592000.1573606982.282335-17494867";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String result = advancedGeneral();
        System.out.println(result);
    }*/
}
