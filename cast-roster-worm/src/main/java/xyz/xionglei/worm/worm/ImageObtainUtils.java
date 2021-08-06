package xyz.xionglei.worm.worm;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageObtainUtils {
    /**
     * 获取网页源码
     *
     * @param urlPath url路径
     * @return 网页代码
     * @throws IOException e
     */
    public static String getHtml(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        // 打开输入流
        InputStream in = url.openStream();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, "gbk"))) {
            // 读取元源码, 存入StringBuilder
            String msg;
            while ((msg = reader.readLine()) != null) {
                sb.append(msg);
            }
        }
        return sb.toString();
    }

    /**
     * 获取网页源码中的图片的地址
     *
     * @param html 网页源码
     * @return src 地址
     */
    public static Set<String> getUrl(String html) {
        // 使用正则表达式匹配<img> 标签
        String img = "<img[\\s\\S]{10,200}alt=\"([^\"]{1,50})\"\\ssrc=\"([^\"]{1,200})>";
        // 获取Mather对象
        Matcher matcher = Pattern.compile(img).matcher(html);
        Set<String> set = new HashSet<>();
        // Map<String, String> map = new HashMap<>();
        while (matcher.find()) {
            // map.put(matcher.group(1), matcher.group(2));
            set.add(matcher.group(2));
        }
        return set;
    }

    /**
     * 下载一张图片
     *
     * @param url     图片url
     * @param outPath 图片保存地址
     * @param imgName 图片保存名称
     * @throws IOException e
     */
    public static void downOneImg(String url, String outPath, String imgName) throws IOException {
        // 建立流下载
        try (InputStream inputStream = new URL(url).openStream();
             // 定义一个图片保存的路径
             OutputStream outputStream = new FileOutputStream(outPath + "/" + imgName + url.substring(url.lastIndexOf(".")));) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        }
    }

    /**
     * 下载图片
     *
     * @param set 图片src
     */
    public static void download(Set<String> set, String storePath) {
        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        AtomicInteger i = new AtomicInteger(1);
        set.forEach(s -> {
            String imgName = "img-" + String.format("%03d", i.getAndIncrement());
            threadPool.execute(() -> {
                try {
                    downOneImg(s, storePath, imgName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public static void obtainImage(String url, String storePath) throws IOException {
        if (url == null || storePath == null) {
            throw new IOException("url路径与storePath不能为空");
        }
        Set<String> set = getUrl(getHtml(url));// 获取网页中所有图片的url
        download(set, storePath);
    }


}
