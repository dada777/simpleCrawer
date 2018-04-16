
import java.io.*;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DouyuCrawer {


    private static List<String> imageList = new ArrayList<>();

    public static void main(String[] args) {

        get("https://www.douyu.com/directory/game/yz");

    }


    private static void get(String url) {
        //获取Url 地址   对象
        String imageAddress = null;

        BufferedReader in = null;

        String address = "E://crawlPicture/";

        String result = "";

        String line;

        StringBuilder sb ;

        try {
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据

            while ((line = in.readLine()) != null) {
                //遍历抓取到的每一行并将其存储到result里面
                result += line + "\n";
            }

            Pattern pattern = Pattern.compile("original=\"(.+jpg)");

            Matcher matcher = pattern.matcher(result);

            while (matcher.find()) {
                // 打印出结果
                imageAddress = matcher.group(1);
                imageList.add(imageAddress);
            }



            for (int i = 0; i < imageList.size(); i++) {

                sb =new StringBuilder(); //This should be ...optimize

                imageAddress = imageList.get(i);

                sb.append(address).append(i).append(".jpg");

                ImageRequest.getURL(imageAddress, sb.toString());

            }


        } catch (Exception e) {

            e.printStackTrace();
        }
        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }












        }







    //匹配地址

    //



