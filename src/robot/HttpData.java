package robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpData{

	private final String URL = "http://www.tuling123.com/openapi/api?key=yourkey&info=";
	private HttpURLConnection conn;
	private DataListener listener;

	public HttpData(DataListener listener) {
		this.listener = listener;
	}
	
	public void getResponseData(String question) {
		try {
			conn = (HttpURLConnection) new URL(URL + question).openConnection();
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			in.close();
			listener.getData(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
	}
	
	
	
	
}
