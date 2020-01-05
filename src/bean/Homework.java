package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Homework implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cno;
	private String term;
	private String sno;
	private String tno;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String title;
	private String txt;
	private String answer;
	private String reply;
	private double score;
	private String filepath;
	
	public Homework() {}
	
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
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime=beginTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime=endTime;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer=answer;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply=reply;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score=score;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath=filepath;
	}
}
