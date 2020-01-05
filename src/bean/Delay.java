package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Delay implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cno;
	private String term;
	private String sno;
	private String tno;
	private Timestamp sendTime;
	private String workTitle;
	private String reason;
	private String delayDays;
	private String allow;
	
	public Delay() {}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno=cno;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term=term;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno=sno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno=tno;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime=sendTime;
	}
	public String getWorkTitle() {
		return workTitle;
	}
	public void setWorkTitle(String workTitle) {
		this.workTitle=workTitle;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason=reason;
	}
	public String getDelayDays() {
		return delayDays;
	}
	public void setDelayDays(String delayDays) {
		this.delayDays=delayDays;
	}
	public String getAllow() {
		return allow;
	}
	public void setAllow(String allow) {
		this.allow=allow;
	}
}
