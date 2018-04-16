import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
public class ImageRequest {

    private static URL url;


    public static void getURL(String address ,String Filename) throws  Exception {

        //new一个URL对象

        url = new URL(address);
        //打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置请求方式为"GET"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();

        File imageFile = new File(Filename);
        //创建输出流
        FileOutputStream outStream = new FileOutputStream(imageFile);
        //写入数据
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = new byte[1024];

        int length=-1;


        while ((length=inStream.read(data))!=-1){

            outStream.write(data,0,length);

        }
        outStream.close();
    }
}