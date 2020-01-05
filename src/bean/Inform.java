package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Inform implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sno;
	private Timestamp sendTime;
	private String title;
	private String txt;
	private int type;
	
	public Inform() {}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno=sno;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime=sendTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt=txt;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type=type;
	}
}
