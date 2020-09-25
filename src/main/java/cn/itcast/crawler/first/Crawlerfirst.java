package cn.itcast.crawler.first;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class Crawlerfirst {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //输入网址
        HttpGet httpGet = new HttpGet("https://m.douban.com/movie/");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        //发起请求 返回响应httpclient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);


        //解析响应
        //判断状态码
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(content);

        }

    }
}
