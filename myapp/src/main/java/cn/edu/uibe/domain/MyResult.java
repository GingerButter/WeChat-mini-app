package cn.edu.uibe.domain;

public class MyResult {
    private String msg;
    private int code;
	
	public MyResult(String msg) {
		this.msg=msg;
	}
	public MyResult(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
