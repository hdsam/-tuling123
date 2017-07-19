package robot;
import org.json.JSONObject;

import entity.Message;

public class Client implements DataListener {

	public void execute(String question) {
		HttpData hd = new HttpData(this);
		hd.getResponseData(question);
	}

	//回调
	@Override
	public void getData(String data) {
		parseData(data);//do something else;
	}

	private Message parseData(String data) {
		JSONObject json = new JSONObject(data);
		int resultCode = json.getInt("code");
		String resultText = json.getString("text");
		return new Message(resultCode, resultText);
	}

	public static void main(String[] args) {
		new Client().execute("scjp认证是什么");
	}

}
