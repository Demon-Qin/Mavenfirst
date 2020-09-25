package com;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class CrawlerDouban {
   public static void main(String[] args) throws IOException {
       CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpGet httpGet =new HttpGet("https://m.douban.com/movie/");
       httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);
       if(response.getStatusLine().getStatusCode()==200){
           HttpEntity httpEntity = response.getEntity();
           String content = EntityUtils.toString(httpEntity,"utf-8");
           System.out.println(content);
       }

   }
}
