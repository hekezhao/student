package bean;

import java.io.Serializable;

public class Class implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cno;
	private String cname;
	private String term;
	private String sno;
	private String tno;
	private String tname;
	
	public Class() {}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno=cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname=cname;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname=tname;
	}
}
	
