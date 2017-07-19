package entity;

public class Message {
	private int code;
	private String text;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message() {
	}

	/**
	 * @param code
	 * @param text
	 */
	public Message(int code, String text) {
		this.code = code;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", text=" + text + "]";
	}

}
