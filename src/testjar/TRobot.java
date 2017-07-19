package testjar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TRobot{
	//模拟浏览器抓取网页
	public static void main(String[] args) {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL("http://www.baidu.com").openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
			Map<String,List<String>> headers = conn.getRequestProperties();	//必需在connect()方法之前调用
			int code =conn.getResponseCode();	//隐含调用了getInputStream()-->connect();
			String message =conn.getResponseMessage();
			Object obj =conn.getContent();
			InputStream in=conn.getInputStream();
			
			File f = new File("xx.html");
			FileOutputStream foStream =new FileOutputStream(f);
			int a;
			while (( a =in.read())!=-1) {
				foStream.write(a);
			}
			//headers
			Set<String> keys=headers.keySet();
			for (String key : keys) {
				List<String> values =headers.get(key);
				for (String value : values) {
					System.out.println(key+":"+value);
				}
			}
			System.out.println("code:"+code);
			System.out.println("message:"+message);
//			System.out.println("info:"+sb.toString());
		
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}