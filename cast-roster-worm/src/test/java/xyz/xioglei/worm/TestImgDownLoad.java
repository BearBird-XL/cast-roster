package xyz.xioglei.worm;

import xyz.xionglei.worm.worm.ImageObtainUtils;

import java.io.IOException;

public class TestImgDownLoad {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String url = "https://tupian.gq/373.html";
        String storePath = "C:\\Users\\lei\\Desktop\\worm-down";
        ImageObtainUtils.obtainImage(url, storePath);
        long end = System.currentTimeMillis();
        System.out.println("下载成功, 耗时" + (end - start) + "(ms)");
    }
}
